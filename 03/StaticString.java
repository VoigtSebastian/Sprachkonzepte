public final class StaticString extends Expr {
    final private String text;

    public StaticString(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "\"" + this.text + "\"";
    }
}
