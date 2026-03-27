package Db;

import Model.RegisCamion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CamionDao {

// Inserta camión y asigna conductor existente
    public void insertar(RegisCamion c) throws SQLException {
        Connection con = Conexion.conectarDb();
        try {
            // Verificar si ya existe camión con esa patente
            String checkCamion = "SELECT idCamion FROM camiones WHERE patente = ?";
            try (PreparedStatement psCheck = con.prepareStatement(checkCamion)) {
                psCheck.setString(1, c.getPatente());
                try (ResultSet rs = psCheck.executeQuery()) {
                    if (rs.next()) {
                        throw new SQLException("El camión con patente " + c.getPatente() + " ya está registrado.");
                    }
                }
            }

            // Insertar camión
            String sqlCamion = "INSERT INTO camiones (patente, marca, modelo, anio, kilometraje) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement psCamion = con.prepareStatement(sqlCamion)) {
                psCamion.setString(1, c.getPatente());
                psCamion.setString(2, c.getMarca());
                psCamion.setString(3, c.getModelo());
                psCamion.setInt(4, c.getAnio());
                psCamion.setInt(5, c.getKilometraje());
                psCamion.executeUpdate();
            }

            int idCamion = 0;
            int idConductor = 0;

            // Obtener idCamion recién insertado
            String buscarCamion = "SELECT idCamion FROM camiones WHERE patente = ?";
            try (PreparedStatement psBuscarCamion = con.prepareStatement(buscarCamion)) {
                psBuscarCamion.setString(1, c.getPatente());
                try (ResultSet rs = psBuscarCamion.executeQuery()) {
                    if (rs.next()) {
                        idCamion = rs.getInt("idCamion");
                    }
                }
            }

            // Buscar conductor por nombre
            String checkConductor = "SELECT id_conductor FROM conductores WHERE nombre = ?";
            try (PreparedStatement psCheckCon = con.prepareStatement(checkConductor)) {
                psCheckCon.setString(1, c.getNombreConductor());
                try (ResultSet rs = psCheckCon.executeQuery()) {
                    if (rs.next()) {
                        idConductor = rs.getInt("id_conductor");
                    }
                }
            }

            if (idConductor == 0) {
                throw new SQLException("El conductor " + c.getNombreConductor() + " no existe. Regístrelo primero.");
            }

            // Insertar asignación (si no existe)
            String checkAsignacion = "SELECT 1 FROM asignacion WHERE id_camion = ? AND id_conductor = ?";
            try (PreparedStatement psCheckAsig = con.prepareStatement(checkAsignacion)) {
                psCheckAsig.setInt(1, idCamion);
                psCheckAsig.setInt(2, idConductor);
                try (ResultSet rs = psCheckAsig.executeQuery()) {
                    if (!rs.next()) {
                        String sqlAsignacion = "INSERT INTO asignacion (id_camion, id_conductor) VALUES (?, ?)";
                        try (PreparedStatement psAsignacion = con.prepareStatement(sqlAsignacion)) {
                            psAsignacion.setInt(1, idCamion);
                            psAsignacion.setInt(2, idConductor);
                            psAsignacion.executeUpdate();
                        }
                    }
                }
            }

        } finally {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    //Actualiza patente, marca, modelo y año usando idCamion 
    public void actualizarPorId(int idCamion, RegisCamion c) throws SQLException {
        try (Connection con = Conexion.conectarDb()) {
            // 1. Actualizar datos del camión
            String sqlCamion = "UPDATE camiones SET patente = ?, marca = ?, modelo = ?, anio = ? WHERE idCamion = ?";
            try (PreparedStatement ps = con.prepareStatement(sqlCamion)) {
                ps.setString(1, c.getPatente());
                ps.setString(2, c.getMarca());
                ps.setString(3, c.getModelo());
                ps.setInt(4, c.getAnio());
                ps.setInt(5, idCamion);
                ps.executeUpdate();
            }

            // 2. Verificar si existe el conductor
            int idConductor = 0;
            String buscarConductor = "SELECT id_conductor FROM conductores WHERE nombre = ?";
            try (PreparedStatement ps = con.prepareStatement(buscarConductor)) {
                ps.setString(1, c.getNombreConductor());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        idConductor = rs.getInt("id_conductor");
                    }
                }
            }

            // 4. Actualizar asignación (relación camión–conductor)
            String sqlAsignacion = "UPDATE asignacion SET id_conductor = ? WHERE id_camion = ?";
            try (PreparedStatement ps = con.prepareStatement(sqlAsignacion)) {
                ps.setInt(1, idConductor);
                ps.setInt(2, idCamion);
                ps.executeUpdate();
            }
        }
    }

    // Actualiza solo marca, modelo y año (NO modifica kilometraje ni patente)
    public void actualizar(RegisCamion c) throws SQLException {
        String sql = "UPDATE camiones SET marca = ?, modelo = ?, anio = ? WHERE patente = ?";
        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getMarca());
            ps.setString(2, c.getModelo());
            ps.setInt(3, c.getAnio());
            ps.setString(4, c.getPatente());
            int filas = ps.executeUpdate();
            if (filas == 0) {
                throw new SQLException("No se encontró camión con la patente: " + c.getPatente());
            }
        }
        // Actualizar conductor/asignación 
        // actualizamos la asignación para apuntar al conductor con ese nombre
    }

    // Método específico para actualizar solo el kilometraje
    public void actualizarKilometraje(String patente, int kilometraje) throws SQLException {
        String sql = "UPDATE camiones SET kilometraje = ? WHERE patente = ?";
        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, kilometraje);
            ps.setString(2, patente);
            int filas = ps.executeUpdate();
            if (filas == 0) {
                throw new SQLException("No se encontró camión con la patente: " + patente);
            }
        }
    }

    // Elimina camión por patente
    public void eliminar(String patente) throws SQLException {
        String sql = "DELETE FROM camiones WHERE patente = ?";
        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, patente);
            ps.executeUpdate();
        }
    }

    // Lista todos los camiones con su conductor (si existe)
    public List<RegisCamion> listarTodos() throws SQLException {
        List<RegisCamion> lista = new ArrayList<>();
        String sql = "SELECT c.idCamion, c.patente, c.marca, c.modelo, c.anio, c.kilometraje, d.nombre "
                + "FROM camiones c "
                + "LEFT JOIN asignacion a ON c.idCamion = a.id_camion "
                + "LEFT JOIN conductores d ON a.id_conductor = d.id_conductor";
        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                RegisCamion rc = new RegisCamion();
                rc.setIdCamion(rs.getInt("idCamion"));
                rc.setPatente(rs.getString("patente"));
                rc.setMarca(rs.getString("marca"));
                rc.setModelo(rs.getString("modelo"));
                rc.setAnio(rs.getInt("anio"));
                rc.setKilometraje(rs.getInt("kilometraje"));
                rc.setNombreConductor(rs.getString("nombre"));
                lista.add(rc);
            }
        }
        return lista;
    }

    // Buscar por patente (útil para validar antes de actualizar o mostrar)
    public RegisCamion buscarPorPatente(String patente) throws SQLException {
        String sql = "SELECT c.idCamion, c.patente, c.marca, c.modelo, c.anio, c.kilometraje, d.nombre "
                + "FROM camiones c "
                + "LEFT JOIN asignacion a ON c.idCamion = a.id_camion "
                + "LEFT JOIN conductores d ON a.id_conductor = d.id_conductor "
                + "WHERE c.patente = ?";
        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, patente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    RegisCamion rc = new RegisCamion();
                    rc.setIdCamion(rs.getInt("idCamion"));
                    rc.setPatente(rs.getString("patente"));
                    rc.setMarca(rs.getString("marca"));
                    rc.setModelo(rs.getString("modelo"));
                    rc.setAnio(rs.getInt("anio"));
                    rc.setKilometraje(rs.getInt("kilometraje"));
                    rc.setNombreConductor(rs.getString("nombre"));
                    return rc;
                }
            }
        }
        return null;
    }
}
