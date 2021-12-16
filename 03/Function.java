import java.util.LinkedList;

public final class Function extends Expr {
    final String identifier;
    final LinkedList<Expr> arguments = new LinkedList<>();

    public Function(String identifier) {
        this.identifier = identifier;
    }

    public void addArgument(Expr argument) {
        this.arguments.add(argument);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Expr expr : this.arguments) {
            builder.append(expr.toString());
            builder.append(" ");
        }

        return "(" + this.identifier + " " + builder.toString() + ")";
    }
}
