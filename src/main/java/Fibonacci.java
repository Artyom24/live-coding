import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author <Artyom Baranov>
 * @since 19 апр. 2023 г.
 */
public class Fibonacci {

    public static void main(String[] args) {


    }

    /**
     * Расчёт первых n чисел Фибоначчи через цикл
     * @param n - кол-во первых чисел Фибоначчи
     */
    private static int[] getFibonacciInteger(int n) {
        int[] result = new int[n];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2; i < n; i++) {
            result[i] = result[i -1] + result[i - 2];
        }
        return result;
    }


}
