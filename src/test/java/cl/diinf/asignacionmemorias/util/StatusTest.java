package cl.diinf.asignacionmemorias.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatusTest {
    @Test
    public void StatusOutsideClassTest() {
        Status status = Status.LISTO;
        System.out.println("Status enum is set a value: " + status);
        assertEquals(Status.valueOf("LISTO"), status);
    }
}
