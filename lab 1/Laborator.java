public class Laborator {
    public static void main(String[] args){
        System.out.println("Hello world!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        int result = n * 3;
        result += Integer.parseInt("10101", 2);
        result += Integer.parseInt("FF", 16);
        result *= 6;

        while(result>9){
            result=sumDigits(result);
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
    private static int sumDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
