### Kết quả thực hành trải nghiệm chất lượng giao diện phần mềm với https://cantunsee.space/ tuần 1

![Kết quả Can't Unsee](Resource/images/ketqua_cantunsee_1.png)


# Bài tập: Phân tích dữ liệu điểm số học sinh

## 1. Mô tả bài toán
Chương trình cung cấp lớp `StudentAnalyzer` để xử lý danh sách điểm số (từ 0.0 đến 10.0) với hai chức năng chính:
* **Đếm học sinh giỏi:** Đếm số lượng học sinh có điểm >= 8.0. Các giá trị điểm âm hoặc lớn hơn 10.0 sẽ bị loại bỏ (validate).
* **Tính điểm trung bình:** Tính trung bình cộng của các điểm số hợp lệ trong danh sách. Nếu danh sách rỗng hoặc không có điểm hợp lệ, trả về 0.

## 2. Cấu trúc thư mục
Dự án được tổ chức theo cấu trúc chuẩn:
* `src/`: Chứa mã nguồn xử lý logic (`StudentAnalyzer.java`).
* `test/`: Chứa các kịch bản kiểm thử đơn vị (`StudentAnalyzerTest.java`).
* `lib/`: Thư viện JUnit 5 dùng cho kiểm thử.

## 3. Hướng dẫn chạy chương trình và Kiểm thử (Test)

### Yêu cầu hệ thống:
* Java JDK 8 trở lên (Khuyến khích JDK 17 hoặc 21).
* IntelliJ IDEA hoặc bất kỳ IDE nào hỗ trợ Java.

### Các bước thực hiện:
1. **Mở dự án:** Mở thư mục `unit-test` bằng IntelliJ IDEA.
2. **Cấu hình thư viện:** Đảm bảo thư viện JUnit 5 đã được thêm vào Classpath.
3. **Chạy Kiểm thử:**
    * Tìm file `StudentAnalyzerTest.java` trong thư mục `test/`.
    * Chuột phải vào file hoặc class và chọn **Run 'StudentAnalyzerTest'**.
    * Kết quả sẽ hiển thị ở cửa sổ **Run** bên dưới. Nếu hiện thanh màu xanh lá cây (Passed), nghĩa là tất cả các ca kiểm thử đều thành công.

## 4. Các trường hợp kiểm thử (Test Cases)
Chương trình đã vượt qua 8 ca kiểm thử bao gồm:
* **Trường hợp bình thường:** Danh sách có cả điểm hợp lệ và không hợp lệ.
* **Trường hợp biên:** Điểm chính xác 0.0, 8.0 và 10.0.
* **Trường hợp ngoại lệ:** Danh sách rỗng (`emptyList`), danh sách chứa `null` hoặc toàn bộ điểm không hợp lệ (điểm âm, điểm > 10).
