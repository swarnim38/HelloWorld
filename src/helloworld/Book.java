/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helloworld;

/**
 *
 * @author swarn
 */
public class Book {
    String title;
    String author;
    String publisher;
    String genre;
    double price;
    
    Void display() {
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Publisher: "+publisher);
        System.out.println("Genre: "+genre);
        System.out.println("Price: "+price);
        return (null);
        
    }
}
