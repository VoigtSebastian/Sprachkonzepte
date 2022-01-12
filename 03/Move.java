public final class Move extends Expr {
    public enum Orientation {
        UP, DOWN, LEFT, RIGHT
    }

    public final class IntTuple {
        public final int x;
        public final int y;

        public IntTuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final Orientation orientation;
    private final int amount;

    public Move(Orientation orientation, int amount) {
        this.orientation = orientation;
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public IntTuple updateCoordinates(int x, int y) {
        switch (this.orientation) {
            case UP:
                y -= this.amount;
                return new IntTuple(x, y);
            case DOWN:
                y += this.amount;
                return new IntTuple(x, y);
            case LEFT:
                x -= this.amount;
                return new IntTuple(x, y);
            case RIGHT:
                x += this.amount;
                return new IntTuple(x, y);
        }
        return null;
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
