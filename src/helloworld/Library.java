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
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/school";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "swarnim";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

            boolean continueRunning = true;
            while (continueRunning) {
                System.out.println("Choose an action:");
                System.out.println("1. See entry using Bcode");
                System.out.println("2. Add an entry");
                System.out.println("3. Edit an entry");
                System.out.println("4. Delete an entry");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Bcode to see entry: ");
                        int bcode = scanner.nextInt();
                        getBookInfo(connection, bcode);
                        break;
                    case 2:
                        addEntry(connection, scanner);
                        break;
                    case 3:
                        // Logic to edit entry
                        // Prompt user for Bcode, field to edit, and new value
                        break;
                    case 4:
                        // Logic to delete entry
                        // Prompt user for Bcode to delete
                        break;
                    case 5:
                        continueRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Existing insertData method...

    private static void getBookInfo(Connection connection, int bcode) throws SQLException {
        String selectQuery = "SELECT * FROM book WHERE Bcode = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, bcode);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Book details:");
                System.out.println("Title: " + resultSet.getString("Title"));
                System.out.println("Author: " + resultSet.getString("Author"));
                System.out.println("Publisher: " + resultSet.getString("Publisher"));
                System.out.println("Genre: " + resultSet.getString("Genre"));
                System.out.println("Price: " + resultSet.getInt("Price"));
            } else {
                System.out.println("Entry with Bcode " + bcode + " not found!");
            }
        }
    }

    private static void addEntry(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter Book details to add:");
        System.out.print("Title: ");
        scanner.nextLine(); // Consume newline character
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Publisher: ");
        String publisher = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Price: ");
        int price = scanner.nextInt();

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

    private static void deleteEntry(Connection connection, int bcode) throws SQLException {
        String deleteQuery = "DELETE FROM book WHERE Bcode = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, bcode);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Entry with Bcode " + bcode + " deleted successfully!");
            } else {
                System.out.println("Entry with Bcode " + bcode + " not found!");
            }
        }
    }

    private static void editEntry(Connection connection, int bcode, String fieldToEdit, String newValue) throws SQLException {
        String updateQuery = "UPDATE book SET " + fieldToEdit + " = ? WHERE Bcode = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newValue);
            preparedStatement.setInt(2, bcode);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Entry with Bcode " + bcode + " updated successfully!");
            } else {
                System.out.println("Entry with Bcode " + bcode + " not found!");
            }
        }
    }
}