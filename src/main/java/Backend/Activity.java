
package Backend;

import java.util.ArrayList;

public interface Activity {
    //insert new acitivity to database
    void addNewActivity(String name);
    
    //get acitivity list
    public ArrayList<String> getActivityList();
}
