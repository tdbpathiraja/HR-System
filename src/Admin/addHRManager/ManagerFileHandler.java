package Admin.addHRManager;

import java.io.*;
import javax.swing.JOptionPane;

public class ManagerFileHandler {
    private static final String FILE_PATH = "Database\\Login Details\\HR Managers\\hr_manager_details.txt";

    public static boolean isUsernameExists(String usernameToCheck) {
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(": ");
            if (parts.length >= 2 && parts[0].trim().equals("Username") && parts[1].trim().equals(usernameToCheck)) {
                return true;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false; 
}

public static void saveManagerDetails(HRManager manager) {
    String hrManagerName = manager.getName();
    String username = manager.getUsername();
    String password = manager.getPassword();

    if (isUsernameExists(username)) {
        JOptionPane.showMessageDialog(null, "Username already exists! Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write("HR Manager Name: " + hrManagerName + "\n");
            writer.write("Username: " + username + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("------------\n");
            JOptionPane.showMessageDialog(null, "Details saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

}
