import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public final class ExprBuilder extends ExprParserBaseListener {
    private final Stack<Expr> stack;

    public final class UnknownSetting extends RuntimeException {
        public UnknownSetting(String type) {
            super("The setting (" + type + ") is unknown");
        }
    }

    public ExprBuilder() {
        this.stack = new Stack<>();
        Script script = new Script();
        stack.push(script);
        // Script script = new Script();
        // for (FunctionDefinition function : this.buildInFunctions) {
        // script.addFunctionDefinition(function);
        // }
        // stack.push(script);
    }

    @Override
    public void enterSettings(ExprParser.SettingsContext ctx) {
        Script script = (Script) stack.pop();
        String type = ctx.getChild(0).toString();
        System.out.println(type);

        stack.push(script);
    }

    @Override
    public void enterSizeDeceleration(ExprParser.SizeDecelerationContext ctx) {
        Script script = (Script) stack.pop();

        int intSize = Integer.parseInt(ctx.getChild(1).toString());
        Size size = new Size(intSize);

        script.addSize(size);

        stack.push(script);
    }

    @Override
    public void enterStartingPosition(ExprParser.StartingPositionContext ctx) {
        Script script = (Script) stack.pop();

        int x = Integer.parseInt(ctx.getChild(1).toString());
        int y = Integer.parseInt(ctx.getChild(2).toString());

        Start start = new Start(x, y);

        script.addStart(start);

        stack.push(script);
    }

    @Override
    public void enterUp(ExprParser.UpContext ctx) {
        Script script = (Script) stack.pop();
        var amount = Integer.parseInt(ctx.getChild(0).toString());

        Move move = new Move(Move.Orientation.UP, amount);
        script.addMove(move);

        stack.push(script);
    }

    @Override
    public void enterDown(ExprParser.DownContext ctx) {
        Script script = (Script) stack.pop();
        var amount = Integer.parseInt(ctx.getChild(0).toString());

        Move move = new Move(Move.Orientation.DOWN, amount);
        script.addMove(move);

        stack.push(script);
    }

    @Override
    public void enterLeft(ExprParser.LeftContext ctx) {
        Script script = (Script) stack.pop();
        var amount = Integer.parseInt(ctx.getChild(0).toString());

        Move move = new Move(Move.Orientation.LEFT, amount);
        script.addMove(move);

        stack.push(script);
    }

    @Override
    public void enterRight(ExprParser.RightContext ctx) {
        Script script = (Script) stack.pop();
        var amount = Integer.parseInt(ctx.getChild(0).toString());

        Move move = new Move(Move.Orientation.RIGHT, amount);
        script.addMove(move);

        stack.push(script);
    }

    public Expr build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        Script script = (Script) this.stack.pop();
        return script;
    }

}
