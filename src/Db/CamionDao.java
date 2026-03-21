package Db;

import Model.Camion;
import java.sql.*;

public class CamionDao {

    public void insertar(Camion c) throws SQLException {

        Connection con = Conexion.conectarDb();

        try {

            // 1. Insertar camión
            String sqlCamion = "INSERT INTO camiones (patente, marca, modelo, anio) VALUES (?, ?, ?, ?)";
            PreparedStatement psCamion = con.prepareStatement(sqlCamion);

            psCamion.setString(1, c.getPatente());
            psCamion.setString(2, c.getMarca());
            psCamion.setString(3, c.getModelo());
            psCamion.setInt(4, c.getAnio());

            psCamion.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Camión ya existe");
        }

        int idCamion = 0;
        int idConductor = 0;

        // 2. Obtener id_camion
        String buscarCamion = "SELECT id_camion FROM camiones WHERE patente = ?";
        PreparedStatement psBuscarCamion = con.prepareStatement(buscarCamion);
        psBuscarCamion.setString(1, c.getPatente());

        ResultSet rsCamion = psBuscarCamion.executeQuery();

        if (rsCamion.next()) {
            idCamion = rsCamion.getInt("id_camion");
        }

        try {

            // 3. Insertar conductor
            String sqlConductor = "INSERT INTO conductores (nombre) VALUES (?)";
            PreparedStatement psConductor = con.prepareStatement(sqlConductor);

            psConductor.setString(1, c.getNombreConductor());
            psConductor.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Conductor ya existe");
        }

        // 4. Obtener id_conductor
        String buscarConductor = "SELECT id_conductor FROM conductores WHERE nombre = ?";
        PreparedStatement psBuscarConductor = con.prepareStatement(buscarConductor);
        psBuscarConductor.setString(1, c.getNombreConductor());

        ResultSet rsConductor = psBuscarConductor.executeQuery();

        if (rsConductor.next()) {
            idConductor = rsConductor.getInt("id_conductor");
        }

        try {

            // 5. Asignar conductor al camión
            String sqlAsignacion = "INSERT INTO asignacion (id_camion, id_conductor) VALUES (?, ?)";
            PreparedStatement psAsignacion = con.prepareStatement(sqlAsignacion);

            psAsignacion.setInt(1, idCamion);
            psAsignacion.setInt(2, idConductor);

            psAsignacion.executeUpdate();

        } catch (SQLException e) {
            System.out.println("El camión ya tiene conductor asignado");
        }
    }
}
