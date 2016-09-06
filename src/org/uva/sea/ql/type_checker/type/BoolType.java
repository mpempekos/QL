package org.uva.sea.ql.type_checker.type;

import org.uva.sea.ql.ast.node.CodeFragment;
import org.uva.sea.ql.ast.statement.Question;

public class BoolType extends Type {
	
	public BoolType(CodeFragment fragment) {
		super(fragment, "boolean");
	}
	
	public BoolType() {
		super(new CodeFragment(-1, -1), "boolean");
	}
	
	public <T> T  accept(TypeVisitor visitor, Question question) {
		return  (T) visitor.visit(this, question);
	}


}
