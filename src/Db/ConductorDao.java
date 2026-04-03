package Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConductorDao {

    public void insertarConductor(String nombre, String rut) throws SQLException {
        // Validar que el RUT tenga formato correcto
        if (!esRutValido(rut)) {
            throw new SQLException("El RUT ingresado no es válido: " + rut);
        }

        String sql = "INSERT INTO conductores (nombre, rut) VALUES (?, ?)";
        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, rut);
            ps.executeUpdate();
        }
    }

    // Método simple para validar RUT chileno
    public boolean esRutValido(String rut) {
        rut = rut.replace(".", "").replace("-", "");
        if (rut.length() < 2) {
            return false;
        }

        String numero = rut.substring(0, rut.length() - 1);
        char dv = rut.charAt(rut.length() - 1);

        try {
            Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            return false;
        }

        int suma = 0;
        int factor = 2;
        for (int i = numero.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(numero.charAt(i)) * factor;
            factor++;
            if (factor > 7) {
                factor = 2;
            }
        }
        int resto = 11 - (suma % 11);
        char dvCalculado;
        if (resto == 11) {
            dvCalculado = '0';
        } else if (resto == 10) {
            dvCalculado = 'K';
        } else {
            dvCalculado = Character.forDigit(resto, 10);
        }

        return Character.toUpperCase(dv) == dvCalculado;
    }

    // Listar solo nombres de conductores
    public List<String> listarNombresConductores() throws SQLException {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nombre FROM conductores ORDER BY nombre";
        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }
        }
        return lista;
    }

    public List<String[]> listarConductoresCompleto() throws SQLException {
        List<String[]> lista = new ArrayList<>();

        String sql = "SELECT id_conductor, nombre, rut FROM conductores ORDER BY nombre";

        try (Connection con = Conexion.conectarDb(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new String[]{
                    String.valueOf(rs.getInt("id_conductor")), // fila[0]
                    rs.getString("nombre"), // fila[1]
                    rs.getString("rut") // fila[2]
                });
            }
        }

        return lista;
    }
}
