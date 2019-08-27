package Clock;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClockApp {
    public static void main(String[] args) {
        int hours, minutes;
        Clock userClock;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Clock App. Please enter an integer to set an hour you want: an eligible choice would be a number between 0 and 23; otherwise the clock won't work");
        try {
            while (true) {
                hours = scanner.nextInt();
                if (hours >= 0 && hours <= 23) {
                    break;
                } else {
                    System.out.println("Please enter an integer between 0 and 23; otherwise the clock won't work");
                }
            }
            System.out.println("Please enter an integer to set minutes: an eligible choice would be a number between 0 and 59");
            while (true) {
                minutes = scanner.nextInt();
                if (minutes >= 0 && minutes <= 59) {
                    break;
                } else {
                    System.out.println("Please enter an integer between 0 and 59; otherwise the clock won't work");
                }
            }
            userClock = new Clock(hours, minutes);
            System.out.println("Your clock has been set: " + userClock.toString());
        } catch (InputMismatchException e){
            System.out.println("Only integers, please");
        }

    }
}

