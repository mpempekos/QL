// Generated from QL.g4 by ANTLR 4.5.2

package org.uva.sea.ql.parser;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire(QLParser.QuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire(QLParser.QuestionnaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(QLParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(QLParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(QLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(QLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code If}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIf(QLParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code If}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIf(QLParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(QLParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(QLParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code QuestionCompute}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterQuestionCompute(QLParser.QuestionComputeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code QuestionCompute}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitQuestionCompute(QLParser.QuestionComputeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code QuestionNormal}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterQuestionNormal(QLParser.QuestionNormalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code QuestionNormal}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitQuestionNormal(QLParser.QuestionNormalContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuestionIdentifier(QLParser.QuestionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuestionIdentifier(QLParser.QuestionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionLabel}.
	 * @param ctx the parse tree
	 */
	void enterQuestionLabel(QLParser.QuestionLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionLabel}.
	 * @param ctx the parse tree
	 */
	void exitQuestionLabel(QLParser.QuestionLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterTypeInt(QLParser.TypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitTypeInt(QLParser.TypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeStr}
	 * labeled alternative in {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterTypeStr(QLParser.TypeStrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeStr}
	 * labeled alternative in {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitTypeStr(QLParser.TypeStrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeBool}
	 * labeled alternative in {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterTypeBool(QLParser.TypeBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeBool}
	 * labeled alternative in {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitTypeBool(QLParser.TypeBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeDouble}
	 * labeled alternative in {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterTypeDouble(QLParser.TypeDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeDouble}
	 * labeled alternative in {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitTypeDouble(QLParser.TypeDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprGreater}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGreater(QLParser.ExprGreaterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprGreater}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGreater(QLParser.ExprGreaterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNotEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprNotEqual(QLParser.ExprNotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNotEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprNotEqual(QLParser.ExprNotEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPlus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprPlus(QLParser.ExprPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPlus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprPlus(QLParser.ExprPlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParentheses}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprParentheses(QLParser.ExprParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParentheses}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprParentheses(QLParser.ExprParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLess}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLess(QLParser.ExprLessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLess}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLess(QLParser.ExprLessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprNot(QLParser.ExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprNot(QLParser.ExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLessEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLessEqual(QLParser.ExprLessEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLessEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLessEqual(QLParser.ExprLessEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(QLParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(QLParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPositive}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprPositive(QLParser.ExprPositiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPositive}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprPositive(QLParser.ExprPositiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMinus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMinus(QLParser.ExprMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMinus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMinus(QLParser.ExprMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(QLParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(QLParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprGreaterEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGreaterEqual(QLParser.ExprGreaterEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprGreaterEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGreaterEqual(QLParser.ExprGreaterEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLiteral(QLParser.ExprLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLiteral(QLParser.ExprLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultiply}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMultiply(QLParser.ExprMultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultiply}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMultiply(QLParser.ExprMultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNegative}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprNegative(QLParser.ExprNegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNegative}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprNegative(QLParser.ExprNegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprEqual(QLParser.ExprEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprEqual(QLParser.ExprEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprDivide}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprDivide(QLParser.ExprDivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDivide}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprDivide(QLParser.ExprDivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralId}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralId(QLParser.LiteralIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralId}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralId(QLParser.LiteralIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralInt}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralInt(QLParser.LiteralIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralInt}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralInt(QLParser.LiteralIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralBool}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralBool(QLParser.LiteralBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralBool}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralBool(QLParser.LiteralBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralStr}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralStr(QLParser.LiteralStrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralStr}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralStr(QLParser.LiteralStrContext ctx);
}