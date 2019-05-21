package cl.diinf.asignacionmemorias.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnumMapperTest {
    private EnumMapper enumMapper;

    @Before
    public void setUp() {
        enumMapper = new EnumMapper();
    }

    @After
    public void tearDown() {
        enumMapper = null;
    }

    @Test
    public void enumInIfTest() {
        String result = enumMapper.statusMapper(Status.LISTO);
        System.out.println(result);
        assertEquals("El alumno ha sido notificado de las correcciones", result);
    }
}
