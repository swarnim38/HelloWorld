/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helloworld;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author swarn
 */
public class mySQL_demo {
    public static void main(String args[]) {
        String dbURL = "jdbc:mysql://localhost:3306/school";
        String username = "root";
        String password = "swarnim";
        try{
            Connection dbCon = DriverManager.getConnection(dbURL, username, password);
            Statement stnt = dbCon.createStatement();
            String query = "select * from book";
            ResultSet rs = stnt.executeQuery(query);
        
            while(rs.next()){
                for (int i = 1; i <= 5; i++) {
                    System.out.print(rs.getString(i));
                    System.out.print("|");
                }
                System.out.println();
                
            }
           } catch (SQLException ex) {
              System.out.println(ex.getMessage());
           }
    }
            
    
}
