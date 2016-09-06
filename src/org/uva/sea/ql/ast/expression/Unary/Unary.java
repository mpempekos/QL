package org.uva.sea.ql.ast.expression.Unary;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.node.CodeFragment;

public abstract class Unary extends Expression {

	private final Expression expression;	//arg

	public Unary(CodeFragment fragment,Expression expression) {
		super(fragment);
		this.expression = expression;
	}

	public Expression getExpression() {
		return this.expression;
	}

}
