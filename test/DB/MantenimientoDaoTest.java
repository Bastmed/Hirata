/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DB;

import Db.MantenimientoDao;
import Model.RegisMantenimiento;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test para MantenimientoDao usando JUnit 4 Compatible con NetBeans 18
 */
public class MantenimientoDaoTest {

    @Test
    public void testInsertarMantenimiento() throws Exception {
        MantenimientoDao dao = new MantenimientoDao();
        int idCamion = 1; // Ajustar según tu BD

        // Crear registro de prueba
        RegisMantenimiento m = new RegisMantenimiento();
        m.setFecha(new java.sql.Date(new java.util.Date().getTime()));
        m.setTipo("Test");
        m.setDescripcion("Insert desde test");

        // Insertar
        dao.insertarMantenimiento(idCamion, m);

        // Verificar que se insertó
        List<RegisMantenimiento> lista = dao.listarMantenimientos();
        boolean encontrado = false;
        for (RegisMantenimiento r : lista) {
            if ("Test".equals(r.getTipo()) && "Insert desde test".equals(r.getDescripcion())) {
                encontrado = true;
                break;
            }
        }

        assertTrue("No se encontró el registro insertado", encontrado);
    }
}
