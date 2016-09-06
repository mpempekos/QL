package org.uva.sea.ql.type_checker;

import java.util.HashSet;
import java.util.Set;
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
import org.uva.sea.ql.ast.expression.*;


public class DependentVariables implements ExpressionVisitor<Set<Identifier>> {
	
	private Set<Identifier> dependencies;
	
	public DependentVariables() {
		this.dependencies = new HashSet<Identifier>();
	}

	@Override
	public Set<Identifier> visit(Equal node) {
		node.getLeftExpression().accept(this);
		node.getRightExpression().accept(this);
		return this.dependencies;
	}
	

	@Override
	public Set<Identifier> visit(NotEqual node) {
		node.getLeftExpression().accept(this);
		node.getRightExpression().accept(this);
		return this.dependencies;
	}
	

	@Override
	public Set<Identifier> visit(Greater node) {
		node.getLeftExpression().accept(this);
		node.getRightExpression().accept(this);
		return this.dependencies;
	}
	

	@Override
	public Set<Identifier> visit(GreaterOrEqual node) {
		node.getLeftExpression().accept(this);
		node.getRightExpression().accept(this);
		return this.dependencies;
	}
	

	@Override
	public Set<Identifier> visit(Less node) {
		node.getLeftExpression().accept(this);
		node.getRightExpression().accept(this);
		return this.dependencies;
	}

	
	@Override
	public Set<Identifier> visit(LessOrEqual node) {
		node.getLeftExpression().accept(this);
		node.getRightExpression().accept(this);
		return this.dependencies;
	}
	

	@Override
	public Set<Identifier> visit(BooleanLiteral node) {
		return this.dependencies;
	}
	

	@Override
	public Set<Identifier> visit(Identifier node) {
		this.dependencies.add(node);
		return this.dependencies;
	}

	
	@Override
	public Set<Identifier> visit(IntegerLiteral node) {
		return this.dependencies;
	}
	

	@Override
	public Set<Identifier> visit(StringLiteral node) {
		return this.dependencies;
	}

	
	@Override
	public Set<Identifier> visit(And node) {
		node.getLeftExpression().accept(this);
		node.getRightExpression().accept(this);
		return this.dependencies;
	}

	
	@Override
	public Set<Identifier> visit(Or node) {
		node.getLeftExpression().accept(this);
		node.getRightExpression().accept(this);
		return this.dependencies;
	}
	

	@Override
	public Set<Identifier> visit(Add node) {
		node.getLeftExpression().accept(this);
		node.getRightExpression().accept(this);
		return this.dependencies;
	}
	

	@Override
	public Set<Identifier> visit(Sub node) {
		node.getLeftExpression().accept(this);
		node.getRightExpression().accept(this);
		return this.dependencies;
	}

	@Override
	public Set<Identifier> visit(Mul node) {
		node.getLeftExpression().accept(this);
		node.getRightExpression().accept(this);
		return this.dependencies;
	}

	@Override
	public Set<Identifier> visit(Div node) {
		node.getLeftExpression().accept(this);
		node.getRightExpression().accept(this);
		return this.dependencies;
	}



	@Override
	public Set<Identifier> visit(Not node) {
		node.getExpression().accept(this);
		return this.dependencies;
	}

	@Override
	public Set<Identifier> visit(Positive node) {
		node.getExpression().accept(this);
		return this.dependencies;
	}

	@Override
	public Set<Identifier> visit(Negative node) {
		node.getExpression().accept(this);
		return this.dependencies;
	}

}
