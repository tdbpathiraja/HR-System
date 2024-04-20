package HR_Manager;

import java.io.*;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Employee_Data {

    public static void writeToFile(String filePath, String data, boolean append) {
    boolean fileExists = new File(filePath).exists();
    try (FileWriter fw = new FileWriter(filePath, append);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter out = new PrintWriter(bw)) {
        if (!fileExists || (!append && new File(filePath).length() == 0)) {
            
            out.println("Employee ID,EPF Number,Full Name,Home Address,Birth Date,NIC Number,Telephone Number,Gender,Department,Designation");
        }
        out.println(data);
    } catch (IOException e) {
        
        System.err.println("Error writing to file: " + e.getMessage());
    }
}


    public static String[] readLinesFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines().toArray(String[]::new);
        } catch (IOException e) {
            
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return new String[0];
    }

    
    public static String formatEmployeeData(
            String employeeid, String epfno, String fullName, String homeAddress,
            String birthDate, String nicNumber, String telephoneNumber,
            String gender, String selectedDepartment, String selectedDesignation) {
        
        return String.join(",", employeeid, epfno, fullName, homeAddress, birthDate,
                nicNumber, telephoneNumber, gender, selectedDepartment, selectedDesignation);
    }

    public static void resetFields(
            JTextField employeeIdField, JTextField epfNumberField, JTextField fullNameField,
            JTextArea homeAddressField, JTextField birthDateField, JTextField nicNumberField,
            JTextField telephoneNumberField, JComboBox<String> genderSelectionField,
            JComboBox<String> departmentListField, JComboBox<String> designationListField) {

        employeeIdField.setText("");
        epfNumberField.setText("");
        fullNameField.setText("");
        homeAddressField.setText("");
        birthDateField.setText("");
        nicNumberField.setText("");
        telephoneNumberField.setText("");
        genderSelectionField.setSelectedIndex(0);
        departmentListField.setSelectedIndex(0);
        designationListField.setSelectedIndex(0);
    }

    
    public static void saveEmployeeData(String filePath, String employeeData) {
        writeToFile(filePath, employeeData, true); 
    }

}

