package HR_Manager; //(inheri)

import java.util.ArrayList;
import java.util.List;



public class DepartmentJobHandler extends FileHandler {
    private final List<String> departments = new ArrayList<>();

    public List<String> getDepartments() {
        return departments;
    }

    public void addDepartment(String departmentName) {
        writeToFile(DEPARTMENT_FILE, departmentName);
        departments.add(departmentName);
    }

    public void addDesignation(String selectedDepartment, String designation) {
        String fileName = DEPARTMENT_DESIGNATIONS_FILE + selectedDepartment + ".txt";
        writeToFile(fileName, designation);
    }

    public void loadDepartmentsFromFile() {
        departments.addAll(readFromFile(DEPARTMENT_FILE));
    }
}
