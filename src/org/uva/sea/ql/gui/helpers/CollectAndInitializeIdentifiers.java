package org.uva.sea.ql.gui.helpers;

import java.util.HashMap;
import java.util.Map;
import org.uva.sea.ql.ast.block.Block;
import org.uva.sea.ql.ast.expression.Literal.Identifier;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormVisitor;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.StatementVisitor;
import org.uva.sea.ql.evaluator.BoolValue;
import org.uva.sea.ql.evaluator.UndefinedValue;
import org.uva.sea.ql.evaluator.Value;
import org.uva.sea.ql.type_checker.type.BoolType;
import org.uva.sea.ql.type_checker.type.IntType;
import org.uva.sea.ql.type_checker.type.StrType;
import org.uva.sea.ql.type_checker.type.TypeVisitor;
import org.uva.sea.ql.type_checker.type.UndefinedType;

public class CollectAndInitializeIdentifiers implements FormVisitor,StatementVisitor, TypeVisitor<Value> {	// evaluator...

	private Map<Identifier, Value> identifiersAndValues;
	
	public CollectAndInitializeIdentifiers(Form form) {
		this.identifiersAndValues = new HashMap<>();
		visitForm(form);
		//printIdentifiers();
	}
	
	public Map<Identifier, Value> getIdentifiersAndValues () {
		return this.identifiersAndValues;
	}
	
	
	@SuppressWarnings("unused")
	private void printIdentifiers() {
		
		System.out.println("********************************************");
		System.out.println("********* Identifiers Initialized **********");
		for (Identifier id: identifiersAndValues.keySet())
			System.out.println("Identifier " + id.getValue() + " has value: " + identifiersAndValues.get(id).getValue());
	}
	
	private void initializeIdentifier(Identifier id, Value value) {
		
		if (!(identifiersAndValues.containsKey(id)))
			this.identifiersAndValues.put(id, value);
	}
	
	
	/*********************************
	 *** statement_visitor methods ***
	 *********************************/

	@Override
	public void visitComputedQuestion(ComputedQuestion computedQuestion) {
		Value value = computedQuestion.getType().accept(this, computedQuestion);
		initializeIdentifier(computedQuestion.getId(),value);	
	}

	

	@Override
	public void visitQuestion(Question question) {
		Value value = question.getType().accept(this, question);
		initializeIdentifier(question.getId(),value);	
	}


	@Override
	public void visitIfStatement(IfStatement ifStatement) {
		ifStatement.getBlock().accept(this);	
	}

	
	/****************************
	 *** form_visitor methods ***
	 ****************************/

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
	 *** type_visitor methods ***
	 ****************************/

	@Override
	public Value visit(IntType intType, Question question) {
		return new UndefinedValue();
	}

	@Override
	public Value visit(BoolType boolType, Question question) {
		return new BoolValue(false);
	}

	@Override
	public Value visit(StrType strType, Question question) {
		return new UndefinedValue();
	}

	@Override
	public Value visit(UndefinedType undefinedType, Question question) {
		return new UndefinedValue();
	}

}