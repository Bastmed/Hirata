/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DB;

import Db.CamionDao;
import Db.CamionDao.ValidadorCamion;
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
    public void testPatenteValida() {
        assertTrue(ValidadorCamion.validarPatente("ABC123"));
    }

    @Test
    public void testPatenteInvalida() {
        assertFalse(ValidadorCamion.validarPatente(""));
        assertFalse(ValidadorCamion.validarPatente(null));
    }

    @Test
    public void testKilometrajeValido() {
        assertTrue(ValidadorCamion.validarKilometraje(5000));
    }

    @Test
    public void testKilometrajeInvalido() {
        assertFalse(ValidadorCamion.validarKilometraje(-10));
    }

    @Test
    public void testGasolinaValida() {
        assertTrue(ValidadorCamion.validarGasolina(50));
    }

    @Test
    public void testGasolinaInvalida() {
        assertFalse(ValidadorCamion.validarGasolina(-1));
    }

    @Test
    public void testInsertarCamion() {
        CamionDao dao = new CamionDao();

        RegisCamion c = new RegisCamion();
        c.setPatente("TEST" + System.currentTimeMillis()); // evita duplicados
        c.setMarca("Marca");
        c.setModelo("Modelo");
        c.setAnio(2020);
        c.setNombreConductor("Manolo"); // debe existir en BD

        try {
            dao.insertar(c);

            RegisCamion resultado = dao.buscarPorPatente(c.getPatente());
            assertNotNull(resultado);

        } catch (Exception e) {
            fail("Error al insertar camión: " + e.getMessage());
        }
    }

    @Test
    public void testPatenteDuplicada() {
        CamionDao dao = new CamionDao();

        String patente = "DUP" + System.currentTimeMillis();

        try {
            RegisCamion c1 = new RegisCamion();
            c1.setPatente(patente);
            c1.setMarca("M");
            c1.setModelo("X");
            c1.setAnio(2020);
            c1.setNombreConductor("Manolo");

            dao.insertar(c1);

            RegisCamion existente = dao.buscarPorPatente(patente);

            assertNotNull(existente);
            assertEquals(patente, existente.getPatente());

        } catch (Exception e) {
            fail("Error en validación de patente: " + e.getMessage());
        }
    }

    @Test
    public void testListarCamiones() {
        CamionDao dao = new CamionDao();

        try {
            assertNotNull(dao.listarTodos());
        } catch (Exception e) {
            fail("Error al listar camiones");
        }
    }
}
