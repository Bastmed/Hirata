package Db;

import Model.RegisMantenimiento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MantenimientoDao {

    private static final String SQL_SELECT
            = "SELECT m.id_mantenimiento, c.patente, c.modelo, c.kilometraje, m.fecha, m.tipo, m.descripcion "
            + "FROM camiones c "
            + "LEFT JOIN mantenimientos m ON m.id_camion = c.idCamion";

    public List<RegisMantenimiento> listarMantenimientos() throws SQLException {

        List<RegisMantenimiento> lista = new ArrayList<>();

        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(SQL_SELECT); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                RegisMantenimiento m = new RegisMantenimiento();

                int id = rs.getInt("id_mantenimiento");
                if (rs.wasNull()) {
                    id = -1; // valor especial cuando no hay mantenimiento
                }
                m.setIdMantenimiento(id);
                m.setModelo(rs.getString("modelo"));
                m.setPatente(rs.getString("patente"));
                m.setFecha(rs.getDate("fecha"));
                m.setTipo(rs.getString("tipo"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setKilometraje(rs.getInt("kilometraje"));

                lista.add(m);
            }
        }

        return lista;
    }

    public void insertarMantenimiento(int idCamion, RegisMantenimiento m) throws SQLException {

        String sql = "INSERT INTO mantenimientos (id_camion, fecha, tipo, descripcion) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCamion);
            ps.setDate(2, new java.sql.Date(m.getFecha().getTime()));
            ps.setString(3, m.getTipo());
            ps.setString(4, m.getDescripcion());

            ps.executeUpdate();
        }
    }

    public void actualizar(RegisMantenimiento m) throws SQLException {
        String sql = "UPDATE mantenimientos SET fecha=?, tipo=?, descripcion=? WHERE id_mantenimiento=?";

        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(m.getFecha().getTime()));
            ps.setString(2, m.getTipo());
            ps.setString(3, m.getDescripcion());
            ps.setInt(4, m.getIdMantenimiento());

            ps.executeUpdate();
        }
    }

    public int eliminarMantenimientosDePrueba(int idCamion) throws SQLException {
        String sql = "DELETE FROM mantenimientos WHERE id_camion = ? AND tipo = ? AND descripcion = ?";

        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCamion);
            ps.setString(2, "Test");
            ps.setString(3, "Insert desde test");

            return ps.executeUpdate();
        }
    }

    public void eliminarPorId(int id) throws SQLException {
        String sql = "DELETE FROM mantenimientos WHERE id_mantenimiento = ?";

        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
