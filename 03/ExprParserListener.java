// Generated from ExprParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ExprParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ExprParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(ExprParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(ExprParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFunctionIdentifier(ExprParser.FunctionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFunctionIdentifier(ExprParser.FunctionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(ExprParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(ExprParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#assignValue}.
	 * @param ctx the parse tree
	 */
	void enterAssignValue(ExprParser.AssignValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#assignValue}.
	 * @param ctx the parse tree
	 */
	void exitAssignValue(ExprParser.AssignValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void enterReturnValue(ExprParser.ReturnValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void exitReturnValue(ExprParser.ReturnValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(ExprParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(ExprParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArguments(ExprParser.FunctionArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArguments(ExprParser.FunctionArgumentsContext ctx);
}