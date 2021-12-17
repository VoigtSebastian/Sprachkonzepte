import java.util.LinkedList;

public final class Script extends Expr {
    final LinkedList<FunctionDefinition> functions = new LinkedList<>();

    public Script() {
    }

    public void addFunctionDefinition(FunctionDefinition function) {
        functions.add(function);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Expr expr : this.functions) {
            builder.append(expr.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
