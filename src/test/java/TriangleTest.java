import org.example.Triangle;
import org.example.SquareException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class TriangleTest {

    @Test
    void test() throws SquareException {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(6,triangle.square(3,4, 5));
        Assertions.assertThrows(SquareException.class,()-> triangle.square(-3,4, 5));
    }

    @ParameterizedTest
    @CsvSource({"0,4,5,6","3,0,5,7","3,4,0,7"})
    void testCsvZero(int a, int b, int c, int result) throws SquareException {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(result, triangle.square(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({"-3,4,5","3,-4,5","3,4,-5"})
    void testCsvMinus(int a, int b, int c) throws SquareException {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(6, triangle.square(a, b, c));
    }
    @ParameterizedTest
    @CsvSource({"100,4,5","3,100,5","3,4,100"})
    void testCsvNoTriangle(int a, int b, int c) throws SquareException {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(6, triangle.square(a, b, c));
    }

    }
