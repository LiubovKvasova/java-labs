public class App {
    public static void main(String[] args) {
        // book_number: 0408

        // O1 = +
        // O2 = +
        // C = 0
        // type is int

        final int c = 0;

        final int a = 1;
        final int b = 1;

        final int n = 2;
        final int m = 2;

        double result = 0;
        boolean problemHappened = false;

        if (a > n) {
            System.out.println("Warning: 'a' is bigger than 'n'");
        }

        if (b > m) {
            System.out.println("Warning: 'b' is bigger than 'm'");
        }

        for (int i = a; i <= n && !problemHappened; i++) {
            for (int j = b; j <= m; j++) {
                try {
                    double divided = i + j;
                    double divisor = i + c;

                    // Without this check, Java does consider it as an exception
                    // and the result is Infinity 
                    if (divisor == 0) {
                        throw new Exception("Divisor equals to 0");
                    }

                    result += divided / divisor;
                } catch (Exception e) {
                    String calculationExceptionMessage = "For arguments i = " + i + " and j = " + j + " an exception was thrown: " + e.getMessage();
                    System.out.println(calculationExceptionMessage);
                    problemHappened = true;
                    break;
                }
            }
        }

        if (problemHappened) {
            System.out.println("A problem happened, so no result can be provided.");
        } else {
            System.out.println("The result is: " + result);
        }
    }
}
