import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.test.entity.User;

public class TestComparator implements Comparator<User> {
 
    public int compare(User u1, User u2) {
        if (u1.equals(u2)){
            return 0;
        } else if (u1.getAge() < u2.getAge()){
            return 1;
        } else if (u1.getAge() == u2.getAge()){
            int f = u1.getName().compareTo(u2.getName());
            if(f < 0){
                return -1;
            }
            return 0;
        }else {
            return -1;
        }
    }
     
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User(10,"a"));
        users.add(new User(11,"d"));
        users.add(new User(15,"s"));
        users.add(new User(6,"x"));
        users.add(new User(17,"a"));
        users.add(new User(17,"b"));
        users.add(new User(17,"c"));
        users.add(new User(17,"d"));
        TestComparator comparator = new TestComparator();
        Collections.sort(users, comparator);
         
        for (User u : users){
            System.out.println(u.getAge());
        }
    }
}