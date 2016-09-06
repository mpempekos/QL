package evaluator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.Comparison.Equal;
import org.uva.sea.ql.ast.expression.Comparison.Greater;
import org.uva.sea.ql.ast.expression.Comparison.GreaterOrEqual;
import org.uva.sea.ql.ast.expression.Comparison.Less;
import org.uva.sea.ql.ast.expression.Comparison.LessOrEqual;
import org.uva.sea.ql.ast.expression.Comparison.NotEqual;
import org.uva.sea.ql.ast.expression.Literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.Literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.Literal.StringLiteral;
import org.uva.sea.ql.ast.expression.Unary.Negative;
import org.uva.sea.ql.ast.expression.Unary.Not;
import org.uva.sea.ql.ast.expression.Unary.Positive;
import org.uva.sea.ql.ast.node.CodeFragment;
import org.uva.sea.ql.evaluator.Evaluator;
import org.uva.sea.ql.evaluator.Value;

public class ComparisonUnaryTest {

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
	public void testGreaterNumbers() {
		Greater expression = new Greater(fragment, number_7, number_4);
		Value value = expression.accept(evaluator);
		assertEquals(false, value.getValue());
	}
	
	@Test(expected=AssertionError.class)
	public void testGreaterStrings() throws Exception {
		boolean flag = false;
		Greater expression = new Greater(fragment, string_foo, string_foo);
		try {
			expression.accept(evaluator);
		}
		catch (AssertionError e) {
			flag = true;
		}
		
		assertTrue(flag);
	}
	
	@Test
	public void testGreaterWhenEqualNumbers() {
		Greater expression = new Greater(fragment, number_7, number_7);
		Value value = expression.accept(evaluator);
		assertEquals(false, value.getValue());
	}
	
	@Test
	public void testGreaterOrEqualNumbers() {
		GreaterOrEqual expression = new GreaterOrEqual(fragment, number_7, number_7);
		Value value = expression.accept(evaluator);
		assertEquals(true, value.getValue());
	}
	
	
	@Test(expected=AssertionError.class)
	public void testGreaterOrEqualBools() throws Exception {
		boolean flag = false;
		GreaterOrEqual expression = new GreaterOrEqual(fragment, bool_false, bool_false);
		try {
			expression.accept(evaluator);
		}
		catch (AssertionError e) {
			flag = true;
		}
		
		assertTrue(flag);
	}
	
	@Test
	public void testLessNumbers() {
		Less expression = new Less(fragment, number_7, number_7);
		Value value = expression.accept(evaluator);	
		assertEquals(false, value.getValue());
	}
	
	@Test
	public void testLessNumbers2() {
		Less expression = new Less(fragment, number_4, number_7);
		Value value = expression.accept(evaluator);	
		assertEquals(false, value.getValue());
	}
	
	
	@Test
	public void testLessOrEqualNumbers() {
		LessOrEqual expression = new LessOrEqual(fragment, number_7, number_7);
		Value value = expression.accept(evaluator);	
		assertEquals(true, value.getValue());
	}
	
	
	@Test(expected=AssertionError.class)
	public void LessOrEqualStrings() throws Exception {
		boolean flag = false;
		LessOrEqual expression = new LessOrEqual(fragment, string_foo, string_test);
		try {
			expression.accept(evaluator);
		}
		catch (AssertionError e) {
			flag = true;
		}
		
		assertTrue(flag);
	}
	
	
	@Test
	public void testNotBool() {
		Not expression = new Not(fragment, bool_true);
		Value value = expression.accept(evaluator);
		assertEquals(false, value.getValue());
	}
	
	@Test(expected=AssertionError.class)
	public void testNotInt() throws Exception {
		boolean flag = false;
		Not expression = new Not(fragment, number_4);
		try {
			expression.accept(evaluator);
		}
		catch (AssertionError e) {
			flag = true;
		}
		
		assertTrue(flag);
	}
	
	@Test
	public void testPositiveInt() {
		Positive expression = new Positive(fragment, number_1);
		Value value = expression.accept(evaluator);
		assertEquals(1, value.getValue());
	}
	
	@Test(expected=AssertionError.class)
	public void testPositiveBool() throws Exception {
		boolean flag = false;
		Positive expression = new Positive(fragment, bool_false);
		try {
			expression.accept(evaluator);
		}
		catch (AssertionError e) {
			flag = true;
		}
		
		assertTrue(flag);
	}
	
	@Test
	public void testNegativeInt() {
		Negative expression = new Negative(fragment, number_1);
		Value value = expression.accept(evaluator);
		assertEquals(-1, value.getValue());
	}
	
	@Test(expected=AssertionError.class)
	public void testNegativeString() throws Exception {
		boolean flag = false;
		Negative expression = new Negative(fragment, string_test);
		try {
			expression.accept(evaluator);
		}
		catch (AssertionError e) {
			flag = true;
		}
		
		assertTrue(flag);
	}
	
	@Test
	public void testEqualsInts() {
		Equal expression = new Equal(fragment, number_1,number_4);
		Value value = expression.accept(evaluator);
		assertEquals(false, value.getValue());
	}
	
	@Test
	public void testEqualsInts2() {
		Equal expression = new Equal(fragment, number_1,number_1);
		Value value = expression.accept(evaluator);
		assertEquals(true, value.getValue());
	}
	
	@Test
	public void testEqualsBools() {
		Equal expression = new Equal(fragment, bool_false,bool_true);
		Value value = expression.accept(evaluator);
		assertEquals(false, value.getValue());
	}
	
	@Test
	public void testEqualsBools2() {
		Equal expression = new Equal(fragment, bool_true,bool_true);
		Value value = expression.accept(evaluator);
		assertEquals(true, value.getValue());
	}
	
	@Test
	public void testEqualsStrings() {
		Equal expression = new Equal(fragment, string_foo,string_test);
		Value value = expression.accept(evaluator);
		assertEquals(false, value.getValue());
	}
	
	@Test
	public void testEqualsStrings2() {
		Equal expression = new Equal(fragment, string_foo,string_foo);
		Value value = expression.accept(evaluator);
		assertEquals(true, value.getValue());
	}
	
	@Test
	public void testNotEqualsStrings() {
		NotEqual expression = new NotEqual(fragment, string_foo,string_test);
		Value value = expression.accept(evaluator);
		assertEquals(true, value.getValue());
	}
	
	@Test
	public void testNotEqualsStrings2() {
		NotEqual expression = new NotEqual(fragment, string_foo,string_foo);
		Value value = expression.accept(evaluator);
		assertEquals(false, value.getValue());
	}
	
	@Test
	public void testNotEqualsInts() {
		NotEqual expression = new NotEqual(fragment, number_7,number_4);
		Value value = expression.accept(evaluator);
		assertEquals(true, value.getValue());
	}
	
	@Test
	public void testNotEqualsBools() {
		NotEqual expression = new NotEqual(fragment, bool_false,bool_false);
		Value value = expression.accept(evaluator);
		assertEquals(false, value.getValue());
	}
	
	// test literals???

}