package org.uva.sea.ql.evaluator;


public class StrValue extends Value {

	private final String value;
	
	
	public StrValue(String value) {
		this.value = value;
	}


	public String getValue() {
		return value;
	}
	
	@Override
	public Value add(Value value) {
		return value.addStr(this);
	}
	
	@Override
	public Value addStr(StrValue value) {
		return new StrValue(value.getValue() + getValue());
	}
	
	@Override
	public Value equal(Value value) {
		return value.equalStr(this);
	}
	
	@Override
	public Value equalStr(StrValue value) {
		return new BoolValue(value.getValue().equals(this.value));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StrValue))
			return false;
		
		return ((StrValue) obj).getValue().equals(this.value);
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	
	@Override
	public Value notEqual(Value value) {
		return value.notEqualStr(this);
	}
	
	@Override
	public Value notEqualStr(StrValue value) {
		return new BoolValue(!(value.getValue().equals(this.value)));
	}
	
}
