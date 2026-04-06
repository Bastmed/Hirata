/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DB;

import Db.ConductorDao;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author broma
 */
public class ConductorDaoTest {

    @Test
    public void testListarConductores() throws Exception {
        ConductorDao dao = new ConductorDao();

        List<String> lista = dao.listarNombresConductores();

        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testRutValido() {
        ConductorDao dao = new ConductorDao();
        boolean resultado = dao.esRutValido("21863417-6");
        assertTrue(resultado);
    }

    @Test
    public void testRutInvalido() {
        ConductorDao dao = new ConductorDao();
        boolean resultado = dao.esRutValido("12345678-9");
        assertFalse(resultado);
    }

    public class InsertarConductorTest {

        @Test
        public void testInsertarConductor() {
            ConductorDao dao = new ConductorDao();

            try {
                dao.insertarConductor("TestNombre", "11111111-1");
                assertTrue(true);
            } catch (Exception e) {
                fail("Error al insertar conductor");
            }
        }
    }
}
