package org.uva.sea.ql.ast.node;

import org.antlr.v4.runtime.ParserRuleContext;


public class CodeFragment {		//srcloc

	private final int start;
	private final int end;
	
	public CodeFragment(int start, int end) {
		this.end =  end;
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public int getStart() {
		return start;
	}
	
	
	
	public static CodeFragment getCodeFragment(ParserRuleContext context) {
		return new CodeFragment(context.getStart().getLine(), context.getStop().getLine());
	}
}
