package org.uva.sea.ql.ast.expression.Comparison;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.Logical.Binary;
import org.uva.sea.ql.ast.node.CodeFragment;

public class GreaterOrEqual extends Binary {

	public GreaterOrEqual(CodeFragment fragment, Expression rightExpression,
			Expression leftExpression) {
		super(fragment, rightExpression, leftExpression);
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
