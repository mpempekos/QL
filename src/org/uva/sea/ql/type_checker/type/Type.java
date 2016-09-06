package org.uva.sea.ql.type_checker.type;

import org.uva.sea.ql.ast.node.ASTNode;
import org.uva.sea.ql.ast.node.CodeFragment;
import org.uva.sea.ql.ast.statement.Question;

public abstract class Type extends ASTNode {
	
	private final String typeName;
	
	public Type(CodeFragment fragment, String typeName) {
		super(fragment);
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}
	
	public abstract <T> T  accept(TypeVisitor visitor, Question question);

}
