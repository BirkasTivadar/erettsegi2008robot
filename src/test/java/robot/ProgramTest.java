package robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgramTest {

    @Test
    void fogyasztas() {
        Program program = new Program("EKK");

        assertEquals(7, program.getFogyasztas());
    }

    @Test
    void egyszerusito() {
        Program program = new Program("D");
        assertEquals("D", program.egyszerusito());

        program = new Program("DD");
        assertEquals("2D", program.egyszerusito());

        program = new Program("DDDKDD");
        assertEquals("3DK2D", program.egyszerusito());

        program = new Program("DDDKDDE");
        assertEquals("3DK2DE", program.egyszerusito());
    }

    @Test
    void visszaTranszformalo() {
        Program program = new Program("D");

        assertEquals("D", program.visszaTranszformalo("D"));
        assertEquals("DD", program.visszaTranszformalo("2D"));
        assertEquals("DDDKDD", program.visszaTranszformalo("3DK2D"));
        assertEquals("DDDKDDE", program.visszaTranszformalo("3DK2DE"));
    }
}