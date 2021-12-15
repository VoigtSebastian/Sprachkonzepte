import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.Stack;

public final class ExprBuilder extends ExprParserBaseListener {
    private Stack<Expr> stack = new Stack<Expr>();

    public Expr build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        return this.stack.pop();
    }

    @Override
    public void exitStart(ExprParser.StartContext ctx) {
        if (ctx.getChildCount() == 3) {
            Expr right = this.stack.pop();
            Expr left = this.stack.pop();
            String op = ctx.getChild(1).getText();
            this.stack.push(new Operation(left, op, right));
        }
    }

    @Override
    public void exitExpr(ExprParser.ExprContext ctx) {
        if (ctx.getChildCount() == 3) {
            Expr right = this.stack.pop();
            Expr left = this.stack.pop();
            String op = ctx.getChild(1).getText();
            this.stack.push(new Operation(left, op, right));
        }
    }
}
