package typechecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class UndefinedVariablesTest extends TypecheckerTest {
	
	@Before
	public void setUpTestEnv() throws IOException {
		this.filename = "test//typechecker/testForms/testUndefinedVariables";
		super.setUpTestEnv();
	}
	
	
	// should fail...
	@Test
	public void  formHasNoErrors() {
		assertTrue(typeChecker.formHasNoErrors());
	}
	
	@Test
	public void  formHasNoErrorsCorrect() {
		assertFalse(typeChecker.formHasNoErrors());
	}
	
	@Test
	public void checkUndefinedVariables() {
		assertEquals(2, typeChecker.getErrors().size());
	}

}
