import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.Stack;

public final class ExprBuilder extends ExprParserBaseListener {
    private Stack<Expr> stack = new Stack<Expr>();

    public Expr build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        return this.stack.pop();
    }

    // @Override
    // public void enterFunction(ExprParser.FunctionContext ctx) {
    // for (ParseTree child : ctx.children) {
    // System.out.println(child.getText());
    // }
    // }

    @Override
    public void enterFunctionIdentifier(ExprParser.FunctionIdentifierContext ctx) {
        String[] arguments = {};
        String functionIdentifier = ctx.getChild(1).toString();
        stack.push(new Function(functionIdentifier, arguments));
    }
}
