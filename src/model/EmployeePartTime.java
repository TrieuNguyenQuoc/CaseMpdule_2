package model;

public class EmployeePartTime extends model.Employee {
    private int workingHours;

    public EmployeePartTime(String employeeCode, String name, int age, String phone, String email, int workingHours) {
        super(employeeCode, name, age, phone, email);
        this.workingHours = workingHours;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public double salaryPartTime() {
        return getWorkingHours()*10;
    }

    @Override
    public String toString() {
        return "Nhân viên Parttime: [ " +
                ", Mã nhân viên: " + getEmployeeCode() +
                ", Tên: " + getName() +
                ", Tuổi: " + getAge() +
                ", Điện thoại: " + getPhone() +
                ", Email: " + getEmail() +
                ", Số giờ làm: " + workingHours +
                ']' + "\n";
    }
}
