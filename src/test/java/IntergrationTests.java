import math.BaseFunctions;
import math.TargetSystem;
import math.TestFunctions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class IntergrationTests {
    private static final double DELTA = 0.001;
    @Mock
    private BaseFunctions baseF;

    @InjectMocks
    private BaseFunctions baseFreal = new BaseFunctions();
    @InjectMocks
    private TestFunctions testF = new TestFunctions();

    @InjectMocks
    private TargetSystem systemF;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("SYSTEM SIN INTERGRATION")
    @ParameterizedTest(name = "Test {index}: x = {0}, y = {1}")
    @CsvFileSource(resources = "testcoverMAIN.csv", delimiter = ';')
    void testSinIntegration(double input, double output, boolean shouldThrow) {
        when(baseF.cos(input)).thenReturn(testF.cos(input));
        when(baseF.sec(input)).thenReturn(testF.sec(input));
        when(baseF.csc(input)).thenReturn(testF.csc(input));
        if (shouldThrow) {
            assertThrows(IllegalArgumentException.class, () -> systemF.calculate(input));
        } else {
            assertEquals(output, systemF.calculate(input), DELTA);
        }
    }

    @DisplayName("SYSTEM COS INTERGRATION")
    @ParameterizedTest(name = "Test {index}: x = {0}, y = {1}")
    @CsvFileSource(resources = "testcoverMAIN.csv", delimiter = ';')
    void testCosIntegration(double input, double output, boolean shouldThrow) {
        when(baseF.sin(input)).thenReturn(testF.sin(input));
        when(baseF.sec(input)).thenReturn(testF.sec(input));
        when(baseF.csc(input)).thenReturn(testF.csc(input));
        if (shouldThrow) {
            assertThrows(IllegalArgumentException.class, () -> systemF.calculate(input));
        } else {
            assertEquals(output, systemF.calculate(input), DELTA);
        }
    }

    @DisplayName("SYSTEM SEC INTERGRATION")
    @ParameterizedTest(name = "Test {index}: x = {0}, y = {1}")
    @CsvFileSource(resources = "testcoverMAIN.csv", delimiter = ';')
    void testSecIntegration(double input, double output, boolean shouldThrow) {
        when(baseF.sin(input)).thenReturn(testF.sin(input));
        when(baseF.cos(input)).thenReturn(testF.cos(input));
        when(baseF.csc(input)).thenReturn(testF.csc(input));
        if (shouldThrow) {
            assertThrows(IllegalArgumentException.class, () -> systemF.calculate(input));
        } else {
            assertEquals(output, systemF.calculate(input), DELTA);
        }
    }

    @DisplayName("SYSTEM SCS INTERGRATION")
    @ParameterizedTest(name = "Test {index}: x = {0}, y = {1}")
    @CsvFileSource(resources = "testcoverMAIN.csv", delimiter = ';')
    void testScsIntegration(double input, double output, boolean shouldThrow) {
        when(baseF.sin(input)).thenReturn(testF.sin(input));
        when(baseF.cos(input)).thenReturn(testF.cos(input));
        when(baseF.sec(input)).thenReturn(testF.sec(input));
        if (shouldThrow) {
            assertThrows(IllegalArgumentException.class, () -> systemF.calculate(input));
        } else {
            assertEquals(output, systemF.calculate(input), DELTA);
        }
    }

    @DisplayName("SYSTEM LN INTERGRATION")
    @ParameterizedTest(name = "Test {index}: x = {0}, y = {1}")
    @CsvFileSource(resources = "testcoverMAIN.csv", delimiter = ';')
    void testLnIntegration(double input, double output, boolean shouldThrow) {
        when(baseF.sin(input)).thenReturn(testF.sin(input));
        when(baseF.cos(input)).thenReturn(testF.cos(input));
        when(baseF.sec(input)).thenReturn(testF.sec(input));
        when(baseF.csc(input)).thenReturn(testF.csc(input));
        if (shouldThrow) {
            assertThrows(IllegalArgumentException.class, () -> systemF.calculate(input));
        } else {
            assertEquals(output, systemF.calculate(input), DELTA);
        }
    }

    @DisplayName("SYSTEM LOG INTERGRATION")
    @ParameterizedTest(name = "Test {index}: log{1}({0}) = {2}")
    @CsvFileSource(resources = "testcoverLOG.csv", delimiter = ';')
    void testLogIntegration(double input, double base, double output) {
        assertEquals(output, baseFreal.log(base, input), DELTA);
    }
}
