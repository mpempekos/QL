package org.uva.sea.ql.type_checker.errorsAndWarnings;

import org.uva.sea.ql.ast.node.ASTNode;

public class ASTIssue {

	private final ASTNode node;
	private final String errorMessageString;
	
	public ASTIssue(ASTNode node, String errorString) {
		this.node = node;
		this.errorMessageString = errorString;
	}

	public ASTNode getNode() {
		return node;
	}

	public String getErrorMessageString() {
		return errorMessageString;
	}
	
	public String printError() {
		//System.out.println("Error   @line" + node.getCodeFragment().getStart() + ": " + errorMessageString);		//fix
		//System.out.println(errorMessageString);
		return "Error   @line" + node.getCodeFragment().getStart() + ": " + errorMessageString;
	}
	
	public String printWarning() {
		//System.out.println("Warning @line" + node.getCodeFragment().getStart() + ": " + errorMessageString);		//fix
		//System.out.println(errorMessageString);
		return "Warning @line" + node.getCodeFragment().getStart() + ": " + errorMessageString;
	}
}
