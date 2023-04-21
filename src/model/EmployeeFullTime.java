package model;

public class EmployeeFullTime extends model.Employee implements Comparable<EmployeeFullTime>{
    private double bonus; // thưởng
    private double fine; // phạt
    private double salary; // lương

    public EmployeeFullTime(String employeeCode, String name, int age, String phone, String email, double bonus, double fine, double salary) {
        super(employeeCode, name, age, phone, email);
        this.bonus = bonus;
        this.fine = fine;
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double salaryFullTime() {
        return getSalary() + getBonus() - getFine();
    }

    @Override
    public String toString() {
        return "Nhân viên Fulltime: [ " +
                "Mã nhân viên: " + getEmployeeCode() +
                ", Tên: " + getName() +
                ", Tuổi: " + getAge() +
                ", Điện thoại: " + getPhone() +
                ", Email: " + getEmail() +
                ", Thưởng: " + bonus +
                ", Phạt: " + fine +
                ", Lương cứng: " + salary +
                ']' + "\n";
    }   

    @Override
    public int compareTo(EmployeeFullTime o) {
        return (int) (getSalary()-o.getSalary());
    }
}
