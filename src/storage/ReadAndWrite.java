package storage;

import model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void writeToFile(List<Employee> students) {
        try {
            FileOutputStream fos = new FileOutputStream("Case_2.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readDataFromFile(){
        List<Employee> employees = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream("Case_2.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            employees = (List<Employee>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return employees;
    }
}
