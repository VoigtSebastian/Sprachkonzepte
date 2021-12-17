public final class Value extends Expr {
    final private String identifier;

    public Value(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return this.identifier;
    }
}
