package evaluator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.Literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.Literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.Literal.StringLiteral;
import org.uva.sea.ql.ast.expression.Logical.And;
import org.uva.sea.ql.ast.expression.Logical.Or;
import org.uva.sea.ql.ast.expression.Numerical.Add;
import org.uva.sea.ql.ast.expression.Numerical.Div;
import org.uva.sea.ql.ast.expression.Numerical.Mul;
import org.uva.sea.ql.ast.expression.Numerical.Sub;
import org.uva.sea.ql.ast.node.CodeFragment;
import org.uva.sea.ql.evaluator.Evaluator;
import org.uva.sea.ql.evaluator.Value;


public class LogicalNumericalTest {
	
	private final IntegerLiteral number_7 = new IntegerLiteral(7);
	private final IntegerLiteral number_4 = new IntegerLiteral(4);
	private final IntegerLiteral number_1 = new IntegerLiteral(1);
	private final StringLiteral  string_test = new StringLiteral("test");
	private final StringLiteral  string_foo = new StringLiteral("foo");
	private final BooleanLiteral bool_true = new BooleanLiteral(true);
	private final BooleanLiteral bool_false = new BooleanLiteral(false);
	
	private final CodeFragment fragment = new CodeFragment(-1, -1);
	
	private Evaluator evaluator;
	
	@Before
	public void setUpTestEnv() {
		this.evaluator = new Evaluator();
	}
	
	@Test
	public void testAddNumbers() {
		Add exprAdd = new Add(fragment, number_7, number_4);
		Value value = exprAdd.accept(evaluator);
		assertEquals(11, value.getValue());
	}
	
	
	@Test(expected=AssertionError.class)
	public void testAddBools() throws Exception {
		boolean flag = false;
		Add exprAdd = new Add(fragment, bool_false, bool_false);
		try {
			exprAdd.accept(evaluator);
		}
		catch (AssertionError e) {
			flag = true;
		}
		
		assertTrue(flag);
	}
	
	
	@Test
	public void testAddStrings() {
		Add exprAdd = new Add(fragment, string_test, string_foo);
		Value value = exprAdd.accept(evaluator);
		assertEquals("footest", value.getValue());
	}
	
	@Test
	public void testSubNumbers() {
		Sub exprAdd = new Sub(fragment, number_1, number_7);
		Value value = exprAdd.accept(evaluator);
		assertEquals(6, value.getValue());
	}
	
	@Test(expected=AssertionError.class)
	public void testSubStrings() {
		boolean flag = false;
		Sub exprAdd = new Sub(fragment, string_foo,string_test);
		try {
			exprAdd.accept(evaluator);
		}
		catch (AssertionError e) {
			flag = true;
		}
		
		assertTrue(flag);
	}
	
	
	@Test
	public void testMulInts() {
		Mul exprAdd = new Mul(fragment, number_7, number_4);
		Value value = exprAdd.accept(evaluator);
		assertEquals(28, value.getValue());
	}
	
	@Test(expected=AssertionError.class)
	public void testMulBools() throws Exception {
		boolean flag = false;
		Mul exprAdd = new Mul(fragment, bool_false, bool_true);
		try {
			exprAdd.accept(evaluator);
		}
		catch (AssertionError e) {
			flag = true;
		}
		
		assertTrue(flag);
	}
	
	@Test
	public void testDiv() {
		Div exprAdd = new Div(fragment, number_1, number_4);
		Value value = exprAdd.accept(evaluator);
		assertEquals(4, value.getValue());
	}
	
	@Test
	public void testAndBool() {
		And exprAdd = new And(fragment, bool_false, bool_true);
		Value value = exprAdd.accept(evaluator);
		assertEquals(false, value.getValue());
	}
	
	@Test
	public void testOrBool() {
		Or exprAdd = new Or(fragment, bool_false, bool_true);
		Value value = exprAdd.accept(evaluator);
		assertEquals(true, value.getValue());
	}
	
	@Test(expected=AssertionError.class)
	public void testAndStrings() throws Exception {
		boolean flag = false;
		And exprAnd = new And(fragment, string_foo, string_test);
		try {
			exprAnd.accept(evaluator);
		}
		catch (AssertionError e) {
			flag = true;
		}
		
		assertTrue(flag);
	}
	
	@Test(expected=AssertionError.class)
	public void testOrInts() throws Exception {
		boolean flag = false;
		Or exprOr = new Or(fragment, number_1, number_4);
		try {
			exprOr.accept(evaluator);
		}
		catch (AssertionError e) {
			flag = true;
		}
		
		assertTrue(flag);
	}


}
