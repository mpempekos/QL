package typechecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class DuplicateDeclarationsTest extends TypecheckerTest {

	@Before
	public void setUpTestEnv() throws IOException {
		this.filename = "test/typechecker/testForms/testDuplicateDeclarations";
		super.setUpTestEnv();
	}

	@Test
	public void  formHasNoErrors() {
		assertFalse(typeChecker.formHasNoErrors());
	}
	
	@Test
	public void formHasWarnings() {
		assertEquals(1, typeChecker.getWarnings().size());
	}
	
	@Test
	public void checkDuplicateDeclarations() {
		assertEquals(1, typeChecker.getErrors().size());
	}
	
}
