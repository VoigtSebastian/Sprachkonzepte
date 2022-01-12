public final class Start extends Expr {
    private final int x;
    private final int y;

    public Start(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Start ");
        builder.append(this.x);
        builder.append(" ");
        builder.append(this.y);
        builder.append("\n");

        return builder.toString();
    };
}
