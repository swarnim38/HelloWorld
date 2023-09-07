/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helloworld;

/**
 *
 * @author swarn
 */
public class PercentageCalculator {
    public static void main(String[] args) {
        int total_marks = 400;
        double marks_obtained = 346;
        double percentage = 0.0;
        
        percentage = (marks_obtained/total_marks)*100;
        System.out.println("student1's marks = "+percentage);
        if (percentage >= 40) {
            System.out.println("PASSED");
        }
        else {
            System.out.println("FAILED");
        }
        marks_obtained = 144;
        percentage = (marks_obtained/total_marks)*100;
        System.out.println("Student2's marks = "+percentage);
        if (percentage >=40) {
            System.out.println("Passed");
        }
        else {
                System.out.println("Failed");}
    }
    
}
