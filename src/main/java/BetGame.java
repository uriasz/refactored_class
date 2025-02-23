import java.util.*;

public class BetGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 60;
    private static final int MIN_BET_SIZE = 6;
    private static final int MAX_BET_SIZE = 15;

    protected boolean isNumberValid(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    protected boolean isListSizeValid(List<Integer> list) {
        return list.size() >= MIN_BET_SIZE && list.size() <= MAX_BET_SIZE;
    }

    protected List<Integer> createValidInputList(List<Integer> originalList) {
        if (originalList == null || originalList.isEmpty()) {
            throw new IllegalArgumentException("A lista de números não pode estar vazia.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : originalList) {
            if (!isNumberValid(number)) {
                throw new IllegalArgumentException("Número fora do intervalo permitido: " + number);
            }
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("Número repetido na aposta: " + number);
            }
        }

        if (!isListSizeValid(new ArrayList<>(uniqueNumbers))) {
            throw new IllegalArgumentException("A aposta deve conter entre " + MIN_BET_SIZE + " e " + MAX_BET_SIZE + " números.");
        }

        return new ArrayList<>(uniqueNumbers);
    }

    protected List<Integer> createRandomList() {
        Random random = new Random();
        Set<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < MIN_BET_SIZE) {
            randomNumbers.add(random.nextInt(MAX_NUMBER) + MIN_NUMBER);
        }

        return new ArrayList<>(randomNumbers);
    }

    protected double calculatePrize(List<Integer> inputList, List<Integer> randomList, double givenCash) {
        long matches = inputList.stream().filter(randomList::contains).count();

        return switch ((int) matches) {
            case 6 -> givenCash;
            case 5 -> givenCash * 0.2;
            case 4 -> givenCash * 0.05;
            default -> 0.0;
        };
    }

    public double apostar(List<Integer> inputList, double givenCash) {
        try {
            List<Integer> validInputList = createValidInputList(inputList);
            List<Integer> randomList = createRandomList();
            return calculatePrize(validInputList, randomList, givenCash);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return 0.0;
        }
    }
}
