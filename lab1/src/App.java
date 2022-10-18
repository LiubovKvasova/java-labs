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
        boolean exceptionHappened = false;

        for (int i = a; i < n && !exceptionHappened; i++) {
            for (int j = b; j < m; j++) {
                try {
                    result += (i + j) / (i + c);
                } catch (Exception e) {
                    String calculationExceptionMessage = "For arguments i = " + i + " and j = " + j + " an exception was thrown: " + e.getMessage();
                    System.out.println(calculationExceptionMessage);
                    exceptionHappened = true;
                    break;
                }
            }
        }
        
        

        if (exceptionHappened) {
            System.out.println("An exception was thrown, so no result can be provided.");
        } else {
            System.out.println("The result is: " + result);
        }
    }
}