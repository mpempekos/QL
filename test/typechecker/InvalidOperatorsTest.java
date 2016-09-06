package typechecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class InvalidOperatorsTest extends TypecheckerTest {
	
	@Before
	public void setUpTestEnv() throws IOException {
		this.filename = "test/typechecker/testForms/testInvalidOperators";
		super.setUpTestEnv();
	}

	@Test
	public void  formHasNoErrors() {
		assertFalse(typeChecker.formHasNoErrors());
	}
	
	@Test
	public void formHasNoWarnings() {
		assertEquals(0, typeChecker.getWarnings().size());
	}
	
	@Test
	public void checkInvalidOperators() {
		assertEquals(3, typeChecker.getErrors().size());
	}

}