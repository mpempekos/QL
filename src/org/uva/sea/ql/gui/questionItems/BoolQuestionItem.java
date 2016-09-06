package org.uva.sea.ql.gui.questionItems;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.evaluator.Value;

public class BoolQuestionItem extends  QuestionItem {
	
	private JCheckBox checkBox;

	public BoolQuestionItem(Question question, JCheckBox checkBox2) {
		super(question);
		this.checkBox = checkBox2;
		addToPanel(checkBox);
	}


	@Override
	public void setContentOfWidget(Value value) {
		this.checkBox.setSelected((boolean) value.getValue());
	}

	@Override
	public void setWidgetNonEditable() {
		this.checkBox.setEnabled(false);
	}

	@Override
	public JComponent getComponent() {
		return this.checkBox;
	}

}
