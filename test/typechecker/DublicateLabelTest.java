package typechecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class DublicateLabelTest extends TypecheckerTest {
	
	@Before
	public void setUpTestEnv() throws IOException {
		this.filename = "test/typechecker/testForms/testDuplicateLabels";
		super.setUpTestEnv();
	}

	@Test
	public void  formHasNoErrors() {
		assertTrue(typeChecker.formHasNoErrors());
	}
	
	
	@Test
	public void  checkDupLabels() {
		int warnings = typeChecker.getWarnings().size();
		assertEquals(2, warnings);
	}
	
}
