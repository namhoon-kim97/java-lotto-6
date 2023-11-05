package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.exception.InvalidWinningNumbersException;

public class InputView {
    private static final Pattern WINNING_NUMBERS_PATTERN = Pattern.compile("^(\\d{1,2},){5}\\d{1,2}$");
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static List<Integer> getWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String inputWinningNumbers = Console.readLine().trim();
        System.out.println();
        inputValidate(inputWinningNumbers);
        return convertToIntegerList(inputWinningNumbers);
    }

    private static void inputValidate(String inputWinningNumbers) {
        if (!WINNING_NUMBERS_PATTERN.matcher(inputWinningNumbers).matches()) {
            throw new InvalidWinningNumbersException();
        }
    }

    private static List<Integer> convertToIntegerList(String inputWinningNumbers) {
        String[] parts = inputWinningNumbers.split(",");
        return Arrays.stream(parts)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
