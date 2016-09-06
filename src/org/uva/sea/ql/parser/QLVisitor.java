// Generated from QL.g4 by ANTLR 4.5.2

package org.uva.sea.ql.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QLParser#questionnaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionnaire(QLParser.QuestionnaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(QLParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(QLParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code If}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(QLParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(QLParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuestionCompute}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionCompute(QLParser.QuestionComputeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuestionNormal}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionNormal(QLParser.QuestionNormalContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionIdentifier(QLParser.QuestionIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionLabel(QLParser.QuestionLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(QLParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeStr}
	 * labeled alternative in {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStr(QLParser.TypeStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeBool}
	 * labeled alternative in {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBool(QLParser.TypeBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeDouble}
	 * labeled alternative in {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDouble(QLParser.TypeDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprGreater}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGreater(QLParser.ExprGreaterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNotEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNotEqual(QLParser.ExprNotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPlus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPlus(QLParser.ExprPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParentheses}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParentheses(QLParser.ExprParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLess}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLess(QLParser.ExprLessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNot(QLParser.ExprNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLessEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLessEqual(QLParser.ExprLessEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(QLParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPositive}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPositive(QLParser.ExprPositiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMinus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMinus(QLParser.ExprMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(QLParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprGreaterEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGreaterEqual(QLParser.ExprGreaterEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLiteral(QLParser.ExprLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultiply}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiply(QLParser.ExprMultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNegative}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNegative(QLParser.ExprNegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEqual(QLParser.ExprEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDivide}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDivide(QLParser.ExprDivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralId}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralId(QLParser.LiteralIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralInt}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralInt(QLParser.LiteralIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralBool}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralBool(QLParser.LiteralBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralStr}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralStr(QLParser.LiteralStrContext ctx);
}