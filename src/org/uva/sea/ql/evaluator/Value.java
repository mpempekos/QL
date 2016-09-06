package org.uva.sea.ql.evaluator;	////////

public abstract class Value {

	
	public abstract Object getValue();
	
	public boolean isDefined () {
		return true;
	}
	
	public Value not() {
		return new UndefinedValue();
	}
	
	public Value positive() {
		return new UndefinedValue();
	}
	
	public Value negative() {
		return new UndefinedValue();
	}
	
	public Value add(Value value) {
		return new UndefinedValue();
	}
	
	public Value addInt(IntValue value) {
		return new UndefinedValue();
	}
	
	public Value addStr(StrValue value) {
		return new UndefinedValue();
	}	
	
	public Value sub(Value value) {
		return new UndefinedValue();
	}
	
	public Value subInt(IntValue value) {
		return new UndefinedValue();
	}
	
	public Value div(Value value) {
		return new UndefinedValue();
	}
	
	public Value divInt(IntValue value) {
		return new UndefinedValue();
	}
	
	public Value mul(Value value) {
		return new UndefinedValue();
	}
	
	public Value mulInt(IntValue value) {
		return new UndefinedValue();
	}
	
	public Value and(Value value) {
		return new UndefinedValue();
	}
	
	public Value andBool(BoolValue value) {
		return new UndefinedValue();
	}
	
	public Value or(Value value) {
		return new UndefinedValue();
	}
	
	public Value orBool(BoolValue value) {
		return new UndefinedValue();
	}
	
	public Value equal(Value value) {
		return new UndefinedValue();
	}
	
	public Value equalInt(IntValue value) {
		return new UndefinedValue();
	}
	
	public Value equalBool(BoolValue value) {
		return new UndefinedValue();
	}
	
	public Value equalStr(StrValue value) {
		return new UndefinedValue();
	}
	
	
	public Value notEqual(Value value) {
		return new UndefinedValue();
	}
	
	public Value notEqualInt(IntValue value) {
		return new UndefinedValue();
	}
	
	public Value notEqualBool(BoolValue value) {
		return new UndefinedValue();
	}
	
	public Value notEqualStr(StrValue value) {
		return new UndefinedValue();
	}
	
	public Value less(Value value) {
		return new UndefinedValue();
	}
	
	public Value lessInt(IntValue value) {
		return new UndefinedValue();
	}
	
	public Value lessOrEqual(Value value) {
		return new UndefinedValue();
	}
	
	public Value lessOrEqualInt(IntValue value) {
		return new UndefinedValue();
	}
	
	public Value greater(Value value) {
		return new UndefinedValue();
	}
	
	public Value greaterInt(IntValue value) {
		return new UndefinedValue();
	}
	
	public Value greaterOrEqual(Value value) {
		return new UndefinedValue();
	}
	
	public Value greaterOrEqualInt(IntValue value) {
		return new UndefinedValue();
	}
	
}