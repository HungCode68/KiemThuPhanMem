import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {
    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    @Test
    public void testCountExcellentStudents() {
        // 1. Trường hợp bình thường (Nhiều điểm hợp lệ & không hợp lệ)
        assertEquals(2, analyzer.countExcellentStudents(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)));

        // 2. Trường hợp bình thường (Toàn bộ hợp lệ)
        assertEquals(3, analyzer.countExcellentStudents(Arrays.asList(8.0, 9.0, 10.0)));

        // 3. Trường hợp biên (Danh sách trống)
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));

        // 4. Trường hợp biên (Chỉ chứa 0 hoặc 10)
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(0.0, 10.0)));

        // 5. Trường hợp ngoại lệ (Có điểm < 0 hoặc > 10)
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(-5.0, 15.0, 7.0)));
    }

    @Test
    public void testCalculateValidAverage() {
        // 1. Trường hợp bình thường (Nhiều điểm hợp lệ & không hợp lệ)
        assertEquals(8.17, analyzer.calculateValidAverage(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)), 0.01);

        // 2. Trường hợp bình thường (Toàn bộ hợp lệ)
        assertEquals(7.0, analyzer.calculateValidAverage(Arrays.asList(6.0, 7.0, 8.0)), 0.01);

        // 3. Trường hợp biên (Danh sách trống)
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);

        // 4. Trường hợp biên (Chỉ chứa 0 hoặc 10)
        assertEquals(5.0, analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)), 0.01);

        // 5. Trường hợp ngoại lệ (Có điểm < 0 hoặc > 10)
        assertEquals(7.0, analyzer.calculateValidAverage(Arrays.asList(-2.0, 12.0, 7.0)), 0.01);
    }
}