import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String,User> userMap=new HashMap<>();

    private User currentUser=null;

    Boolean RegisterUser(String username, String password, String fullname, String contact)
    {
        if(userMap.containsKey(username))
        {
            System.out.println("This username taken by someone... Use another username");
            return false;
        }
        User user=new User(username,password,fullname,contact);
        currentUser=user;
        userMap.put(username,user);
        System.out.println("Registration successfully by "+username);
        return true;
    }

    Boolean LogInUser(String username, String password)
    {
        if(!userMap.containsKey(username))
        {
            System.out.println("Incorrect username ");
            return false;
        }

        User user=userMap.get(username);
        if(!user.getPassword().equalsIgnoreCase(password))
        {
            System.out.println("Incorrect Password");
            return false;
        }

        System.out.println("Welcome...."+currentUser.getFullName());
        return true;
    }

    void LogOut(){
        if(currentUser!=null)
        {
            System.out.println("Logout successfully by "+currentUser.getFullName());
        }
    }

    User getCurrentUser(){
        return currentUser;
    }

    Boolean IsLogIn(){
        return currentUser!=null;
    }
}
