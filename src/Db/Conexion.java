
package Db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexion {
    private static final String url = "jdbc:mysql://localhost:3306/hirata";
    private static final String user = "root";
    private static final String password = ""; 
    
    public static Connection conectarDb() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    } 
}
