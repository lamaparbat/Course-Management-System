package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Credential {

    private String email, user_type;
    private File file;
    private Scanner sc;
    private ArrayList<String> data;

    public Credential() throws FileNotFoundException {
        //accessing file
        file = new File("credential.txt");

        //list to store file data
        data = new ArrayList<>();

        //check if file exist or not
        if (file.exists()) {
            if (this.isEmpty() != true) {
                //reading file
                sc = new Scanner(file);

                //iterating each line
                while (sc.hasNextLine()) {
                    data.add(sc.nextLine());
                }

                //initializing file value to global variable
                email = data.get(0);
                user_type = data.get(1);
            }
        } else {
            System.out.println("File doesnt exist!");
        }
    }

    //return user email
    public String getEmail() {
        return this.email;
    }

    //return user mode
    public String getMode() {
        return this.user_type;
    }

    // return is there any data
    public boolean isEmpty() {
        if (file.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    //store user data
    public void storeData(String email, String mode) throws IOException{
        FileWriter fw = new FileWriter("Credential.txt");
        fw.write(email);
        fw.write(mode);
    }
    
    //update the file data
    public void updateInfo(String email) throws IOException{
        String mode = this.user_type;
        
        //delete the file
        if(file.delete()){
            FileWriter fw = new FileWriter("Credential.txt");
            fw.write(mode);
            fw.write(email);
            fw.close();
        }
    }
}
