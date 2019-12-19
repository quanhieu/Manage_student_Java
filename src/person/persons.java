package person;
import java.util.*;
/**
 *
 * @author 840
 */
public abstract class persons {
   
    public String Name;
    public String Email;

    public persons() {
		Name = "unknow";
		Email = "unknow";
    }

    public persons(String Name, String Email) {
        this.Name = Name;
        this.Email = Email;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public String getName() {
        return Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }


    public String getEmail() {
        return Email;
    }
    

    @Override
    public String toString() {
        return Name +"\t"+"|"+Email; //To change body of generated methods, choose Tools | Templates.
    }
    
}