package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Credential {
    public String email, user_type;
    File file;
    Scanner sc;
    ArrayList<String> data;
    
    public Credential() throws FileNotFoundException{
        //accessing file
        file = new File("credential.txt");
        
        //list to store file data
        data = new ArrayList<>();
        
        //check if file exist or not
        if(file.exists()){
            //reading file
            sc = new Scanner(file);
            
            //iterating each line
            while(sc.hasNextLine()){
                data.add(sc.nextLine());
            }
            
            //initializing file value to global variable
            email = data.get(0);
            user_type = data.get(1);
        }else{
            System.out.println("File doesnt exist!");
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        new Credential();
    }
}
