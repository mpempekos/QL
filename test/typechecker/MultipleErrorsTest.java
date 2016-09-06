package typechecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class MultipleErrorsTest extends TypecheckerTest {
	
	@Before
	public void setUpTestEnv() throws IOException {
		filename = "test/typechecker/testForms/testMultipleErrors";
		super.setUpTestEnv();
	}
	
	@Test
	public void formHasNoErrors() {
		assertFalse(typeChecker.formHasNoErrors());
	}
	
	@Test
	public void checkErrors() {
		assertEquals(3, typeChecker.getErrors().size());
	}
	
	@Test
	public void formHasWarnings() {
		assertEquals(1, typeChecker.getWarnings().size());
	}

}
