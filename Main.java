import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the speed limit:");
        int limit = sc.nextInt();
        System.out.println("Enter the recorded speed of the car:");
        int speed = sc.nextInt();
        if (speed <= limit) {
            System.out.println("Congratulations, you are within the speed limit!");
        }
        else {
            int fine;
            if (speed - limit <= 20) {
                fine = 100;
            }
            else if (speed - limit <= 30) {
                fine = 270;
            }
            else {
                fine = 500;
            }
            System.out.println("You are speeding and your fine is $" + fine);
        }
    }
}
