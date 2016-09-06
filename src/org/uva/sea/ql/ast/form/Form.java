package org.uva.sea.ql.ast.form;


import org.uva.sea.ql.ast.block.Block;
import org.uva.sea.ql.ast.node.*;

public class Form extends ASTNode {
	
	private final String id;
	private final Block block;
	
	
	public Form(String id,Block block, CodeFragment fragment) {
		super(fragment);
		this.id = id;
		this.block = block;		
	}
	
	public String getId() {
		return this.id;
	}
	
	public Block getBlock() {
		return this.block;
	}
	
	
	public void accept(FormVisitor formVisitor) {
		formVisitor.visitForm(this);
	}
	
}