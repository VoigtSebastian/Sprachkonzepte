import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.Stack;

public final class ExprBuilder extends ExprParserBaseListener {
    private Stack<Expr> stack = new Stack<Expr>();

    public ExprBuilder() {
        stack.push(new Script());
    }

    public Expr build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        return this.stack.pop();
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
        currentFunction.addArgument(new Number(number));

        stack.push(currentFunction);
    }

    @Override
    public void enterString(ExprParser.StringContext ctx) {
        String text = ctx.getChild(0).toString();
        text = text.substring(1, text.length() - 1);

        Function currentFunction = (Function) stack.pop();
        currentFunction.addArgument(new StaticString(text));

        stack.push(currentFunction);
    }

    @Override
    public void exitFunctionCall(ExprParser.FunctionCallContext ctx) {
        if (stack.size() == 2) {
            Function currentFunction = (Function) stack.pop();
            Script script = (Script) stack.pop();
            script.addFunction(currentFunction);
            stack.push(script);
            return;
        }

        Function currentFunction = (Function) stack.pop();
        Function mainFunction = (Function) stack.pop();

        mainFunction.addArgument(currentFunction);
        stack.push(mainFunction);
    }
}
