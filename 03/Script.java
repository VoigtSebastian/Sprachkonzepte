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
