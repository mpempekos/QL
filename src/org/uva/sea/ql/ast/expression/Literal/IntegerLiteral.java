package org.uva.sea.ql.ast.expression.Literal;

import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.node.CodeFragment;

public class IntegerLiteral extends Literal {
	
	private final Integer value;
	
	
	public IntegerLiteral(CodeFragment fragment, Integer value) {
		super(fragment);
		this.value = value;
	}
	
	public IntegerLiteral(Integer value) {
		super(new CodeFragment(DUMMY_LINE, DUMMY_LINE));
		this.value = value;
	}


	public Integer getValue() {
		return value;
	}
	
	@Override
	public <T> T  accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}


}
