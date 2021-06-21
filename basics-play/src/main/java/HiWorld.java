import java.util.Random;

public class HiWorld {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            int res = random.nextInt(3) + 1;
            System.out.println("random choice: " + res);
        }
    }
}
