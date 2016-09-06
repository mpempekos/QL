package org.uva.sea.ql.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.miginfocom.swing.MigLayout;
import org.uva.sea.ql.ast.block.Block;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.Literal.Identifier;
import org.uva.sea.ql.ast.expression.Logical.And;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormVisitor;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluator.BoolValue;
import org.uva.sea.ql.evaluator.Evaluator;
import org.uva.sea.ql.evaluator.IntValue;
import org.uva.sea.ql.evaluator.StrValue;
import org.uva.sea.ql.evaluator.UndefinedValue;
import org.uva.sea.ql.evaluator.Value;
import org.uva.sea.ql.gui.helpers.CollectAndInitializeIdentifiers;
import org.uva.sea.ql.gui.questionItems.BoolQuestionItem;
import org.uva.sea.ql.gui.questionItems.IntQuestionItem;
import org.uva.sea.ql.gui.questionItems.QuestionItem;
import org.uva.sea.ql.gui.questionItems.StrQuestionItem;
import org.uva.sea.ql.type_checker.type.BoolType;
import org.uva.sea.ql.type_checker.type.IntType;
import org.uva.sea.ql.type_checker.type.StrType;
import org.uva.sea.ql.type_checker.type.Type;
import org.uva.sea.ql.type_checker.type.TypeVisitor;
import org.uva.sea.ql.type_checker.type.UndefinedType;


public class GUIBuilder implements FormVisitor, CollectIfExpressionsVisitor, TypeVisitor<QuestionItem> {
	
	private final static int GUI_HEIGHT = 600;
	private final static int GUI_WIDTH = 600;
	
	private JFrame frame;
	private JPanel mainPanel;
	private Evaluator evaluator;	
	
	private final LinkedHashMap<ComputedQuestion, QuestionItem> computedQuestionsItemsMap;
	private final LinkedHashMap<QuestionItem, Expression> dependentConditions;

	
	public GUIBuilder(Form form) {
		
		CollectAndInitializeIdentifiers identifiers = new CollectAndInitializeIdentifiers(form);
		this.evaluator = new Evaluator(identifiers);
		this.dependentConditions = new LinkedHashMap<QuestionItem, Expression>();
		this.computedQuestionsItemsMap = new LinkedHashMap<ComputedQuestion, QuestionItem>();
		
		buildQuestionItems(form);
		setUpFrame();
	}
	
	private void setUpFrame() {
		this.frame = new JFrame("Questionnaire");
		this.mainPanel = new JPanel();
		mainPanel.setLayout(new MigLayout("al left, gapy 10"));
        JScrollPane scrPane = new JScrollPane(mainPanel);
        frame.getContentPane().add(scrPane);
			
		for (QuestionItem item: dependentConditions.keySet()) {
			Value value = evaluator.evaluateExpression(dependentConditions.get(item));
			
			if (value.isDefined()) {
				if ((boolean) value.getValue())
					addItemToFrame(item);
			}
		}
			
		frame.setSize(GUI_WIDTH, GUI_HEIGHT);
		frame.setVisible(true);
	}
	
	/****************************
	 *** form visitor methods ***
	 ***************************/


	@Override
	public void visitForm(Form form) {
		form.getBlock().accept(this);
	}


	@Override
	public void visitBlock(Block block) {		
		for (Statement statement: block.getStatements()) {
			statement.accept(this,null);
		}		
	}
	
	/************************************
	 *** collectIfExpressions methods ***
	 ***********************************/
		

	@Override
	public void visitComputedQuestion(ComputedQuestion computedQuestion, Expression expression) {	
		Type type = computedQuestion.getType();
		QuestionItem questionItem = type.accept(this,computedQuestion);	
		questionItem.setWidgetNonEditable();
		
		if (expression != null)
			dependentConditions.put(questionItem, expression);
		else
			dependentConditions.put(questionItem, new BooleanLiteral(true));
		
		computedQuestionsItemsMap.put(computedQuestion, questionItem);
	}

	
	@Override
	public void visitQuestion(Question question, Expression expression) {
		Type type = question.getType();	
		QuestionItem questionItem = type.accept(this,question);	
		
		if (expression != null)
			dependentConditions.put(questionItem, expression);
		else
			dependentConditions.put(questionItem, new BooleanLiteral(true));
	}


	@Override
	public void visitIfStatement(IfStatement ifStatement, Expression expression) {
		Block block = ifStatement.getBlock();
		
		for (Statement statement: block.getStatements())  {
			
			if (expression != null)
				statement.accept(this,new And(expression, ifStatement.getExpression()) );
			else
				statement.accept(this,ifStatement.getExpression());
			
		}		
	}
	
	
	/****************************
	 *** type visitor methods ***
	 ***************************/
	
	@Override
	public QuestionItem visit(IntType intType, Question question) {	
		JTextField textField = new JTextField(15);	
		IntDocumentListener listener = new IntDocumentListener(question.getId(),textField);
		textField.getDocument().addDocumentListener(listener);
		return new IntQuestionItem(question,textField,listener);
	}


	@Override
	public QuestionItem visit(BoolType boolType, Question question) {
		JCheckBox checkBox = new JCheckBox();
		BoolActionListener listener = new BoolActionListener(question.getId(), checkBox);
		checkBox.addActionListener(listener);
		return new BoolQuestionItem(question,checkBox);
	}

	
	@Override
	public QuestionItem visit(StrType strType, Question question) {	
		JTextField textField = new JTextField(15);	
		StrDocumentListener listener = new StrDocumentListener(question.getId(),textField);
		textField.getDocument().addDocumentListener(listener);
		return new StrQuestionItem(question,textField,listener);
	}

	@Override
	public QuestionItem visit(UndefinedType undefinedType, Question question) {
		// should not go here...
		return null;
	}
	
	
	/****************************
	 *** helper methods below ***
	 ***************************/
	
	private void buildQuestionItems(Form form) {
		visitForm(form);
	}
	

	private void addItemToFrame (QuestionItem item) {	
		JComponent component = item.getPanel();	
		mainPanel.add(component,"wrap");
	}
	
	
	private void removeItemFromFrame (QuestionItem item) {	
		JComponent component = item.getPanel();	
		mainPanel.remove(component);
	}
	
	
	private void updateEvaluatorAndGui(Identifier identifier, Value value) {
		updateEvaluator(identifier, value);
		updateGUI();	
	}
	
	
	private void updateEvaluator(Identifier identifier, Value value) {
		evaluator.update(identifier,value);
		updateComputedQuestions();
	}
	
	
	private void updateComputedQuestions() {
		for(ComputedQuestion computedQuestion: computedQuestionsItemsMap.keySet()) {
				
			Value value = evaluator.evaluateExpression(computedQuestion.getExpression());
			evaluator.update(computedQuestion.getId(), value);
				
			if (value.isDefined()) {
				//computedQuestionsItemsMap.get(computedQuestion).disableListener();
				computedQuestionsItemsMap.get(computedQuestion).setContentOfWidget(value);	
				//computedQuestionsItemsMap.get(computedQuestion).enableListener();
			}

		}
	}


	private void updateGUI() {
		for (QuestionItem item: dependentConditions.keySet()) {
			
			Value ifConditionsSatisfied = evaluator.evaluateExpression(dependentConditions.get(item));
							
			if ( !ifConditionsSatisfied.isDefined() ) {
				removeItemFromFrame(item);
			}
			
			else {
			
				if ((boolean) ifConditionsSatisfied.getValue())	////
					addItemToFrame(item);
			
				else 
					removeItemFromFrame(item);
			}
				
		}
		
//		frame.revalidate();
//		frame.repaint();
		mainPanel.revalidate();
		mainPanel.repaint();
	}
	
	/*******************************************
	 *** widget creation and listeners below ***
	 *******************************************/
	
	
	public class BoolActionListener implements ActionListener {
		
		private JCheckBox checkBox;
		private Identifier identifier;
		
		public  BoolActionListener(Identifier identifier2, JCheckBox checkBox2) {
			this.checkBox = checkBox2;
			this.identifier = identifier2;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (checkBox.isSelected()) {
				updateEvaluatorAndGui(identifier, new BoolValue(true));
			}
			
			else {
				updateEvaluatorAndGui(identifier, new BoolValue(false));
			}				
			
			checkBox.requestFocus();			
		}
	
	}
	
	
	public class IntDocumentListener implements DocumentListener {
		
		boolean hasBeenModified = false;
		private JTextField textField;
		private Identifier identifier;
		
		public IntDocumentListener(Identifier identifier2, JTextField textField2) {
			this.identifier = identifier2;
			this.textField = textField2;
		}
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			
			textField.requestFocus();	
			
			if  (!hasBeenModified) {
				hasBeenModified = true;
			
			 SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					
					boolean correctInput = true;
					int inputNumber = 0;
					
					try {
						String textString = textField.getText();
						inputNumber = Integer.parseInt(textString);
					}
					
					catch(Exception exception) {
						correctInput = false;
					}
					
					if (correctInput) {
						updateEvaluatorAndGui(identifier, new IntValue(inputNumber));	
					}
				
					else {
						updateEvaluatorAndGui(identifier, new UndefinedValue());
					}
					
					hasBeenModified = false;
					textField.requestFocus();
				}
			 });
			}	
		}	
		

		@Override
		public void insertUpdate(DocumentEvent e) {
			
			textField.requestFocus();	
			
			if (!hasBeenModified) {
				hasBeenModified = true;
								
				SwingUtilities.invokeLater(new Runnable() {
						
				@Override
				public void run() {
					
					boolean correctInput = true;
					int inputNumber = 0;
					
					try {
						String textString = textField.getText();
						inputNumber = Integer.parseInt(textString);
					}
					
					catch(Exception exception) {					///
						System.out.println("Insert a number of max 9 digits!");
						correctInput = false;
					}
					
					if (correctInput) {
						updateEvaluatorAndGui(identifier, new IntValue(inputNumber));	
					}
						
					else {
						updateEvaluatorAndGui(identifier, new UndefinedValue());
					}
	
					hasBeenModified = false;
					textField.requestFocus();
							
				}
			   });
					
			  }
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
		}
	}
	
	public class StrDocumentListener implements DocumentListener {
		
		boolean hasBeenModified = false;
		private JTextField textField;
		private Identifier identifier;
		
		public StrDocumentListener(Identifier identifier2, JTextField textField2) {
			this.identifier = identifier2;
			this.textField = textField2;
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			
			
			textField.requestFocus();	
			
			if  (!hasBeenModified) {
				hasBeenModified = true;
			
				SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					String textString = textField.getText();
					updateEvaluatorAndGui(identifier, new StrValue(textString));
					hasBeenModified = false;
					textField.requestFocus();
				}
				});
			}	
		}	
		

		@Override
		public void insertUpdate(DocumentEvent e) {
			
			textField.requestFocus();	
			
			if (!hasBeenModified) {
				hasBeenModified = true;
								
				SwingUtilities.invokeLater(new Runnable() {
						
				@Override
				public void run() {
					String textString = textField.getText();
					updateEvaluatorAndGui(identifier, new StrValue(textString));
					hasBeenModified = false;
					textField.requestFocus();
							
				}
			   });
					
			  }
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
		}
	}
	
}