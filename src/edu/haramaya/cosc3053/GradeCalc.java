package edu.haramaya.cosc3053;
import java.util.Scanner;

public class GradeCalc {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double mark = -1.0;

        System.out.println("=========================================");
        System.out.println("   HARAMAYA CS: GRADE CALCULATOR ENGINE");
        System.out.println("=========================================");

        // 1. Input validation
        do {
            System.out.print("Enter exam mark [0.0 - 100.0]: ");

            if (scanner.hasNextDouble()) {

                mark = scanner.nextDouble();

                if (mark < 0.0 || mark > 100.0) {
                    System.out.println(
                            "Invalid Score! Mark must be between 0 and 100.\n"
                    );
                }

            } else {

                System.out.println(
                        "Invalid Input! Please enter a valid number.\n"
                );

                scanner.next(); // Remove invalid input
            }

        } while (mark < 0.0 || mark > 100.0);

        // 2. Calculate letter grade
        char letterGrade;

        if (mark >= 90.0) {
            letterGrade = 'A';
        } else if (mark >= 80.0) {
            letterGrade = 'B';
        } else if (mark >= 70.0) {
            letterGrade = 'C';
        } else if (mark >= 60.0) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }

        // 3. Generate instructor remarks
        String remarks = switch (letterGrade) {
            case 'A' -> "Distinction! Outstanding academic performance.";
            case 'B' -> "Very Good! Upper division pass.";
            case 'C' -> "Satisfactory Pass.";
            case 'D' -> "Conditional Pass. Support recommended.";
            case 'F' -> "Unsatisfactory. Academic re-evaluation required.";
            default -> "Unknown Grade State.";
        };

        // 4. Pass or fail decision
        boolean isPassed = (letterGrade != 'F');

        // 5. Display final results
        System.out.println("\n-----------------------------------------");
        System.out.println("           FINAL EVALUATION RESULT");
        System.out.println("-----------------------------------------");

        System.out.printf(" Exam Mark Score : %.2f / 100.00%n", mark);
        System.out.println(" Letter Grade    : " + letterGrade);

        System.out.println(
                " Academic Status : " +
                        (isPassed ? "PASSED" : "FAILED")
        );

        System.out.println(" Instructor Remark: " + remarks);

        System.out.println("=========================================");

        scanner.close();
    }
}

