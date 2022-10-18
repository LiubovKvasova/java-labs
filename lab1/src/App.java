public class App {
    public static void main(String[] args) {
        // book_number: 0408

        // O1 = +
        // O2 = +
        // C = 0
        // type is int

        int c = 0;

        int a = 1;
        int b = 0;

        int n = 7;
        int m = 8;

        double result = 0;
        boolean problemHappened = false;

        if (a > n) {
            System.out.println("'a' is bigger than 'n'. Please, correct it");
            problemHappened = true;
        }

        if (b > m) {
            System.out.println("'b' is bigger than 'm'. Please, correct it");
            problemHappened = true;
        }

        for (int i = a; i <= n && !problemHappened; i++) {
            for (int j = b; j <= m; j++) {
                try {
                    double divided = i + j;
                    double divisor = i + c;
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
