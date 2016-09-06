package typechecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.visitor.MyQLVisitor;
import org.uva.sea.ql.parser.QLLexer;
import org.uva.sea.ql.parser.QLParser;
import org.uva.sea.ql.type_checker.TypeChecker;


public abstract class TypecheckerTest {

	protected Form form;
	protected TypeChecker typeChecker;
	protected String filename;
	protected File file;
	
	@Before
	public void setUpTestEnv() throws IOException {
		
		this.file = new File(filename);
	    FileInputStream fileInputStream = new FileInputStream(file);
	    ANTLRInputStream inputStream = new ANTLRInputStream(fileInputStream);
		QLLexer lexer = new QLLexer(inputStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		ParseTree parseTree = parser.form();
		MyQLVisitor visitor = new MyQLVisitor();
		
		this.form = (Form) parseTree.accept(visitor);
		
		this.typeChecker = new TypeChecker(form);
		typeChecker.performTypeChecking();
	}
	
	
}
