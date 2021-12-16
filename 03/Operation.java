import java.util.LinkedList;

public final class Operation extends Expr {
    final LinkedList<Function> functions = new LinkedList<>();

    public Operation() {
    }

    public void addFunction(Function function) {
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
