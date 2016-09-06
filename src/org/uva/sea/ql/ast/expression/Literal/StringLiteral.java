package org.uva.sea.ql.ast.expression.Literal;

import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.node.CodeFragment;

public class StringLiteral extends Literal {
	
	private final String value;
	
	
	public StringLiteral(CodeFragment fragment, String value) {
		super(fragment);
		this.value = value;
	}
	
	public StringLiteral(String value) {
		super(new CodeFragment(DUMMY_LINE, DUMMY_LINE));
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return this.value;
	}

}
