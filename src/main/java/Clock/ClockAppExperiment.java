package Clock;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClockAppExperiment {
    public static void main(String[] args) {
        int hours = 0;
        int minutes = 0;
        Clock userClock;
//        Clock updateClock;
//        Clock updatedClock;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Clock App. Please enter an integer to set an hour you want: an eligible choice would be a number between 0 and 23; otherwise the clock won't work");

        while ((hours >= 0) && (hours <= 23)) {
            try {
                hours = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Integers only in range 0 to 23, please");
            }
        }
        System.out.println("Please enter an integer to set minutes: an eligible choice would be a number between 0 and 59");
        while ((minutes >= 0) && (minutes <= 59)) {
            try {
                minutes = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Integers only in range 0 to 59, please");
            }
        }
//        while (true) {
//        hours= scanner.nextInt();
//        if (hours >= 0 && hours <=23) {
//        break;
//        } else {
//                System.out.println("Please enter an integer between 0 and 23; otherwise the clock won't work");
//        }
//        }
//        System.out.println("Please enter an integer to set minutes: an eligible choice would be a number between 0 and 59");
//        while (true) {
//            minutes = scanner.nextInt();
//            if(minutes >=0 && minutes <=59){
//                break;
//            } else {
//                System.out.println("Please enter an integer between 0 and 59; otherwise the clock won't work");
//            }
//        }

        try {
            userClock = new Clock(hours, minutes);
            System.out.println("Your clock has been set: " + userClock.toString());
//            System.out.println("Would you like to update your clock? If so, please enter 'yes'");
//       // String decision = scanner.nextLine();
//        //    if (decision.equals("yes")==true) {
//                System.out.println("Please enter an integer to set an hour you want: an eligible choice would be a number between 0 and 23; otherwise the clock won't work");
//                while ((hours >= 0) && (hours <= 23)) {
//                    try {
//                        hours = scanner.nextInt();
//                        break;
//                    } catch (InputMismatchException e){
//                        scanner.nextLine();
//                        System.out.println("Integers only in range 0 to 23, please");
//                    }
//                }
//                System.out.println("Please enter an integer to update minutes: an eligible choice would be a number between 0 and 59");
//                while ((minutes >= 0) && (minutes <=59)){
//                    try {
//                        minutes= scanner.nextInt();
//                        break;
//                    } catch (InputMismatchException e){
//                        scanner.nextLine();
//                        System.out.println("Integers only in range 0 to 59, please");
//                    }
//                }
//                try{
//                    updateClock= new Clock(hours, minutes);
//                    updatedClock= userClock.addAnotherClockTime(updateClock);
//                    System.out.println("Your clock after an update: "+ updatedClock);
//                } catch (IllegalArgumentException e){
//                    System.out.println("Invalid input");
//                }
//
//           } //else {
////                System.out.println("Thank you for using ClockApp");
////            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input");
//        }
        }
    }
}

