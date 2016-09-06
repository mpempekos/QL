package org.uva.sea.ql.gui.questionItems;

import javax.swing.JComponent;
import javax.swing.JTextField;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.evaluator.Value;
import org.uva.sea.ql.gui.GUIBuilder.IntDocumentListener;

public class IntQuestionItem extends QuestionItem {
	
	private JTextField textField;
	private IntDocumentListener listener;
	
	public IntQuestionItem(Question question, JTextField textField2,
			IntDocumentListener listener2) {
		super(question);
		this.textField = textField2;
		this.listener = listener2;
		addToPanel(textField);
	}

	public void setContentOfWidget(Value value) {
		this.textField.setText(value.getValue().toString());
	}

	@Override
	public void setWidgetNonEditable() {
		this.textField.setEditable(false);
	}

	@Override
	public JComponent getComponent() {
		return this.textField;
	}

	@Override
	public void disableListener() {
		this.textField.getDocument().removeDocumentListener(listener);
	}

	@Override
	public void enableListener() {
		this.textField.getDocument().addDocumentListener(listener);	
	}


}
