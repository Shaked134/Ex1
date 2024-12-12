package assignments.Ex1;
import assignments.Ex1.Ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void number2IntTest() {
        assertTrue(Ex1.isNumber("ABCbG"), "return true for valid number and base");
        assertFalse(Ex1.isNumber("123b"), "return false for missing base part");
        assertFalse(Ex1.isNumber("123bX"), " return false for invalid base");
        assertFalse(Ex1.isNumber("123b1"), " return false for base less than 2");
        assertFalse(Ex1.isNumber(""), " num1 is in the wrong format! ");
    }

    @Test
    void maxIndexTest() {
        String[] arr1 = {"10", "1", "1011b2", "1010b2"};
        assertEquals(2, Ex1.maxIndex(arr1), "Max number over [10, 1, 1011b2, 1010b2] is: 10");
        String[] arr = {"20", "80", "64bG", "640bG"};
        assertEquals(3, Ex1.maxIndex(arr), "Max number over [20, 80, 64bG, 640bG] is: 640bG");
    }
}
