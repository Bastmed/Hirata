
package Db;

import Model.RegistrarKm;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;



public class RegistrarKmDao {
    
    
    private static final String SQL_INSERT
            = "INSERT INTO registro_kilometraje (patente_camion, nombre_conductor, kilometraje) VALUES (?, ?, ?)";
    
    
    
    
    public void insertar(RegistrarKm d) throws SQLException {
        try (Connection conexion = Conexion.conectarDb();
             PreparedStatement ps = conexion.prepareStatement(SQL_INSERT)) {

            ps.setString(1, d.getPatenteCamion());
            ps.setString(2, d.getNombreConductor());
            ps.setString(3, d.getKilometraje()); 

            ps.executeUpdate();
        }
    }
}
