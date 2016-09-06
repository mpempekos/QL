package typechecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class IdentifiersAndMultipleErrorsTest extends TypecheckerTest {
	
	@Before
	public void setUpTestEnv() throws IOException {
		this.filename = "test/typechecker/testForms/testIdentifiersAndMultipleErrors";
		super.setUpTestEnv();
	}

	@Test
	public void  formHasNoErrors() {
		assertFalse(typeChecker.formHasNoErrors());
	}
	
	@Test
	public void checkWarnings() {
		assertEquals(1, typeChecker.getWarnings().size());
	}
	
	@Test
	public void checkErrors() {
		assertEquals(2, typeChecker.getErrors().size());
	}
	
	@Test
	public void checkIdentifiers() {
		assertEquals(7, typeChecker.getIdentifiers().size());
	}

}
