/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helloworld;

/**
 *
 * @author swarn
 */
public class BookTest {
    public static void main(String[] args) {
            Book book1 = new Book();
            book1.title = "Game of thrones";
            book1.author = "George R martin";
            book1.publisher = "Harpin Collins";
            book1.price = 450.00;
    
            book1.display();
    }
}
