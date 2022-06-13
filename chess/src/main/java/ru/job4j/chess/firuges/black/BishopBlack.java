package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int deltaX = dest.getX() > position.getX() ? 1 : -1;
        int deltaY = dest.getY() > position.getY() ? 1 : -1;
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(position.getX() + (deltaX * (index + 1)),
                    position.getY() + (deltaY * (index + 1)));
        }
        return steps;
    }

    public static boolean isDiagonal(Cell source, Cell dest) {
        int wayX = source.getX() - dest.getX();
        int wayY = source.getY() - dest.getY();
        return Math.abs(wayX) == Math.abs(wayY);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
