import java.util.LinkedList;

public final class Function extends Expr {
    final String identifier;
    final LinkedList<Expr> parameters = new LinkedList<>();

    public Function(String identifier) {
        this.identifier = identifier;
    }

    public void addParameter(Expr parameter) {
        this.parameters.add(parameter);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Expr expr : this.parameters) {
            builder.append(expr.toString());
            builder.append(" ");
        }

        return "(" + this.identifier + " " + builder.toString() + ")";
    }
}
