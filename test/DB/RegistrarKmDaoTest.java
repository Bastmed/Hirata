package DB;

import org.junit.Test;
import static org.junit.Assert.*;
import Views.CamionVisual;

public class RegistrarKmDaoTest {

    @Test
    public void testKilometrajeMayor5000() {

        CamionVisual visual = new CamionVisual();

        boolean resultado = visual.necesitaMantenimiento(6000);

        assertTrue(resultado);
    }

    @Test
    public void testKilometrajeMenor5000() {

        CamionVisual visual = new CamionVisual();

        boolean resultado = visual.necesitaMantenimiento(3000);

        assertFalse(resultado);
    }
}
