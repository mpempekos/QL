package org.uva.sea.ql.gui.questionItems;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.statement.Question;
//import org.uva.sea.ql.gui.widgets.Widget;
import org.uva.sea.ql.evaluator.Value;

public abstract class QuestionItem {

	private Question question;
	private JPanel panel;
	
	public QuestionItem(Question question) {
		this.question =question;
		this.panel = new JPanel();
		panel.setLayout(new MigLayout());
		panel.add(new JLabel(question.getLabel()));
	}
	
	public abstract void setWidgetNonEditable ();
	
	public abstract JComponent getComponent();
	
	public void disableListener(){ };
	
	public void enableListener() { };
	
	public abstract void setContentOfWidget(Value value);
	
	public Question getQuestion() {
		return question;
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public void addToPanel(JComponent component) {
		panel.add(component);		
	}

}
