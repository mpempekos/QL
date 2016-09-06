package org.uva.sea.ql.ast.statement;


public interface StatementVisitor {

	public void visitComputedQuestion(ComputedQuestion computedQuestion);
	public void visitQuestion(Question question);
	public void visitIfStatement(IfStatement ifStatement);	
}