public final class Function extends Expr {
    public final String identifier;
    public final String[] arguments;

    public Function(String identifier, String[] arguments) {
        this.identifier = identifier;
        this.arguments = arguments;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String[] getArguments() {
        return this.arguments;
    }

    @Override
    public String toString() {
        return "fn " + this.identifier + "(" + this.arguments + ")";
    }
}
