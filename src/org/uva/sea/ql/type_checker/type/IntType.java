package org.uva.sea.ql.type_checker.type;

import org.uva.sea.ql.ast.node.CodeFragment;
import org.uva.sea.ql.ast.statement.Question;

public class IntType extends Type {

	public IntType(CodeFragment fragment) {
		super(fragment, "int");
	}
	
	public IntType() {
		super(new CodeFragment(-1, -1), "int");
	}
	
	public <T> T  accept(TypeVisitor visitor, Question question) {
		return  (T) visitor.visit(this, question);
	}
	
}