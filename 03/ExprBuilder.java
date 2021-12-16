import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.Stack;

public final class ExprBuilder extends ExprParserBaseListener {
    private Stack<Expr> stack = new Stack<Expr>();

    public Expr build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        return this.stack.pop();
    }
}
