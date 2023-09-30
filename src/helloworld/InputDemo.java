/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helloworld;
import java.util.Scanner;

/**
 *
 * @author swarn
 */
public class InputDemo {
    
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        String name = user_input.next();
        System.out.println("Hello"+name);
        String age_string = user_input.next();
        int age = Integer.parseInt(age_string);
        System.out.println("In 20 years I will be"+ (age + 20));
        System.out.println(" years old");
    }
    
    
    
}
