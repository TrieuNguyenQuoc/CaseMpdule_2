package model;

import java.io.Serializable;

public class Employee implements Serializable {
    private String Code;
    private String Name;
    private int Age;
    private String Prevention;
    private String RentedRoom;
    public Employee(String employeeCode, String name, int age, String phone, String email) {
        this.Code = employeeCode;
        this.Name = name;
        this.Age = age;
        this.Prevention = phone;
        this.RentedRoom = email;
    }

    public String getEmployeeCode() {
        return Code;
    }

    public void setEmployeeCode(String employeeCode) {
        this.Code = employeeCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public String getPhone() {
        return Prevention;
    }

    public void setPhone(String phone) {
        this.Prevention = phone;
    }

    public String getEmail() {
        return RentedRoom;
    }

    public void setEmail(String email) {
        this.RentedRoom = email;
    }

}
