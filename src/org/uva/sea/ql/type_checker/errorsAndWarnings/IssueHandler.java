package org.uva.sea.ql.type_checker.errorsAndWarnings;

import java.util.ArrayList;
import java.util.List;


public class IssueHandler {

	private final List<ASTIssue> errors;
	private final List<ASTIssue> warnings;
	
	public IssueHandler() {
		this.errors = new ArrayList<ASTIssue>();
		this.warnings = new ArrayList<ASTIssue>();
	}
	
	public void addError(ASTIssue astIssue) {
		this.errors.add(astIssue);
	}
	
	public void addWarning(ASTIssue astIssue) {
		this.warnings.add(astIssue);
	}
	
	public boolean hasNoErrors() {
		return errors.isEmpty();
	}
	
	public List<ASTIssue> getErrors() {
		return this.errors;
	}
	
	public List<ASTIssue> getWarnings() {
		return this.warnings;
	}
	
}
