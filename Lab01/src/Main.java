// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class Main {
    public static int sumDigits(int n) {
        while (n > 9) {
            int sum = 0;
            while (n > 0) {
                sum = sum + n % 10;
                n = n / 10;
            }
            n = sum;
        }
        return n;
    }
    public static void main(String[] args) {
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;
        int result = sumDigits(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}





