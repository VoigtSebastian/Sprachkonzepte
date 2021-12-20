import java.util.HashMap;
import java.util.Map;

public final class Script extends Expr {
    final Map<String, FunctionDefinition> functions = new HashMap<>();

    public final class DuplicateFunctionError extends RuntimeException {
        public DuplicateFunctionError(String identifier) {
            super("Function with name the name \"" + identifier + "\" does already exist.");
        }
    }

    public Script() {
    }

    public void addFunctionDefinition(FunctionDefinition function) {
        if (this.functions.containsKey(function.getIdentifier()))
            throw new DuplicateFunctionError(function.getIdentifier());
        functions.put(function.getIdentifier(), function);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Expr expr : this.functions.values()) {
            builder.append(expr.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
