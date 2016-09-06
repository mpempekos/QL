package org.uva.sea.ql.type_checker.type;

import org.uva.sea.ql.ast.statement.Question;

public interface TypeVisitor<T> {

	public T visit(IntType intType, Question question);
	public T visit(BoolType boolType, Question question);
	public T visit(StrType strType, Question question);
	public T visit(UndefinedType undefinedType, Question question);
	
}
