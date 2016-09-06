package org.uva.sea.ql.ast.expression.Numerical;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Logical.Binary;
import org.uva.sea.ql.ast.node.CodeFragment;

public abstract class Numerical extends Binary {

	public Numerical(CodeFragment fragment, Expression rightExpression,
			Expression leftExpression) {
		super(fragment, rightExpression, leftExpression);
	}


}
