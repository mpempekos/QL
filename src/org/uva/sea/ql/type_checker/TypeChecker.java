package org.uva.sea.ql.type_checker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.uva.sea.ql.ast.block.Block;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.Comparison.Equal;
import org.uva.sea.ql.ast.expression.Comparison.Greater;
import org.uva.sea.ql.ast.expression.Comparison.GreaterOrEqual;
import org.uva.sea.ql.ast.expression.Comparison.Less;
import org.uva.sea.ql.ast.expression.Comparison.LessOrEqual;
import org.uva.sea.ql.ast.expression.Comparison.NotEqual;
import org.uva.sea.ql.ast.expression.Literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.Literal.Identifier;
import org.uva.sea.ql.ast.expression.Literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.Literal.StringLiteral;
import org.uva.sea.ql.ast.expression.Logical.And;
import org.uva.sea.ql.ast.expression.Logical.Binary;
import org.uva.sea.ql.ast.expression.Logical.Or;
import org.uva.sea.ql.ast.expression.Numerical.Add;
import org.uva.sea.ql.ast.expression.Numerical.Div;
import org.uva.sea.ql.ast.expression.Numerical.Mul;
import org.uva.sea.ql.ast.expression.Numerical.Sub;
import org.uva.sea.ql.ast.expression.Unary.Negative;
import org.uva.sea.ql.ast.expression.Unary.Not;
import org.uva.sea.ql.ast.expression.Unary.Positive;
import org.uva.sea.ql.ast.expression.Unary.Unary;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormVisitor;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.StatementVisitor;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.type_checker.errorsAndWarnings.ASTIssue;
import org.uva.sea.ql.type_checker.errorsAndWarnings.IssueHandler;
import org.uva.sea.ql.type_checker.type.BoolType;
import org.uva.sea.ql.type_checker.type.IntType;
import org.uva.sea.ql.type_checker.type.StrType;
import org.uva.sea.ql.type_checker.type.Type;
import org.uva.sea.ql.type_checker.type.UndefinedType;


public class TypeChecker implements FormVisitor, StatementVisitor, ExpressionVisitor<Type> {
	
	private final Form form;
	private final IssueHandler issueHandler;
	private final Map<Identifier, IdentifierData> identifiers;
	
	
	public TypeChecker(Form form) {
		this.form = form;
		this.identifiers = new HashMap<>();
		this.issueHandler = new IssueHandler();
	}
	

	public Form getForm() {
		return form;
	}
	
	public boolean formHasNoErrors() {
		return issueHandler.hasNoErrors();
	}	
	
	public void performTypeChecking() {	
		this.visitForm(form);
	}
	
	public List<ASTIssue> getErrors() {
		return issueHandler.getErrors();
	}
	
	// for testing...
	public List<ASTIssue> getWarnings() {
		return issueHandler.getWarnings();
	}
	
	// for testing...
	public Map<Identifier, IdentifierData> getIdentifiers() {
		return this.identifiers;
	}
	
	
	/****************************
	******* Check Methods *******
	*****************************/
	
	
	private boolean hasExpectedType(Binary node, Type expectedType) {

		Expression rightExpression = node.getRightExpression();
		Expression leftExpression = node.getLeftExpression();
		Type leftExprType = leftExpression.accept(this);
		Type rightExpType = rightExpression.accept(this);
		
		if (typeMatches(rightExpType,expectedType) && typeMatches(leftExprType,expectedType)) {
			return true;
		}
				
		return false;
	}
	
	
	private boolean hasExpectedType(Unary node, Type expectedType) {

		Expression expression = node.getExpression();
		Type type = expression.accept(this);
		
		if (typeMatches(type,expectedType) ) {
			return true;
		}
		
		return false;
	}
	

	private boolean typeMatches(Type rightExpType, Type expectedType) {
		return rightExpType.getTypeName().equals(expectedType.getTypeName());
	}
	
	
	private boolean isConditionBooleanType(IfStatement ifStatement) {
		
		Type type = ifStatement.getExpression().accept(this);
		
		if (typeMatches(type, new BoolType())) {
			return true;
		}
		
		return false;
	}
	
	
	private boolean isDeclaredWithDifferentType(Question question) {
		
		Identifier identifier = question.getId();
		
		if (identifiers.keySet().contains(identifier)) {
			
			String identifierString = question.getType().getTypeName();

			IdentifierData identifierData = identifiers.get(identifier);
			
			if (!identifierString.equals(identifierData.getType().getTypeName())) {
				return true;										
			}
			
		}
		
		return false;
	}
	

	private boolean labelIsDuplicate(Question question) {
		
		for(IdentifierData identifierData: identifiers.values()) {
			
			if (identifierData.getLabel().equals(question.getLabel())) {
				return true;
			}

		}
		
		return false;
	}
	
	
	private void insertAtHashMap(Identifier id,String label,Type type) {
		this.identifiers.put(id, new IdentifierData(type,label));
	}
	
	
	
	/****************************
	*********Form Visitor********
	*****************************/
	
	
	@Override
	public void visitForm(Form form) {
		form.getBlock().accept(this);
		
	}

	@Override
	public void visitBlock(Block block) {
		for (Statement statement: block.getStatements()) {
			statement.accept(this);
		}
	}
	

	
	/****************************
	******Statement Visitor******
	*****************************/



	@Override
	public void visitQuestion(Question question) {
		
		if (labelIsDuplicate(question))	{
			this.issueHandler.addWarning(new ASTIssue(question, "The label has already been defined."));
		}
		
		if (isDeclaredWithDifferentType(question)) {
			this.issueHandler.addError(new ASTIssue(question, "Question is declared with different type."));
		}
			
		Identifier identifier = question.getId();
		insertAtHashMap(identifier,question.getLabel(),question.getType());
			
	}
	
	
	@Override
	public void visitComputedQuestion(ComputedQuestion computedQuestion) {
		
		if (labelIsDuplicate(computedQuestion)) {
			this.issueHandler.addWarning(new ASTIssue(computedQuestion, "The label has already been defined."));
		}
		
		if (isDeclaredWithDifferentType(computedQuestion)) {
			this.issueHandler.addError(new ASTIssue(computedQuestion, "Question is declared with different type."));
		}
		
		if (!typeMatches(computedQuestion.getType(), computedQuestion.getExpression().accept(this))) {
			this.issueHandler.addError(new ASTIssue(computedQuestion, "The expression of the computed question is wrong."));
		}
		
		
		DependentVariables dependentVariables = new DependentVariables();
		Set<Identifier> dependencies = computedQuestion.getExpression().accept(dependentVariables);
		
		Identifier identifier = computedQuestion.getId();
		insertAtHashMap(identifier,computedQuestion.getLabel(),computedQuestion.getType());
				
		for (Identifier dependency: dependencies) {
			this.setDependencies(identifier,dependency);
		}

	} 
	

	private void setDependencies(Identifier id, Identifier dependency) {
		IdentifierData idData = identifiers.get(id);
		idData.setDependencies(dependency);
		IdentifierData dependencyData = identifiers.get(dependency);
		
		if (dependencyData != null)
			dependencyData.setDependencies(id);
	}


	@Override
	public void visitIfStatement(IfStatement ifStatement) {
		if (!isConditionBooleanType(ifStatement)) {
			this.issueHandler.addError(new ASTIssue(ifStatement, "The condition of the if-statement is not boolean."));
		}
		
		ifStatement.getBlock().accept(this);
	}

	
	
	/****************************
	**** Expression Visitor *****
	*****************************/	
	

	@Override
	public Type visit(Equal node) {
		
		if (!hasExpectedType(node,new IntType()) && !hasExpectedType(node,new BoolType()) && !hasExpectedType(node,new StrType())) {
			return new UndefinedType();
		}
			
		return new BoolType();
	}

	

	@Override
	public Type visit(NotEqual node) {
		if (!hasExpectedType(node,new IntType()) && !hasExpectedType(node,new BoolType()) && !hasExpectedType(node,new StrType())) {
			return new UndefinedType();
		}
			
		return new BoolType();
	}
	

	@Override
	public Type visit(Greater node) {
		
		if (!hasExpectedType(node,new IntType())) {
			return new UndefinedType();
		}
			
		return new BoolType();
	}
	

	@Override
	public Type visit(GreaterOrEqual node) {
		
		if (!hasExpectedType(node,new IntType())) {
			return new UndefinedType();
		}
			
		return new BoolType();	
	}
	

	@Override
	public Type visit(Less node) {
		
		if (!hasExpectedType(node,new IntType())) {
			return new UndefinedType();
		}
			
		return new BoolType();
	}

	
	@Override
	public Type visit(LessOrEqual node) {
		
		if (!hasExpectedType(node,new IntType())) {
			return new UndefinedType();
		}
		
		return new BoolType();
	}
	

	@Override
	public Type visit(BooleanLiteral node) {
		return new BoolType();
	}

	
	@Override
	public Type visit(Identifier node) {
		
		if (identifiers.containsKey(node)) {
			IdentifierData identifierData = identifiers.get(node);
			return identifierData.getType();
		}
	
		return new UndefinedType();
	}

	
	@Override
	public Type visit(IntegerLiteral node) {
		return new IntType();
	}

	
	@Override
	public Type visit(StringLiteral node) {
		return new StrType();
	}
	
	
	
	@Override
	public Type visit(And node) {	
		
		if (!hasExpectedType(node,new BoolType())) {
			return new UndefinedType();
		}
		
		return new BoolType();
	}
	

	@Override
	public Type visit(Or node) {
		if (!hasExpectedType(node,new BoolType())) {
			return new UndefinedType();
		}
		
		return new BoolType();
	}

	
	@Override
	public Type visit(Add node) {
		
		if (hasExpectedType(node,new IntType())) {
			return new IntType();
		}
		
		if (hasExpectedType(node,new StrType())) {
			return new StrType();
		}
		
		return new UndefinedType();
	}

	
	@Override
	public Type visit(Sub node) {
		
		if (!hasExpectedType(node,new IntType())) {
			return new UndefinedType();
		}
		
		return new IntType();
	}

	
	@Override
	public Type visit(Mul node) {
		
		if (!hasExpectedType(node,new IntType())) {
			return new UndefinedType();
		}
		
		return new IntType();
	}

	
	@Override
	public Type visit(Div node) {
		
		if (!hasExpectedType(node,new IntType())) {
			return new UndefinedType();
		}
		
		return new IntType();
	}
	


	@Override
	public Type visit(Not node) {
		
		if (!hasExpectedType(node,new BoolType())) {
			return new UndefinedType();
		}
		
		return new BoolType();
	}
	

	@Override
	public Type visit(Positive node) {
		
		if (!hasExpectedType(node,new IntType())) {
			return new UndefinedType();
		}
		
		return new IntType();
	}

	
	@Override
	public Type visit(Negative node) {
		
		if (!hasExpectedType(node,new IntType())) {
			return new UndefinedType();
		}
		
		return new IntType();
	}
	
	
}