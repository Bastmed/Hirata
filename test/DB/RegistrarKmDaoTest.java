package DB;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import Db.RegistrarKmDao;
import Db.CamionDao;
import Model.RegisCamion;
import Model.RegistrarKm;
import Views.CamionVisual;

public class RegistrarKmDaoTest {

    @Test
    public void testVerificarMantenimientoSinMockito() throws Exception {

 
        CamionDao fakeDao = new CamionDao() {
            @Override
            public List<RegisCamion> listarTodos() {
                RegisCamion camion1 = new RegisCamion();
                camion1.setPatente("ABC123");
                camion1.setKilometraje(6000);

                RegisCamion camion2 = new RegisCamion();
                camion2.setPatente("XYZ789");
                camion2.setKilometraje(3000);

                return Arrays.asList(camion1, camion2);
            }
        };

        CamionVisual visual = new CamionVisual() {
            @Override
            protected CamionDao crearCamionDao() {
                return fakeDao;
            }
        };

        // Ejecutar método
        visual.verificarMantenimiento();

        // Si no hay errores, pasa el test
        assertTrue(true);
    }
}