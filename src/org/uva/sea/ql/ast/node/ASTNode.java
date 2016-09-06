package org.uva.sea.ql.ast.node;

public class ASTNode {
	
	private final CodeFragment fragment;
	
	public ASTNode(CodeFragment fragment) {
		this.fragment = fragment;
	}
	
	
	public CodeFragment getCodeFragment() {
		return this.fragment;
	}
}