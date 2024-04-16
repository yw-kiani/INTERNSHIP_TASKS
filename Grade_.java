package Tasks;
import java.util.Scanner;
public class Grade_ {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Take marks obtained in each subject
        System.out.println("Enter marks obtained in each subject (out of 100):");
        int subjects = 0;
        int TMarks = 0;

        while (true) {
            System.out.print("Subject " + (subjects + 1) + ": ");
            int obmarks = sc.nextInt();

            if (obmarks < 0 || obmarks > 100) {
                System.out.println("Invalid input! Marks should be between 0 and 100.");
                continue;
            }

            TMarks += obmarks;
            subjects++;

            System.out.print("Do you have more subjects? (yes/no): ");
            String moreSubjects = sc.next().toLowerCase();

            if (moreSubjects.equals("no")) {
                break;
            }
        }


        // Calculation: Calculate Total Marks
        // Calculate Average Percentage
        double avPercent = (double)TMarks / subjects;

        // Grade Calculation
        char gr;
        if (avPercent >= 90) {
            gr = 'A';
        } else if (avPercent >= 80) {
            gr = 'B';
        } else if (avPercent >= 70) {
            gr = 'C';
        } else if (avPercent >= 60) {
            gr = 'D';
        } else {
            gr = 'F';
        }

        // Display Results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + TMarks);
        System.out.println("Average Percentage: " + avPercent + "%");
        System.out.println("Grade"+gr);}}
