/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author 21694
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class connexion {
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost/hospital";
    public static String user = "root";
    public static String password = "";

    public static Connection  getConnect() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("connexion reussie");
                return con;
 
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
 
        }
 
        return null;

    }
}