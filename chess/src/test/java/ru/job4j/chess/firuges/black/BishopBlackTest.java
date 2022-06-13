package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.awt.Color.black;
import static org.hamcrest.CoreMatchers.*;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void whenCreateBishopBlackA5ThenPositionA5() {
        Figure figure = new BishopBlack(A5);
        Assert.assertThat(figure.position(), is(A5));
    }

    @Test
    public void whenCopyBishopBlackA5toA7ThenA7() {
        Figure figure = new BishopBlack(A5);
        Assert.assertThat(figure.copy(A7).position(), is(A7));
    }

    @Test
    public void whenWayFromC3toF6ThenD4E5F6() {
        Cell[] expected = {D4, E5, F6};
        Figure figure = new BishopBlack(C3);
        Cell[] result = figure.way(F6);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenIsDiagonalC4toC5ThenFalse() {
        boolean result = BishopBlack.isDiagonal(C4, C5);
        Assert.assertFalse(result);
    }

    @Test
    public void whenIsDiagonalA1toC3ThenTrue() {
        boolean result = BishopBlack.isDiagonal(A1, C3);
        Assert.assertTrue(result);
    }
}