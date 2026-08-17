import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex6_2 {
    private static String fullName = "";
    private static String email = "";
    private static String phone = "";
    private static String password = "";

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    inputUserInfo();
                    break;
                case 2:
                    normalizeFullName();
                    break;
                case 3:
                    checkEmail();
                    break;
                case 4:
                    checkPhone();
                    break;
                case 5:
                    checkPassword();
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

    public static void showMenu() {
        System.out.println("******************QUẢN LÝ NGƯỜI DÙNG****************");
        System.out.println("1. Nhập thông tin người dùng");
        System.out.println("2. Chuẩn hóa họ tên");
        System.out.println("3. Kiểm tra email hợp lệ");
        System.out.println("4. Kiểm tra số điện thoại hợp lệ");
        System.out.println("5. Kiểm tra mật khẩu hợp lệ");
        System.out.println("6. Thoát");
        System.out.println("****************************************************");
    }

    public static void inputUserInfo() {
        System.out.println("--- NHẬP THÔNG TIN NGƯỜI DÙNG ---");
        System.out.print("Nhập họ và tên: ");
        fullName = sc.nextLine();
        System.out.print("Nhập email: ");
        email = sc.nextLine().trim();
        System.out.print("Nhập số điện thoại: ");
        phone = sc.nextLine().trim();
        System.out.print("Nhập mật khẩu: ");
        password = sc.nextLine();
        System.out.println("-> Đã nhập xong thông tin người dùng!");
    }

    public static void normalizeFullName() {
        if (fullName.isEmpty()) {
            System.out.println("Chưa có thông tin họ tên. Vui lòng nhập ở mục 1!");
            return;
        }

        String cleaned = fullName.trim().replaceAll("\\s+", " ");
        if (cleaned.isEmpty()) {
            System.out.println("Họ tên không hợp lệ!");
            return;
        }

        String[] words = cleaned.split(" ");
        StringBuilder normalized = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                normalized.append(capitalizedWord).append(" ");
            }
        }

        fullName = normalized.toString().trim();
        System.out.println("-> Họ tên sau khi chuẩn hóa: " + fullName);
    }

    public static void checkEmail() {
        if (email.isEmpty()) {
            System.out.println("Chưa nhập thông tin Email!");
            return;
        }
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

        if (email.matches(emailRegex)) {
            System.out.println("-> Email (" + email + ") HỢP LỆ.");
        } else {
            System.out.println("-> Email (" + email + ") KHÔNG HỢP LỆ!");
        }
    }

    public static void checkPhone() {
        if (phone.isEmpty()) {
            System.out.println("Chưa nhập số điện thoại!");
            return;
        }
        String phoneRegex = "^(0|\\+84)(3|5|7|8|9)[0-9]{8}$";

        if (phone.matches(phoneRegex)) {
            System.out.println("-> Số điện thoại (" + phone + ") HỢP LỆ.");
        } else {
            System.out.println("-> Số điện thoại (" + phone + ") KHÔNG HỢP LỆ!");
            System.out.println("   (Số hợp lệ phải gồm 10 chữ số và bắt đầu bằng các đầu số di động VN: 03, 05, 07, 08, 09)");
        }
    }

    public static void checkPassword() {
        if (password.isEmpty()) {
            System.out.println("Chưa nhập mật khẩu!");
            return;
        }
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!._-]).{8,}$";

        if (password.matches(passwordRegex)) {
            System.out.println("-> Mật khẩu HỢP LỆ.");
        } else {
            System.out.println("-> Mật khẩu KHÔNG HỢP LỆ!");
            System.out.println("   (Yêu cầu: Tối thiểu 8 ký tự, gồm ít nhất 1 chữ hoa, 1 chữ thường, 1 số và 1 ký tự đặc biệt)");
        }
    }
}
