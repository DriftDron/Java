import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

public class CashMachineTest {

    @Test
    public void testDuplicatedNominals() {
        InputStream is = new ByteArrayInputStream("4 3 1 1 1".getBytes());
        Assertions.assertThrows(RuntimeException.class, () -> new CashMachine(is));
    }

    @Test
    public void testExceptionSumLowerThanNominals() {
        Long[] noms = {6L};
        CashMachine machine = new CashMachine(5L, 1, noms);
        Assertions.assertThrows(RuntimeException.class, machine::getCombinations);
    }

    @Test
    public void testExceptionNegativeInput() {
        InputStream is = new ByteArrayInputStream("-2 1 5".getBytes());
        Assertions.assertThrows(RuntimeException.class, () -> new CashMachine(is));
    }

    @Test
    public void testExceptionInputIsString() {
        InputStream is = new ByteArrayInputStream("sss 2 1 2".getBytes());
        Assertions.assertThrows(InputMismatchException.class, () -> new CashMachine(is));
    }


}