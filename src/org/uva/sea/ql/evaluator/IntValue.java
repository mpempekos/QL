package org.uva.sea.ql.evaluator;


public class IntValue extends Value {
	
	private final Integer value;
	
	
	public IntValue(Integer value) {
		this.value = value;
	}


	public Integer getValue() {
		return value;
	}
	
	@Override
	public Value positive() {
		return new IntValue(+getValue());
	}
	
	@Override
	public Value negative() {
		return new IntValue(-getValue());
	}

	@Override
	public Value add(Value value) {
		return value.addInt(this);
	}
	
	@Override
	public Value addInt(IntValue value) {
		return new IntValue(value.getValue() + getValue());
	}
	
	@Override
	public Value sub(Value value) {
		return value.subInt(this);
	}
	
	@Override
	public Value subInt(IntValue value) {
		return new IntValue(value.getValue() - getValue());
	}
	
	@Override
	public Value mul(Value value) {
		return value.mulInt(this);
	}
	
	@Override
	public Value mulInt(IntValue value) {
		return new IntValue(value.getValue() * getValue());
	}
	
	@Override
	public Value div(Value value) {
		return value.divInt(this);
	}
	
	@Override
	public Value divInt(IntValue value) {
		return new IntValue(value.getValue() / getValue());
	}
	
	@Override
	public Value equal(Value value) {
		return value.equalInt(this);
	}
	
	@Override
	public Value equalInt(IntValue value) {
		return new BoolValue(value.getValue().equals(this.value));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof IntValue))
			return false;
		
		return ((IntValue) obj).getValue().equals(this.value);
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	
	@Override
	public Value notEqual(Value value) {
		return value.notEqualInt(this);
	}
	
	@Override
	public Value notEqualInt(IntValue value) {
		return new BoolValue(!(value.getValue().equals(this.value)));
	}
	
	@Override
	public Value greater(Value value) {
		return value.greaterInt(this);
	}
	
	@Override
	public Value greaterInt(IntValue value) {
		return new BoolValue(value.getValue() > getValue());
	}
	
	@Override
	public Value greaterOrEqual(Value value) {
		return value.greaterOrEqualInt(this);
	}
	
	@Override
	public Value greaterOrEqualInt(IntValue value) {
		return new BoolValue(value.getValue() >= getValue());
	}
	
	@Override
	public Value less(Value value) {
		return value.lessInt(this);
	}
	
	@Override
	public Value lessInt(IntValue value) {
		return new BoolValue(value.getValue() < getValue());
	}
	
	@Override
	public Value lessOrEqual(Value value) {
		return value.lessOrEqualInt(this);
	}
	
	@Override
	public Value lessOrEqualInt(IntValue value) {
		return new BoolValue(value.getValue() <= getValue());
	}
	
}