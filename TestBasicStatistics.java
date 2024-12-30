import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class TestBasicStatistics {
    public static void main(String[] args) {
        /*
          - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
            là <TenSinhVien_MaSinhVien_BasicStatistics>.txt (Ví dụ, NguyenVanA_123456_BasicStatistics.txt).
          - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
            <TenSinhVien_MaSinhVien_BasicStatistics>.zip (Ví dụ, NguyenVanA_123456_BasicStatistics.zip),
            nộp lên classroom.
        */
        try (PrintWriter writer = new PrintWriter(new FileWriter("BuiMinhQuan_20002086_TestBasicStatistics.txt", StandardCharsets.UTF_8))) {
          testMyArrayList(writer);
          testMyLinkedList(writer);
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

  public static void testMyArrayList(PrintWriter writer) {
      /*
         - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
         - Tạo một danh sách kiểu MyArrayList có các phần tử dữ liệu kiểu Double, các giá trị của phần
           tử được sinh ngẫu nhiên nằm trong đoạn [1, 20].
         - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
           In ra terminal tập dữ liệu và các đại lượng thống kê.
       */
      Random rand = new Random();
      int length = rand.nextInt(21) + 30;

      MyArrayList list = new MyArrayList();
      for (int i = 0; i < length; i++) {
          double value = rand.nextDouble() * 19 + 1;
          list.append(value);
      }

      BasicStatistic statistic = new BasicStatistic(list);

      // In kết quả ra terminal
      System.out.println("Tập dữ liệu: " + list.toString());
      System.out.println("Max: " + statistic.max());
      System.out.println("Min: " + statistic.min());
      System.out.println("Mean: " + statistic.mean());
      System.out.println("Variance: " + statistic.variance());
      System.out.println();

      // Ghi kết quả vào file
      writer.println("Tập dữ liệu: " + list.toString());
      writer.println("Max: " + statistic.max());
      writer.println("Min: " + statistic.min());
      writer.println("Mean: " + statistic.mean());
      writer.println("Variance: " + statistic.variance());
      writer.println();
  }

  public static void testMyLinkedList(PrintWriter writer) {
      /*
         - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
         - Tạo ra một danh sách kiểu MyLinkedList có các phần tử dữ liệu kiểu Double, các giá trị của phần
           tử được sinh ngẫu nhiên nằm trong đoạn [1, 20].
         - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
           In ra terminal tập dữ liệu và các đại lượng thống kê.
       */
      Random rand = new Random();
      int length = rand.nextInt(21) + 30;

      MyLinkedList list = new MyLinkedList();
      for (int i = 0; i < length; i++) {
          double value = rand.nextDouble() * 19 + 1;
          list.append(value);
      }

      BasicStatistic statistic = new BasicStatistic(list);

      System.out.println("Tập dữ liệu: " + list.toString());
      System.out.println("Max: " + statistic.max());
      System.out.println("Min: " + statistic.min());
      System.out.println("Mean: " + statistic.mean());
      System.out.println("Variance: " + statistic.variance());
      System.out.println();

      writer.println("Tập dữ liệu: " + list.toString());
      writer.println("Max: " + statistic.max());
      writer.println("Min: " + statistic.min());
      writer.println("Mean: " + statistic.mean());
      writer.println("Variance: " + statistic.variance());
      writer.println();
  }
}