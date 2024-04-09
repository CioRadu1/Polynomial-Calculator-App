import org.junit.Test;
import org.example.Model.Polynom;
import static junit.framework.TestCase.assertEquals;

public class OperationsTest{
    @org.junit.jupiter.api.Test
    public void testPolynomConstructor() {
        Polynom polynom = new Polynom("8x^4+5x^3+4x^2+5");
        assertEquals("8x^4+5x^3+4x^2+5", polynom.toString());
    }

    @org.junit.jupiter.api.Test
    public void testAddPolynom() {
        Polynom polynom1 = new Polynom("2x^2+3x^1+4");
        Polynom polynom2 = new Polynom("x^1+4+2x^3");
        polynom1.addPolynom(polynom2.getPolynom());
        assertEquals("2x^3+2x^2+4x^1+8", polynom1.toString());
    }

    @org.junit.jupiter.api.Test
    public void testSubtractPolynom() {
            Polynom polynom1 = new Polynom("3x^5+3x^2+4");
            Polynom polynom2 = new Polynom("x^2-x^1+5");
            polynom1.substarctPolynom(polynom2.getPolynom());
            assertEquals("3x^5+2x^2+x^1-1", polynom1.toString());
    }

    @org.junit.jupiter.api.Test
    public void testMultiplyPolynom() {
        Polynom polynom1 = new Polynom("x^2+x^1+4");
        Polynom polynom2 = new Polynom("x^1-1");
        polynom1.multiplyPolynom(polynom2.getPolynom());
        assertEquals("x^3+3x^1-4", polynom1.toString());
    }

    @org.junit.jupiter.api.Test
    public void testDerivativeOfPolynom() {
        Polynom polynom1 = new Polynom("x^5+3x^4+4");
        polynom1.derivativeOfPolynom();
        assertEquals("5x^4+12x^3", polynom1.toString());
    }

    @org.junit.jupiter.api.Test
    public void testIntegrateThePolynom() {
        Polynom polynom = new Polynom("3x^4+12x^1+7");
        polynom.integrateThePolynom();
        assertEquals("0.6x^5+6x^2+7x^1", polynom.toString());
    }

    @org.junit.jupiter.api.Test
    public void testDivideThePolynom() {
        Polynom polynom = new Polynom("3x^4+12x^2");
        Polynom polynom2 = new Polynom("x^2");
        polynom.dividePolynomBy(polynom2.getPolynom());
        assertEquals("3x^2+12 rest 0", polynom.toString());
    }
}
