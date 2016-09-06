package org.uva.sea.ql.evaluator;


public class BoolValue extends Value {
	
	private final Boolean value;
	
	public BoolValue(boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}
	
	@Override
	public Value not() {
		return new BoolValue(!getValue());
	}
	
	@Override
	public Value and(Value value) {
		return value.andBool(this);
	}
	
	@Override
	public Value andBool(BoolValue value) {
		return new BoolValue(value.getValue() && this.getValue());
	}
	
	@Override
	public Value or(Value value) {
		return value.orBool(this);
	}
	
	@Override
	public Value orBool(BoolValue value) {
		return new BoolValue(value.getValue() || this.getValue());
	}
	
	@Override
	public Value equal(Value value) {
		return value.equalBool(this);
	}
	
	@Override
	public Value equalBool(BoolValue value) {
		return new BoolValue(value.getValue().equals(this.value));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof BoolValue))
			return false;
		
		return ((BoolValue) obj).getValue().equals(this.value);
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	
	@Override
	public Value notEqual(Value value) {
		return value.notEqualBool(this);
	}
	
	@Override
	public Value notEqualBool(BoolValue value) {
		return new BoolValue(!(value.getValue().equals(this.value)));
	}
	

}