import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BetGameTest {

    private final BetGame betGame = new BetGame();

    @Test
    void testValidInputList() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> betGame.createValidInputList(validNumbers));
    }

    @Test
    void testInvalidNumberInList() {
        List<Integer> invalidNumbers = Arrays.asList(0, 2, 3, 4, 5, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> betGame.createValidInputList(invalidNumbers));
        assertTrue(exception.getMessage().contains("Número fora do intervalo permitido"));
    }

    @Test
    void testDuplicateNumbers() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> betGame.createValidInputList(duplicateNumbers));
        assertTrue(exception.getMessage().contains("Número repetido na aposta"));
    }

    @Test
    void testSmallBetSize() {
        List<Integer> smallBet = Arrays.asList(1, 2, 3, 4, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> betGame.createValidInputList(smallBet));
        assertTrue(exception.getMessage().contains("A aposta deve conter entre"));
    }

    @Test
    void testLargeBetSize() {
        List<Integer> largeBet = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> betGame.createValidInputList(largeBet));
        assertTrue(exception.getMessage().contains("A aposta deve conter entre"));
    }

    @Test
    void testRandomListSize() {
        List<Integer> randomList = betGame.createRandomList();
        assertEquals(6, randomList.size());
    }

    @Test
    void testCalculatePrize() {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningList = Arrays.asList(1, 2, 3, 4, 5, 6);
        double prize = betGame.calculatePrize(inputList, winningList, 100);
        assertEquals(100, prize);
    }

    @Test
    void testNoWinningNumbers() {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningList = Arrays.asList(7, 8, 9, 10, 11, 12);
        double prize = betGame.calculatePrize(inputList, winningList, 100);
        assertEquals(0.0, prize);
    }
}
