import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {
    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // --- Test cho hàm countExcellentStudents ---

    @Test
    public void testCountExcellentStudents_NormalCase() {
        // Danh sách có điểm giỏi, điểm thường và điểm không hợp lệ
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0, 5.0);
        // Kỳ vọng: 9.0 và 8.5 là giỏi. 11.0 và -1.0 bị bỏ qua. 7.0 và 5.0 không giỏi. -> Tổng 2
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_AllExcellent() {
        List<Double> scores = Arrays.asList(8.0, 9.5, 10.0);
        assertEquals(3, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_Boundary() {
        // Kiểm tra cận 8.0 (giỏi) và cận 7.9 (không giỏi)
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(8.0)));
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(7.99)));
    }

    @Test
    public void testCountExcellentStudents_EmptyAndNull() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

    // --- Test cho hàm calculateValidAverage ---

    @Test
    public void testCalculateValidAverage_NormalCase() {
        // Hợp lệ: 9.0, 8.5, 7.0. Không hợp lệ: 11.0, -1.0
        // Tổng: 24.5 / 3 = 8.1666...
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(8.17, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_AllInvalid() {
        // Không có điểm nào hợp lệ -> Trả về 0
        List<Double> scores = Arrays.asList(-5.0, 15.0, 100.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    public void testCalculateValidAverage_Boundary0And10() {
        // 0 và 10 vẫn là điểm hợp lệ
        List<Double> scores = Arrays.asList(0.0, 10.0);
        // (0 + 10) / 2 = 5.0
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    public void testCalculateValidAverage_Empty() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.001);
    }
}