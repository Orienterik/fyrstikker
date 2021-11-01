import java.math.BigInteger;
import java.util.Scanner;

public class Fyrstikker {

    public static void main(String[] args) {
        int sticks;
        try (Scanner scanner = new Scanner(System.in)) {
            sticks = scanner.nextInt();
        }

        BigInteger[] possibleNumbersList = new BigInteger[Math.max(sticks + 1, 7)];
        possibleNumbersList[0] = BigInteger.valueOf(0);
        possibleNumbersList[1] = BigInteger.valueOf(0);
        possibleNumbersList[2] = BigInteger.valueOf(1);
        possibleNumbersList[3] = BigInteger.valueOf(2);
        possibleNumbersList[4] = BigInteger.valueOf(4);
        possibleNumbersList[5] = BigInteger.valueOf(9);
        possibleNumbersList[6] = BigInteger.valueOf(16);

        for (int i = 7; i <= sticks; i++) {
            possibleNumbersList[i] = BigInteger
                    // Single digit numbers
                    .valueOf(10)
                    // Numbers starting with 0
                    .add(possibleNumbersList[i - 6])
                    // Numbers starting with 1
                    .add(possibleNumbersList[i - 2])
                    // Numbers starting with 2
                    .add(possibleNumbersList[i - 5])
                    // Numbers starting with 3
                    .add(possibleNumbersList[i - 5])
                    // Numbers starting with 4
                    .add(possibleNumbersList[i - 4])
                    // Numbers starting with 5
                    .add(possibleNumbersList[i - 5])
                    // Numbers starting with 6
                    .add(possibleNumbersList[i - 6])
                    // Numbers starting with 7
                    .add(possibleNumbersList[i - 3])
                    // Numbers starting with 8
                    .add(possibleNumbersList[i - 7])
                    // Numbers starting with 9
                    .add(possibleNumbersList[i - 6]);
        }

        BigInteger possibleNumbers = possibleNumbersList[sticks];
        BigInteger startingWithZero = sticks >= 6 ? possibleNumbersList[sticks - 6] : BigInteger.ZERO;
        System.out.println(possibleNumbers.subtract(startingWithZero));
    }
}