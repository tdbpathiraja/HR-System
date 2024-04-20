package Admin;

import javax.swing.JOptionPane;
import java.io.*;

public class HR_assistant_details {

   public static class HR_Assistant {
       private String hrAssistantName;
       private String username;
       private String password;

       public HR_Assistant(String hrAssistantName, String username, String password) {
           this.hrAssistantName = hrAssistantName;
           this.username = username;
           this.password = password;
       }

       public String getHrAssistantName() {
           return hrAssistantName;
       }

       public String getUsername() {
           return username;
       }

       public String getPassword() {
           return password;
       }
   }

   public void saveDetailsToFile(HR_Assistant hrAssistant, Add_HR_Assistant gui) {
       try (BufferedReader reader = new BufferedReader(new FileReader("Database\\Login Details\\HR Assistants\\hr_assistant_details.txt"))) {
           String line;
           boolean usernameExists = false;

           
           while ((line = reader.readLine()) != null) {
               if (line.contains("Username: " + hrAssistant.getUsername())) {
                   usernameExists = true;
                   break;
               }
           }

           if (usernameExists) {
               JOptionPane.showMessageDialog(gui, "Username already exists! Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE);
           } else {
               
               try (BufferedWriter writer = new BufferedWriter(new FileWriter("Database\\Login Details\\HR Assistants\\hr_assistant_details.txt", true))) {
                   writer.write("HR Assistant Name: " + hrAssistant.getHrAssistantName() + "\n");
                   writer.write("Username: " + hrAssistant.getUsername() + "\n");
                   writer.write("Password: " + hrAssistant.getPassword() + "\n");
                   writer.write("------------\n");
                   writer.flush();

                   JOptionPane.showMessageDialog(gui, "Details saved successfully!");
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
