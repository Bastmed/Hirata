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
    
}
