import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex6_3 {
    private static String[] licensePlates = new String[100];
    private static int size = 0;
    private static Scanner sc = new Scanner(System.in);
    private static final String PLATE_REGEX = "^\\d{2}[A-Z]-\\d{3}\\.\\d{2}$";

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addLicensePlates();
                    break;
                case 2:
                    displayLicensePlates();
                    break;
                case 3:
                    searchExactPlate();
                    break;
                case 4:
                    searchByProvinceCode();
                    break;
                case 5:
                    sortPlatesAscending();
                    break;
                case 6:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
            System.out.println();
        } while (choice != 6);

        sc.close();
    }

    // Hiển thị Menu
    public static void showMenu() {
        System.out.println("******************QUẢN LÝ BIỂN SỐ XE****************");
        System.out.println("1. Thêm các biển số xe");
        System.out.println("2. Hiển thị danh sách biển số xe");
        System.out.println("3. Tìm kiếm biển số xe");
        System.out.println("4. Tìm biển số xe theo mã tỉnh");
        System.out.println("5. Sắp xếp biển số xe tăng dần");
        System.out.println("6. Thoát");
        System.out.println("****************************************************");
    }

    public static void addLicensePlates() {
        System.out.print("Nhập số lượng biển số xe muốn thêm: ");
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (size >= licensePlates.length) {
                System.out.println("Mảng đã đầy, không thể thêm tiếp!");
                break;
            }

            String plate;
            while (true) {
                System.out.print("Nhập biển số xe thứ " + (i + 1) + " (VD: 30F-123.45): ");
                plate = sc.nextLine().trim().toUpperCase();

                if (Pattern.matches(PLATE_REGEX, plate)) {
                    licensePlates[size] = plate;
                    size++;
                    break;
                } else {
                    System.out.println("-> Biển số không đúng định dạng (VD chuẩn: 30F-123.45). Vui lòng nhập lại!");
                }
            }
        }
        System.out.println("-> Thêm biển số xe thành công!");
    }

    public static void displayLicensePlates() {
        if (size == 0) {
            System.out.println("Danh sách biển số xe hiện đang rỗng!");
            return;
        }

        StringBuilder sb = new StringBuilder("--- DANH SÁCH BIỂN SỐ XE ---\n");
        for (int i = 0; i < size; i++) {
            sb.append((i + 1)).append(". ").append(licensePlates[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void searchExactPlate() {
        if (size == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        System.out.print("Nhập biển số xe cần tìm kiếm: ");
        String target = sc.nextLine().trim().toUpperCase();

        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (licensePlates[i].equalsIgnoreCase(target)) {
                System.out.println("-> Tìm thấy biển số xe " + target + " tại vị trí chỉ số [" + i + "]");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("-> Không tìm thấy biển số xe " + target + " trong danh sách!");
        }
    }

    public static void searchByProvinceCode() {
        if (size == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        System.out.print("Nhập mã tỉnh cần tìm (VD: 29, 30, 51...): ");
        String provinceCode = sc.nextLine().trim();

        if (!provinceCode.matches("^\\d{2}$")) {
            System.out.println("Mã tỉnh phải gồm 2 chữ số!");
            return;
        }

        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (licensePlates[i].startsWith(provinceCode)) {
                count++;
                result.append("  + ").append(licensePlates[i]).append("\n");
            }
        }

        if (count > 0) {
            System.out.println("-> Tìm thấy " + count + " biển số thuộc mã tỉnh " + provinceCode + ":");
            System.out.print(result.toString());
        } else {
            System.out.println("-> Không có biển số xe nào thuộc mã tỉnh " + provinceCode);
        }
    }

    public static void sortPlatesAscending() {
        if (size == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < size; j++) {
                // Sử dụng compareTo để so sánh chuỗi theo thứ tự từ điển
                if (licensePlates[j].compareTo(licensePlates[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            String temp = licensePlates[minIdx];
            licensePlates[minIdx] = licensePlates[i];
            licensePlates[i] = temp;
        }

        System.out.println("-> Đã sắp xếp danh sách biển số xe tăng dần.");
        displayLicensePlates();
    }
}
