package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.node.CodeFragment;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.Literal.Identifier;
import org.uva.sea.ql.gui.CollectIfExpressionsVisitor;
import org.uva.sea.ql.type_checker.type.Type;

public class ComputedQuestion extends Question {
	
	private final Expression expression;
	
	
	public ComputedQuestion(CodeFragment fragment,Identifier id, String label, Type type, Expression expression ) {
		super(id, label, type, fragment);
		this.expression = expression;
	}
	
	public Expression getExpression() {
		return this.expression;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visitComputedQuestion(this);
	}
	
	@Override
	public void accept(CollectIfExpressionsVisitor visitor, Expression expression) {
		visitor.visitComputedQuestion(this, expression);
	}
	
}