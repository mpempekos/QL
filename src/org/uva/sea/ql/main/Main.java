package org.uva.sea.ql.main;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.*;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.visitor.MyQLVisitor;
import org.uva.sea.ql.gui.GUIBuilder;
import org.uva.sea.ql.parser.QLLexer;
import org.uva.sea.ql.parser.QLParser;
import org.uva.sea.ql.type_checker.TypeChecker;
import org.uva.sea.ql.type_checker.errorsAndWarnings.ASTIssue;


public class Main {

	
	public static void main(String[] args) throws IOException {
		
		File file = new File("sampleQuestionnaire_2");
	    FileInputStream fileInputStream = new FileInputStream(file);
	    ANTLRInputStream inputStream = new ANTLRInputStream(fileInputStream);
		QLLexer lexer = new QLLexer(inputStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		ParseTree parseTree = parser.form();
		
		MyQLVisitor visitor = new MyQLVisitor();
		
		Form astForm = (Form) parseTree.accept(visitor);
		
		TypeChecker typeChecker = new TypeChecker(astForm);
		typeChecker.performTypeChecking();
			
		if (typeChecker.formHasNoErrors()) {
			GUIBuilder gui = new GUIBuilder(astForm);
		}
		
		showWarningsAndErrors(typeChecker);   
	}
	
	
	
	private static void showWarningsAndErrors(TypeChecker typeChecker) {
		showWarnings(typeChecker);
		showErrors(typeChecker);
	}
	
	private static void showWarnings(TypeChecker typeChecker) {
		List<ASTIssue> warnings = typeChecker.getWarnings();
		
		if (!warnings.isEmpty()) {
			JFrame warningFrame = new JFrame("Warning: Duplicate labels have been detected");
			JPanel warningPanel = formWarningPanel(warnings);
			showFrame(warningFrame, warningPanel);
		}
	}
	
	private static void showErrors(TypeChecker typeChecker) {
		List<ASTIssue> errors = typeChecker.getErrors();
		
		if (!errors.isEmpty()) {
			JFrame errorFrame = new JFrame("Errors found. Fix them so that GUI is rendered...");	
			JPanel errorPanel = formErrorPanel(errors);
			showFrame(errorFrame, errorPanel);
		}
	}
	
	private static void showFrame(JFrame frame, JPanel panel) {
		frame.add(panel);
		frame.setSize(550,300);
		frame.setVisible(true);
	}
	
	private static JPanel formErrorPanel (List<ASTIssue> errors) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		panel.add(new JLabel("======================================================"));
		for (ASTIssue error: errors) {
			panel.add(new JLabel(error.printError()));
		}
		panel.add(new JLabel("======================================================"));
			
		return panel;
	}

	private static JPanel formWarningPanel(List<ASTIssue> warnings) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		panel.add(new JLabel("======================================================"));
		for (ASTIssue warning: warnings) {
			panel.add(new JLabel(warning.printWarning()));
		}
		panel.add(new JLabel("======================================================"));
		
		return panel;
	}
	
}