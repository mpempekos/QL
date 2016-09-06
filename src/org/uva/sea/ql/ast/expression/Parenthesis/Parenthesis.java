package org.uva.sea.ql.ast.expression.Parenthesis;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.node.CodeFragment;


// class to be removed???

public class Parenthesis extends Expression{
	
	private final Expression expression;

	public Parenthesis(CodeFragment fragment,Expression expression) {
		super(fragment);
		this.expression = expression;
	}

	public Expression getExpression() {
		return this.expression;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}