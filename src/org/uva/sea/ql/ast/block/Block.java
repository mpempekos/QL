package org.uva.sea.ql.ast.block;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.form.FormVisitor;
import org.uva.sea.ql.ast.node.ASTNode;
import org.uva.sea.ql.ast.node.CodeFragment;
import org.uva.sea.ql.ast.statement.Statement;

public class Block extends ASTNode {
	
	private final List<Statement> statements;

	public Block(CodeFragment fragment) {
		super(fragment);
		this.statements = new ArrayList<Statement>();
	}

	public List<Statement> getStatements() {
		return this.statements;
	}

	public void accept(FormVisitor formVisitor) {
		formVisitor.visitBlock(this);
	}
	
}