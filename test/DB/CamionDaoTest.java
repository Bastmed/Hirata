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

    
}
