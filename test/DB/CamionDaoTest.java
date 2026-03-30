/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DB;

import Db.CamionDao;
import Model.RegisCamion;
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
public class CamionDaoTest {
    
    @Test
    public void testBuscarPorPatente() throws Exception {
        CamionDao dao = new CamionDao();

        RegisCamion camion = dao.buscarPorPatente("webi");

        assertNotNull(camion);
        assertEquals("webi", camion.getPatente());
    }

    @Test
    public void testObtenerIdPorPatente() throws Exception {
        CamionDao dao = new CamionDao();

        int id = dao.obtenerIdPorPatente("webi");

        assertTrue(id > 0);
    }
    
}
