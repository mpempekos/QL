package org.uva.sea.ql.type_checker.type;

import org.uva.sea.ql.ast.node.CodeFragment;
import org.uva.sea.ql.ast.statement.Question;


public class StrType extends Type {

	public StrType(CodeFragment fragment) {
		super(fragment, "str");
	}
	
	public StrType() {
		super(new CodeFragment(-1, -1), "str");
	}
	
	public <T> T  accept(TypeVisitor visitor, Question question) {
		return (T) visitor.visit(this, question);
	}

	
}