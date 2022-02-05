package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Credential {
    public String email, user_type;
    File file;
    FileWriter fw;
    Scanner sc;
    ArrayList<String> data;
    
    public Credential() throws IOException{
        //accessing file
        file = new File("credential.txt");
        fw = new FileWriter("credential.txt");
    }
    
    //save login data to local file        
    public Boolean checkInfo(String l_email, String l_user_mode) throws FileNotFoundException{
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
            
            if(l_email.equals(email) && l_user_mode == user_type){
                return true;
            }else{
                return false;
            }
        }else{
            System.out.println("File doesnt exist!");
            return false;
        }
    }
    
    public void saveInfo(String email, String user_type) throws IOException{
      //write the login data to local file
      fw.write(email);
      fw.write(user_type);
      
      //close the file
      fw.close();      
    }
    
    //update info when user update 
    public void updateInfo(String email) throws IOException{
      String utype = this.user_type;
      
      // delete the existing file
      file.delete();
      
      //again create new file
      FileWriter fw = new FileWriter("credential.txt");
       
      //write the login data to local file
      fw.write(email);
      fw.write(utype);
      
      //close the file
      fw.close();     
    }
    
    //return the current login user type
    public String getUserType(){
        return this.user_type;
    }
    
}
