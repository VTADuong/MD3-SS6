import java.util.Scanner;

public class Ex6_1 {
    private static double[] grades = new double[100];
    private static int size = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    inputGrades();
                    break;
                case 2:
                    printGrades();
                    break;
                case 3:
                    calculateAverage();
                    break;
                case 4:
                    findMinMax();
                    break;
                case 5:
                    countPassFail();
                    break;
                case 6:
                    sortGradesAscending();
                    break;
                case 7:
                    countGoodAndExcellent();
                    break;
                case 8:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
            System.out.println();
        } while (choice != 8);

        sc.close();
    }

    public static void showMenu() {
        System.out.println("******************QUẢN LÝ ĐIỂM SV****************");
        System.out.println("1. Nhập danh sách điểm sinh viên");
        System.out.println("2. In danh sách điểm");
        System.out.println("3. Tính điểm trung bình của các sinh viên");
        System.out.println("4. Tìm điểm cao nhất và thấp nhất");
        System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
        System.out.println("6. Sắp xếp điểm tăng dần");
        System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
        System.out.println("8. Thoát");
        System.out.println("*************************************************");
    }

    public static void inputGrades() {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Số lượng sinh viên phải lớn hơn 0!");
            return;
        }

        size = n;
        System.out.println("Nhập điểm cho từng sinh viên (thang điểm 0 - 10):");
        for (int i = 0; i < size; i++) {
            do {
                System.out.print("Điểm của sinh viên thứ " + (i + 1) + ": ");
                grades[i] = sc.nextDouble();
                if (grades[i] < 0 || grades[i] > 10) {
                    System.out.println("Điểm không hợp lệ! Vui lòng nhập trong khoảng [0, 10].");
                }
            } while (grades[i] < 0 || grades[i] > 10);
        }
        System.out.println("-> Nhập danh sách điểm thành công!");
    }

    public static void printGrades() {
        if (size == 0) {
            System.out.println("Danh sách điểm hiện đang rỗng!");
            return;
        }
        System.out.print("Danh sách điểm sinh viên: ");
        for (int i = 0; i < size; i++) {
            System.out.print(grades[i] + " ");
        }
        System.out.println();
    }

    public static void calculateAverage() {
        if (size == 0) {
            System.out.println("Chưa có dữ liệu điểm để tính trung bình!");
            return;
        }
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += grades[i];
        }
        double avg = sum / size;
        System.out.printf("-> Điểm trung bình của các sinh viên là: %.2f\n", avg);
    }

    public static void findMinMax() {
        if (size == 0) {
            System.out.println("Chưa có dữ liệu điểm!");
            return;
        }
        double min = grades[0];
        double max = grades[0];

        for (int i = 1; i < size; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
            if (grades[i] < min) {
                min = grades[i];
            }
        }
        System.out.println("-> Điểm cao nhất: " + max);
        System.out.println("-> Điểm thấp nhất: " + min);
    }

    public static void countPassFail() {
        if (size == 0) {
            System.out.println("Chưa có dữ liệu điểm!");
            return;
        }
        int passCount = 0;
        int failCount = 0;

        for (int i = 0; i < size; i++) {
            if (grades[i] >= 5.0) {
                passCount++;
            } else {
                failCount++;
            }
        }
        System.out.println("-> Số lượng sinh viên ĐẠT (điểm >= 5): " + passCount);
        System.out.println("-> Số lượng sinh viên TRƯỢT (điểm < 5): " + failCount);
    }

    public static void sortGradesAscending() {
        if (size == 0) {
            System.out.println("Chưa có dữ liệu điểm để sắp xếp!");
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < size; j++) {
                if (grades[j] < grades[minIdx]) {
                    minIdx = j;
                }
            }
            double temp = grades[minIdx];
            grades[minIdx] = grades[i];
            grades[i] = temp;
        }
        System.out.println("-> Đã sắp xếp danh sách điểm tăng dần.");
        printGrades();
    }
    public static void countGoodAndExcellent() {
        if (size == 0) {
            System.out.println("Chưa có dữ liệu điểm!");
            return;
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (grades[i] >= 8.0) {
                count++;
            }
        }
        System.out.println("-> Số lượng sinh viên GIỎI & XUẤT SẮC (điểm >= 8): " + count);
    }
}

