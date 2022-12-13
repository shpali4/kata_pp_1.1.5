package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Alex", "Tolstov", (byte) 45);
        userService.saveUser("Petr","Ivanov", (byte) 15);
        userService.saveUser("Mihail","Tolstov", (byte) 69);
        userService.saveUser("Gosha","Alekseev", (byte) 23);
        System.out.println(userService.getAllUsers());
        userService.removeUserById(2);
        userService.cleanUsersTable();
        userService.dropUsersTable();

        Util.closeSession();
    }
}
