package org.uva.sea.ql.gui;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;

public interface CollectIfExpressionsVisitor {

	public void visitComputedQuestion(ComputedQuestion computedQuestion, Expression expression);
	public void visitQuestion(Question question, Expression expression);
	public void visitIfStatement(IfStatement ifStatement, Expression expression);
}
