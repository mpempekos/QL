package org.uva.sea.ql.ast.expression.Literal;


import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.node.CodeFragment;


public class Identifier extends Literal {
	
	private final String id;
	
	public Identifier(CodeFragment fragment, String id) {
		super(fragment);
		this.id = id;
	}

	public String getValue() {
		return this.id;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Identifier))
			return false;
		
		return ((Identifier) obj).getValue().equals(this.id);
	}

}