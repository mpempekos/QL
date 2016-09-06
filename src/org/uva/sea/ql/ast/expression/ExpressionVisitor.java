package org.uva.sea.ql.ast.expression;

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
import org.uva.sea.ql.ast.expression.Logical.Or;
import org.uva.sea.ql.ast.expression.Numerical.Add;
import org.uva.sea.ql.ast.expression.Numerical.Div;
import org.uva.sea.ql.ast.expression.Numerical.Mul;
import org.uva.sea.ql.ast.expression.Numerical.Sub;
import org.uva.sea.ql.ast.expression.Unary.Negative;
import org.uva.sea.ql.ast.expression.Unary.Not;
import org.uva.sea.ql.ast.expression.Unary.Positive;


public interface ExpressionVisitor<T> {
	
	public T visit(Equal node);
	public T visit(NotEqual node);
	public T visit(Greater node);
	public T visit(GreaterOrEqual node);
	public T visit(Less node);
	public T visit(LessOrEqual node);
	
	public T visit(BooleanLiteral node);
	public T visit(Identifier node);
	public T visit(IntegerLiteral node);
	public T visit(StringLiteral node);
	
	public T visit(And node);
	public T visit(Or node);
	
	public T visit(Add node);
	public T visit(Sub node);
	public T visit(Mul node);
	public T visit(Div node);
	
	public T visit(Not node);
	public T visit(Positive node);
	public T visit(Negative node);
	

}