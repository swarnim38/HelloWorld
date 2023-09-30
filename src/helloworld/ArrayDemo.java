/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helloworld;

/**
 *
 * @author swarn
 */
public class ArrayDemo {
    public static void main (String[] args){
    double[] marks = {346, 144, 103, 256.5, 387.5};
    double total_marks = 400;
    System.out.println("\tCLASS REPORT");
    System.out.println("--------------------------------------------");
    System.out.println("--------------------------------------------");
    for (int i = 0; i < marks.length; i++ )  {
        double percentage = (marks[i]/total_marks)*100;
        String result;
        if (percentage >= 40)
            result = "Passed";
        else
            result = "Failed";
        System.out.print((i+1)+"\t");
        System.out.print(marks[i]+"\t");
        System.out.print(percentage+"\t");
        System.out.println(result);
    System.out.println("-----------------------------------------------");
    }
    }
    
}
