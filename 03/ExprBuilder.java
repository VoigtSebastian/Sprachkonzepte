import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public final class ExprBuilder extends ExprParserBaseListener {
    public final class MissingMainFunction extends RuntimeException {
        public MissingMainFunction() {
            super("The script is missing a main function");
        }
    }

    public ExprBuilder() {
        // Script script = new Script();
        // for (FunctionDefinition function : this.buildInFunctions) {
        // script.addFunctionDefinition(function);
        // }
        // stack.push(script);
    }

    public Expr build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        // Script script = (Script) this.stack.pop();
        // // static semantics
        // if (!script.functions.containsKey("main")) {
        // throw new MissingMainFunction();
        // }
        // return script;
        return null;
    }

}
