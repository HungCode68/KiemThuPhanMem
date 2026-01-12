import java.util.List;

public class StudentAnalyzer {

    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     * @param scores danh sách điểm số từ 0 đến 10
     * @return số học sinh đạt loại Giỏi (>= 8.0)
     * - Bỏ qua điểm âm hoặc lớn hơn 10
     * - Nếu danh sách rỗng, trả về 0
     */
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Double score : scores) {
            // Kiểm tra điểm hợp lệ (0 <= score <= 10)
            if (score != null && score >= 0 && score <= 10) {
                // Kiểm tra điều kiện giỏi
                if (score >= 8.0) {
                    count++;
                }
            }
        }
        return count;
    }
}