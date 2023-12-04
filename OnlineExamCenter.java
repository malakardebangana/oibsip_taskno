import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OnlineExamCenter {
    private static String username;
    private static String password;
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        login(scanner);

        // Update Profile and Password
        updateProfileAndPassword(scanner);

        // Selecting answers for MCQs
        selectAnswersForMCQs(scanner);

        // Timer and Auto Submit
        startTimer();

        // Closing session and Logout
        closeSessionAndLogout(scanner);
    }

    private static void login(Scanner scanner) {
        System.out.println("Welcome to the Online Center!");
        System.out.print("Enter your username: ");
        username = scanner.nextLine();
        System.out.print("Enter your password: ");
        password = scanner.nextLine();
        System.out.println("Login successful! Welcome, " + username + "!");
    }

    private static void updateProfileAndPassword(Scanner scanner) {
        System.out.println("\nUpdate Profile and Password:");
        System.out.print("Do you want to update your profile? (yes/no): ");
        String updateProfileChoice = scanner.nextLine();

        if ("yes".equalsIgnoreCase(updateProfileChoice)) {
            System.out.print("Enter your new profile information: ");

        }

        System.out.print("Do you want to update your password? (yes/no): ");
        String updatePasswordChoice = scanner.nextLine();

        if ("yes".equalsIgnoreCase(updatePasswordChoice)) {
            System.out.print("Enter your current password: ");
            String currentPassword = scanner.nextLine();

            if (currentPassword.equals(password)) {
                System.out.print("Enter your new password: ");
                password = scanner.nextLine();
                System.out.println("Password updated successfully!");
            } else {
                System.out.println("Incorrect current password. Password not updated.");
            }
        }
    }

    private static void selectAnswersForMCQs(Scanner scanner) {
        System.out.println("\nSelecting Answers for MCQs:");
        System.out.println("Here is your MCQ:");
        System.out.println("1. What is the capital of France?");
        System.out.println("a) Berlin");
        System.out.println("b) Madrid");
        System.out.println("c) Paris");
        System.out.print("Your choice (a, b, or c): ");
        String userAnswer = scanner.nextLine();


        if ("c".equalsIgnoreCase(userAnswer)) {
            System.out.println("Correct! You earned a point.");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is c) Paris.");
        }
        System.out.println("Here is your MCQ:");
        System.out.println("2.  What is the pH value of the human body?");
        System.out.println("a) 9.2 to 9.8");
        System.out.println("b)7.0 to 7.8");
        System.out.println("c) 6.1 to 6.3");
        System.out.print("Your choice (a, b, or c): ");
        String userAnswer1 = scanner.nextLine();


        if ("b".equalsIgnoreCase(userAnswer1)) {
            System.out.println("Correct! You earned a point.");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is b) 7.0 to 7.8");
        }
        System.out.println("Here is your MCQ:");
        System.out.println("3.Which of the given amendments made it compulsory for the president to consent to the constitutional Amendment bills?");
        System.out.println("a) 29th");
        System.out.println("b)24th");
        System.out.println("c)22nd");
        System.out.print("Your choice (a, b, or c): ");
        String userAnswer2 = scanner.nextLine();


        if ("b".equalsIgnoreCase(userAnswer2)) {
            System.out.println("Correct! You earned a point.");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is b) 24th");
        }
    }

    private static void startTimer() {
        System.out.println("\nTimer and Auto Submit:");
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.schedule(OnlineExamCenter::submitAnswers, 5, TimeUnit.SECONDS);
    }

    private static void submitAnswers() {
        System.out.println("\nTime's up! Automatically submitting answers.");
        System.out.println("Your final score: " + score);
    }

    private static void closeSessionAndLogout(Scanner scanner) {
        System.out.print("\nDo you want to log out? (yes/no): ");
        String logoutChoice = scanner.nextLine();

        if ("yes".equalsIgnoreCase(logoutChoice)) {
            System.out.println("Closing session. Goodbye, " + username + "!");
            // Add any additional cleanup code if needed
            System.exit(0);
        }
    }
}
