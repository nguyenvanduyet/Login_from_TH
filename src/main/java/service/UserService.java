package service;

import model.Login;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<model.User> users;
    static {
        users = new ArrayList<>();
        model.User u1 = new model.User();
        u1.setAge(10);
        u1.setName("John");
        u1.setAccount("john");
        u1.setEmail("john@codegym.vn");
        u1.setPassword("123456");
        users.add(u1);

        model.User u2 = new model.User();
        u2.setAge(15);
        u2.setName("Bill");
        u2.setAccount("bill");
        u2.setEmail("bill@codegym.vn");
        u2.setPassword("123456");
        users.add(u2);

        model.User u3 = new model.User();
        u3.setAge(16);
        u3.setName("Mike");
        u3.setAccount("mike");
        u2.setEmail("mike@codegym.vn");
        u3.setPassword("123456");
        users.add(u3);
    }

    public static model.User checkLogin(Login login){
        for (model.User u: users) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }

}
