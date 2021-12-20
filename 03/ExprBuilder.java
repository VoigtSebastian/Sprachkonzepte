import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public final class ExprBuilder extends ExprParserBaseListener {
    private Stack<Expr> stack = new Stack<Expr>();
    private LinkedList<FunctionDefinition> buildInFunctions = new LinkedList<>(
            Arrays.asList(new FunctionDefinition("print", true), new FunctionDefinition("add", true),
                    new FunctionDefinition("sub", false).addArgument("dividend").addArgument("divisor"),
                    new FunctionDefinition("mul", true),
                    new FunctionDefinition("div", true)));

    public ExprBuilder() {
        Script script = new Script();
        for (FunctionDefinition function : this.buildInFunctions) {
            script.addFunctionDefinition(function);
        }
        stack.push(script);
    }

    public Expr build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        // TODO: check for functions with same name and main function
        // TODO: check for argument count?
        return this.stack.pop();
    }

    @Override
    public void enterFunctionDefinition(ExprParser.FunctionDefinitionContext ctx) {
        String identifier = ctx.getChild(2).toString();
        stack.push(new FunctionDefinition(identifier));
    }

    @Override
    public void enterFunctionArgument(ExprParser.FunctionArgumentContext ctx) {
        String identifier = ctx.getChild(0).toString();
        FunctionDefinition definition = (FunctionDefinition) stack.pop();
        definition.addArgument(identifier);
        stack.push(definition);
    }

    @Override
    public void enterFunctionCall(ExprParser.FunctionCallContext ctx) {
        String identifier = ctx.getChild(1).toString();
        stack.push(new Function(identifier));
    }

    @Override
    public void enterNumber(ExprParser.NumberContext ctx) {
        Double number = Double.parseDouble(ctx.getChild(0).toString());

        Function currentFunction = (Function) stack.pop();
        currentFunction.addParameter(new Number(number));

        stack.push(currentFunction);
    }

    @Override
    public void enterString(ExprParser.StringContext ctx) {
        String text = ctx.getChild(0).toString();
        text = text.substring(1, text.length() - 1);

        Function currentFunction = (Function) stack.pop();
        currentFunction.addParameter(new StaticString(text));

        stack.push(currentFunction);
    }

    @Override
    public void enterIdentifierAsArgument(ExprParser.IdentifierAsArgumentContext ctx) {
        String text = ctx.getChild(0).toString();

        Function currentFunction = (Function) stack.pop();
        currentFunction.addParameter(new Value(text));

        stack.push(currentFunction);
    }

    @Override
    public void exitFunctionCall(ExprParser.FunctionCallContext ctx) {
        if (stack.size() == 3) {
            Function currentFunction = (Function) stack.pop();
            FunctionDefinition definition = (FunctionDefinition) stack.pop();
            definition.setFunctionCall(currentFunction);
            stack.push(definition);
            return;
        }

        Function currentFunction = (Function) stack.pop();
        Function mainFunction = (Function) stack.pop();

        mainFunction.addParameter(currentFunction);
        stack.push(mainFunction);
    }

    @Override
    public void exitFunctionDefinition(ExprParser.FunctionDefinitionContext ctx) {
        FunctionDefinition definition = (FunctionDefinition) stack.pop();
        Script script = (Script) stack.pop();
        script.addFunctionDefinition(definition);
        stack.push(script);
    }
}
