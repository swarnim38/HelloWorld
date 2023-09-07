package helloworld;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author swarn
 */
public class switch_statement {
    public static void main (String [ ] args) {
        int today = 5;
        String day = "";
        day = switch (today) {
            case 1 -> "Monday";
            case 2 -> "Tuuesday";
            case 3 -> "Wednessday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Incorrect day";
        };
    }
    
}
