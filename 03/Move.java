public final class Move extends Expr {
    public enum Orientation {
        UP, DOWN, LEFT, RIGHT
    }

    private final Orientation orientation;
    private final int amount;

    public Move(Orientation orientation, int amount) {
        this.orientation = orientation;
        this.amount = amount;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(this.amount);
        builder.append(" ");

        switch (this.orientation) {
            case UP:
                builder.append("up");
                break;
            case DOWN:
                builder.append("down");
                break;
            case LEFT:
                builder.append("left");
                break;
            case RIGHT:
                builder.append("right");
                break;
        }
        builder.append(" ");

        return builder.toString();
    };
}
