import java.util.LinkedList;

public final class Script extends Expr {
    private Start start;
    private Size size;
    private final LinkedList<Expr> moves;

    public final class AlreadyDeclared extends RuntimeException {
        public AlreadyDeclared(String field) {
            super("The field (" + field + ") has already been declared");
        }
    }

    public Script() {
        this.moves = new LinkedList<>();
    }

    public void addStart(Start start) {
        if (this.start != null) {
            throw new AlreadyDeclared("Start");
        }
        this.start = start;
    }

    public void addSize(Size size) {
        if (this.size != null) {
            throw new AlreadyDeclared("Size");
        }
        this.size = size;
    }

    public void addMove(Move move) {
        this.moves.add(move);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.size);
        builder.append(this.start);
        builder.append("\n");

        for (Expr move : this.moves) {
            builder.append(move);
        }
        return builder.toString();
    };
}
