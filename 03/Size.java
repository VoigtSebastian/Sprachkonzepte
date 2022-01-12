public final class Size extends Expr {
    private final int size;

    public Size(int size) {
        this.size = size;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Size ");
        builder.append(this.size);
        builder.append("\n");

        return builder.toString();
    };
}
