import java.util.LinkedList;

public class FunctionDefinition extends Expr {
    private final String identifier;
    private Expr functionCall;
    private final LinkedList<String> arguments = new LinkedList<>();
    private final Boolean arbitraryArguments;

    public FunctionDefinition(String identifier) {
        this.identifier = identifier;
        this.arbitraryArguments = false;
    }

    public FunctionDefinition(String identifier, Boolean arbitraryArguments) {
        this.identifier = identifier;
        this.arbitraryArguments = arbitraryArguments;
    }

    public Boolean acceptsArbitraryAmountOfArguments() {
        return this.arbitraryArguments;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setFunctionCall(Expr call) {
        this.functionCall = call;
    }

    public FunctionDefinition addArgument(String argument) {
        this.arguments.add(argument);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (String argument : this.arguments) {
            builder.append(argument);
            builder.append(" ");
        }

        if (this.arbitraryArguments)
            builder.append("*");

        builder.append("] ");

        if (this.functionCall == null)
            builder.append("()");
        else
            builder.append(functionCall.toString());
        builder.append(" ");

        return "(def " + this.identifier + " " + builder.toString() + ")";
    }
}
