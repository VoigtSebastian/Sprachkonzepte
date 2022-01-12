import java.util.LinkedList;

public final class Script extends Expr {
    private Start start;
    private Size size;
    private final LinkedList<Move> moves;

    public final class AlreadyDeclared extends RuntimeException {
        public AlreadyDeclared(String field) {
            super("The field (" + field + ") has already been declared");
        }
    }

    public final class MissingSetting extends RuntimeException {
        public MissingSetting(String type) {
            super("The setting (" + type + ") is missing");
        }
    }

    public final class MoveOutOfBounds extends RuntimeException {
        public MoveOutOfBounds(int amount) {
            super("The move with the amount of (" + amount + ") is out of bounds");
        }
    }

    public Script() {
        this.moves = new LinkedList<>();
    }

    public void addStart(Start start) {
        // static semantics
        if (this.start != null) {
            throw new AlreadyDeclared("Start");
        }
        this.start = start;
    }

    public void addSize(Size size) {
        // static semantics
        if (this.size != null) {
            throw new AlreadyDeclared("Size");
        }
        this.size = size;
    }

    public void addMove(Move move) {
        this.moves.add(move);
    }

    public void check() {
        // static semantics
        if (this.size == null) {
            throw new MissingSetting("Size");
        }
        if (this.start == null) {
            throw new MissingSetting("Start");
        }
        for (Move move : this.moves) {
            if (move.getAmount() >= this.size.getSize()) {
                throw new MoveOutOfBounds(move.getAmount());
            }
        }
    }

    public void execute() {
        var currentX = this.start.getX();
        var currentY = this.start.getY();

        this.printField(currentX, currentY);
        for (Move move : this.moves) {
            var tuple = move.updateCoordinates(currentX, currentY);

            currentX = tuple.x;
            currentY = tuple.y;

            if (currentX >= this.size.getSize() || currentX < 0) {
                throw new MoveOutOfBounds(move.getAmount());
            }
            if (currentY >= this.size.getSize() || currentY < 0) {
                throw new MoveOutOfBounds(move.getAmount());
            }

            this.printField(currentX, currentY);
        }
    }

    public void printField(int currentX, int currentY) {
        System.out.println();

        for (int y = 0; y < this.size.getSize(); y++) {
            for (int x = 0; x < this.size.getSize(); x++) {
                if (y == currentY && x == currentX)
                    System.out.print("O");
                else
                    System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.size);
        builder.append(this.start);
        builder.append("\n");

        for (Move move : this.moves) {
            builder.append(move);
        }
        return builder.toString();
    };
}
