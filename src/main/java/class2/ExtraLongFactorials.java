package class2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ExtraLongFactorialsResult {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     * Calculate and print the factorial of a given integer.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }
}

class ExtraLongFactorialsResult2 {

    public static void extraLongFactorials(int n) {
        long result = extraLongFactorialsRecursive(n);
        System.out.println(result);
    }

//    public static BigInteger extraLongFactorials(int n, BigInteger result) {
//        if (n == 1) {
//            return result;
//        } else {
//            return extraLongFactorials(n - 1, result.multiply(BigInteger.valueOf(n)));
//        }
//    }

    public static long extraLongFactorialsRecursive(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * extraLongFactorialsRecursive(n - 1);
        }
    }
}

public class ExtraLongFactorials {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        ExtraLongFactorialsResult2.extraLongFactorials(n);

        bufferedReader.close();
    }
}

