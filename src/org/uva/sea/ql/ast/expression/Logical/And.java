package org.uva.sea.ql.ast.expression.Logical;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.node.CodeFragment;

public class And extends Binary {
	
	private final static int DUMMY_LINE = -1;

	public And(CodeFragment fragment, Expression rightExpression,
			Expression leftExpression) {
		super(fragment, rightExpression, leftExpression);
	}
	
	public And(Expression rightExpression,
			Expression leftExpression) {
		super(new CodeFragment(DUMMY_LINE, DUMMY_LINE), rightExpression, leftExpression);
	}
	

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	
}
