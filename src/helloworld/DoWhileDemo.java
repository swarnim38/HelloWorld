/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helloworld;

/**
 *
 * @author swarn
 */
public class DoWhileDemo {
    public static void main (String [ ] args) {
    int number = 6;
    do{
        System.out.print("Square of" + number);
        System.out.println("=" + number*number);
        ++number;
        } while (number <=5);
    }
}
