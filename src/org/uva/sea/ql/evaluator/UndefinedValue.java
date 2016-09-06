package org.uva.sea.ql.evaluator;

public class UndefinedValue extends Value {

	@Override
	public Object getValue() {
		return null;
	}

	public boolean isDefined () {
		return false;
	}
	
}