import java.util.LinkedList;

public final class FunctionDefinition extends Expr {
    final String identifier;
    Expr functionCall;
    final LinkedList<String> arguments = new LinkedList<>();

    public FunctionDefinition(String identifier) {
        this.identifier = identifier;
    }

    public void setFunctionCall(Expr call) {
        this.functionCall = call;
    }

    public void addArgument(String argument) {
        this.arguments.add(argument);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (String argument : this.arguments) {
            builder.append(argument);
            builder.append(" ");
        }
        builder.append("] ");

        builder.append(functionCall.toString());
        builder.append(" ");

        return "(def " + this.identifier + " " + builder.toString() + ")";
    }
}
