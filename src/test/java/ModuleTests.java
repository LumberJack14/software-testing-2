import math.BaseFunctions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ModuleTests {
    private static final double DELTA = 0.001;
    private BaseFunctions baseF = new BaseFunctions();

    @DisplayName("SIN FUNCTION MODULE TESTS")
    @ParameterizedTest(name = "Test {index}: x = {0}, y = {1}")
    @CsvFileSource(resources = "testcoverSIN.csv", delimiter = ';')
    void testSinFunction(double input, double output) {
        assertEquals(output, baseF.sin(input), DELTA);
    }

    @DisplayName("COS FUNCTION MODULE TESTS")
    @ParameterizedTest(name = "Test {index}: x = {0}, y = {1}")
    @CsvFileSource(resources = "testcoverCOS.csv", delimiter = ';')
    void testCosFunction(double input, double output) {
        assertEquals(output, baseF.cos(input), DELTA);
    }

    @DisplayName("SEC FUNCTION MODULE TESTS")
    @ParameterizedTest(name = "Test {index}: x = {0}, y = {1}")
    @CsvFileSource(resources = "testcoverSEC.csv", delimiter = ';')
    void testSecFunction(double input, double output, boolean shouldThrow) {
        if (shouldThrow) {
            assertThrows(IllegalArgumentException.class, () -> baseF.sec(input));
        } else {
            assertEquals(output, baseF.sec(input), DELTA);
        }
    }

    @DisplayName("CSC FUNCTION MODULE TESTS")
    @ParameterizedTest(name = "Test {index}: x = {0}, y = {1}")
    @CsvFileSource(resources = "testcoverCSC.csv", delimiter = ';')
    void testScsFunction(double input, double output, boolean shouldThrow) {
        if (shouldThrow) {
            assertThrows(IllegalArgumentException.class, () -> baseF.csc(input));
        } else {
            assertEquals(output, baseF.csc(input), DELTA);
        }
    }

    @DisplayName("LN FUNCTION MODULE TESTS")
    @ParameterizedTest(name = "Test {index}: x = {0}, y = {1}")
    @CsvFileSource(resources = "testcoverLN.csv", delimiter = ';')
    void testLnFunction(double input, double output, boolean shouldThrow) {
        if (shouldThrow) {
            assertThrows(IllegalArgumentException.class, () -> baseF.ln(input));
        } else {
            assertEquals(output, baseF.ln(input), DELTA);
        }
    }
}
