package Db;

import Model.RegistrarKm;
import java.sql.*;

public class RegistrarKmDao {

    private static final String SQL_INSERT
            = "INSERT INTO registro_kilometraje (patente_camion, nombre_conductor, kilometraje) VALUES (?, ?, ?)";

    public void insertar(RegistrarKm d) throws SQLException {
        try (Connection conexion = Conexion.conectarDb(); PreparedStatement ps = conexion.prepareStatement(SQL_INSERT)) {

            ps.setString(1, d.getPatenteCamion());
            ps.setString(2, d.getNombreConductor());
            ps.setInt(3, d.getKilometraje());  // ahora int

            ps.executeUpdate();
        }
    }
    
    public int traerIDRegistro(String patente, String conductor, int km) throws SQLException {
    String sql = "SELECT id FROM registro_kilometraje WHERE patente_camion = ? AND nombre_conductor = ? AND kilometraje = ?";
    try (Connection con = Conexion.conectarDb();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, patente);
        ps.setString(2, conductor);
        ps.setInt(3, km);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt("id");
            else return -1;
        }
    }
}
}
