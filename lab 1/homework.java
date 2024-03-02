public class homework {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        if (args.length != 3) {
            System.out.println("Usage: java Homework <a> <b> <k>");
            System.exit(0); // Terminate the program
        }

        int a=0, b=0, k=0;

        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            k = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers for a, b, and k.");
            System.exit(0);
        }

        if (a > b) {
            System.out.println("Invalid interval");
            System.exit(0);
        }

        StringBuilder result = new StringBuilder("K-Reductible Numbers:");

        for (int i = a; i <= b; i++) {
            if (isKReductible(i, k)) {
                result.append(" ").append(i);
            }
        }

        long endTime = System.nanoTime();

        System.out.println(result);


        System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");
    }

    private static boolean isKReductible(int num, int k) {
        int result = num;

        while (result >= 10) {
            int sum = 0;
            int temp = result;

            while (temp > 0) {
                int digit = temp % 10;
                sum += digit * digit;
                temp /= 10;
            }

            result = sum;
        }

        return result == k;
    }
}
