public final class Number extends Expr {
    final private double number;

    public Number(Double number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Double.toString(this.number);
    }
}
