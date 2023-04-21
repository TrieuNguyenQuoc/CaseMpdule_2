package views;

import model.Manager;
import model.Employee;
import model.EmployeeFullTime;
import model.EmployeePartTime;
import storage.ReadAndWrite;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static List<Employee> employees;

    static {
        try {
            employees = ReadAndWrite.readDataFromFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Manager manager = new Manager(employees);
    public static ReadAndWrite demo = new ReadAndWrite();
    public static Scanner input = new Scanner(System.in);
    public static int checkInput;


    public static void main(String[] args) {
        do {
            System.out.println("");
            System.out.println("""
                    +_________________________________________________________________+
                    ¦ ~~1. Thêm nhân viên vào danh sách                               ¦      
                    ¦ ~~2. Hiển thị danh sách nhân viên                               ¦ 
                    ¦ ~~3. Sửa dữ liệu nhân viên                                      ¦ 
                    ¦ ~~4. Xóa nhân viên trong danh sách                              ¦ 
                    ¦ ~~5. Hiển thị trung bình lương tất cả nhân viên công ty         ¦ 
                    ¦ ~~6. Danh sách nhân viên cứng lương thấp hơn trung bình         ¦
                    ¦ ~~7. Số tiền phải trả cho nhân viên thực tập là                 ¦         
                    ¦ ~~8. Bảng lương nhân viên thực tập theo thứ tự từ thấp đến cao  ¦
                    ¦ ~~0. Thoát khỏi chương trình                                    ¦         
                    +_________________________________________________________________+
                    """);
            checkInput = Integer.parseInt(input.nextLine());
            switch (checkInput) {
                case 1 -> {
                    manager.addEmployee(addNewEmployee());
                    demo.writeToFile(employees);
                }
                case 2 -> {
                    List<Employee> list = demo.readDataFromFile();
                    for (Employee demo2 : list) {
                        System.out.println(demo2);
                    }
                }
                case 3 -> manager.editEmployee(editEmployee());
                case 4 -> manager.removeEmployee();
                case 5 -> System.out.println("Trung bình lương tất cả nhân viên công ty là : " +
                        manager.averageSalary());
                case 6 -> System.out.println("Danh sách nhân viên Fulltime lương thấp hơn trung bình: " +
                        manager.checkSalaryFullTime());
                case 7 -> System.out.println("Số tiền phải trả cho nhân viên parttime là: " +
                        manager.totalSalaryPartTime());
                case 8 -> System.out.println("Xếp lương nhân viên fulltime theo thứ tự từ thấp đến cao: " +
                        manager.sortSalary());
                case 0 -> System.out.println("Hẹn gặp lại sau.");
                default -> System.out.println("Vui lòng nhập lại!");
            }
        } while (checkInput != 0);
    }

    public static Employee addNewEmployee() {
        System.out.println("""
                ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦
                ¦   Bạn muốn thêm nhân viên nào ¦
                ¦1. Nhân viên cứng              ¦
                ¦2. Nhân viên thực tập          ¦ 
                ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦               
                """);
        checkInput = Integer.parseInt(input.nextLine());
        switch (checkInput) {
            case 1 -> {
                System.out.print("Nhập vào mã nhân viên: ");
                String employeeCode = input.nextLine();
                System.out.print("Nhập vào tên nhân viên: ");
                String name = input.nextLine();
                System.out.print("Nhập vào tuổi: ");
                int age = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào sđt: ");
                String phone = input.nextLine();
                System.out.print("Nhập vào email: ");
                String email = input.nextLine();
                System.out.print("Nhập vào tiền thưởng: ");
                double bonus = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào tiền phạt: ");
                double fine = Integer.parseInt(input.nextLine());
                double salary = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào lương cơ bản: ");
                return new EmployeeFullTime(employeeCode, name, age, phone, email, bonus, fine, salary);
            }
//            String passprot;
//            boolean isPassport = false;
//            while (!isPassport){
//                System.out.print("Nhập số hộ chiếu/cmnd khách hàng: ");
//                passprot = new Scanner(System.in).nextLine();
//                if (passprot.matches(passprot)){
//                    isPassport = true;
//                } else {
//                    System.out.println("Passport chỉ chứa số và không được nhiều hơn 12 ký tự");
//                }
//            }
            case 2 -> {
                System.out.print("~ Nhập vào mã nhân viên:");
                String employeeCode = input.nextLine();
                System.out.print("~ Nhập vào tên nhân viên:");
                String name = input.nextLine();
                System.out.print(" Nhập vào tuổi:");
                int age = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào sđt:");
                String phone = input.nextLine();
                System.out.print("Nhập vào email:");
                String email = input.nextLine();
                System.out.print("Nhập số giờ làm việc:");
                int workingHours = Integer.parseInt(input.nextLine());
                return new EmployeePartTime(employeeCode, name, age, phone, email, workingHours);
            }
            default -> System.out.println("Xin nhập lại, 1 hoặc 2");
        }
        return null;
    }

    public static Employee editEmployee() {
        System.out.println("""
                          ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦
                          ¦    Bạn muốn sửa thành phần nào:  ¦
                          ¦ 1. nhân viên cứng                ¦
                          ¦ 2. nhân viên thực tập            ¦
                          ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦
                          """);
        checkInput = Integer.parseInt(input.nextLine());
        switch (checkInput) {
            case 1 -> {
                System.out.print("~ Nhập vào mã nhân viên mới:");
                String newEmployeeCode = input.nextLine();
                System.out.print("~ Nhập vào tên nhân viên mới:");
                String newName = input.nextLine();
                System.out.print("~ Nhập vào tuổi:");
                int newAge = Integer.parseInt(input.nextLine());
                System.out.print("~ Nhập vào sđt mới:");
                String newPhone = input.nextLine();
                System.out.print("~ Nhập vào email mới:");
                String newEmail = input.nextLine();
                System.out.print("~ Nhập vào tiền thưởng mới:");
                double Newbonus = Integer.parseInt(input.nextLine());
                System.out.print("~ Nhập vào tiền phạt mới:");
                double Newfine = Integer.parseInt(input.nextLine());
                System.out.print("~ Nhập vào lương cơ bản của nhân viên mới:");
                double newSalary = Integer.parseInt(input.nextLine());
                return new EmployeeFullTime(newEmployeeCode, newName, newAge, newPhone, newEmail, Newbonus, Newfine, newSalary);
            }
            case 2 -> {
                System.out.print("~ Nhập vào mã nhân viên mới: ");
                String newEmployeeCode = input.nextLine();
                System.out.print("~ Nhập vào tên nhân viên mới: ");
                String newName = input.nextLine();
                System.out.print("~ Nhập vào tuổi: ");
                int newAge = Integer.parseInt(input.nextLine());
                System.out.print("~ Nhập vào sđt mới: ");
                String newPhone = input.nextLine();
                System.out.print("~ Nhập vào email mới: ");
                String newEmail = input.nextLine();
                System.out.print("~ Nhập số giờ làm việc mới:");
                int NewWorkingHours = Integer.parseInt(input.nextLine());
                return new EmployeePartTime(newEmployeeCode, newName, newAge, newPhone, newEmail, NewWorkingHours);
            }
            default -> System.out.println("~~Xin nhập lại, 1 hoặc 2~~");
        }
        return null;
    }
}
