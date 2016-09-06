package org.uva.sea.ql.type_checker.type;

import org.uva.sea.ql.ast.node.CodeFragment;
import org.uva.sea.ql.ast.statement.Question;

public class UndefinedType extends Type {

	public UndefinedType(CodeFragment fragment) {
		super(fragment, "Undefined");
	}
	
	public UndefinedType() {
		super(new CodeFragment(-1, -1), "Undefined");
	}

	public <T> T  accept(TypeVisitor visitor, Question question) {
		return null;
	}
	

}