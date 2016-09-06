package typechecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class BooleanConditionsTest extends TypecheckerTest{

	@Before
	public void setUpTestEnv() throws IOException {
		filename = "test/typechecker/testForms/testBooleanConditions";
		super.setUpTestEnv();
	}
	
	@Test
	public void formHasNoErrors() {
		assertFalse(typeChecker.formHasNoErrors());
	}
	
	@Test
	public void checkBooleanConditions() {
		assertEquals(2, typeChecker.getErrors().size());
	}
	
	@Test
	public void formHasNoWarnings() {
		assertEquals(0, typeChecker.getWarnings().size());
	}
	
}
