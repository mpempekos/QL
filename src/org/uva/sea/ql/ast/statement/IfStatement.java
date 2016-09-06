package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.block.Block;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.node.CodeFragment;
import org.uva.sea.ql.gui.CollectIfExpressionsVisitor;

public class IfStatement extends Statement {

	private final Expression expression;
	private final Block block;
	
	public IfStatement(Expression expression, Block block, CodeFragment fragment) {
		super(fragment);
		this.expression = expression;
		this.block = block;
	}
	
	public Expression getExpression() {
		return this.expression;
	}
	
	public Block getBlock() {
		return this.block;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visitIfStatement(this);
		
	}

	@Override
	public void accept(CollectIfExpressionsVisitor visitor,
			Expression expression) {
		visitor.visitIfStatement(this, expression);
		
	}

	
}