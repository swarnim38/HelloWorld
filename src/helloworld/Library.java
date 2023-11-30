/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helloworld;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author swarn
 */
public class Library {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/school";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "swarnim";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

            System.out.println("Enter Book details:");
            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Publisher: ");
            String publisher = scanner.nextLine();

            System.out.print("Genre: ");
            String genre = scanner.nextLine();

            System.out.print("Price: ");
            int price = scanner.nextInt();

            // Insert data into the database
            insertData(connection, title, author, publisher, genre, price);

            // Retrieve info about a specific book using BNO
            System.out.print("Enter Book Number (BNO) to get info: ");
            int bno = scanner.nextInt();
            getBookInfo(connection, bno);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData(Connection connection, String title, String author, String publisher, String genre, int price) throws SQLException {
        String insertQuery = "INSERT INTO book (Title, Author, Publisher, Genre, Price) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setString(3, publisher);
            preparedStatement.setString(4, genre);
            preparedStatement.setInt(5, price);

            preparedStatement.executeUpdate();
            System.out.println("Book data inserted successfully!");
        }
    }

    private static void getBookInfo(Connection connection, int bno) throws SQLException {
    String selectQuery = "SELECT * FROM book WHERE Bcode = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
        preparedStatement.setInt(1, bno);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Book details:");
            System.out.println("Title: " + resultSet.getString("Title"));
            System.out.println("Author: " + resultSet.getString("Author"));
            System.out.println("Publisher: " + resultSet.getString("Publisher"));
            System.out.println("Genre: " + resultSet.getString("Genre"));
            System.out.println("Price: " + resultSet.getInt("Price"));
        } else {
            System.out.println("Book with BNO " + bno + " not found!");
        }
    }
}
}
