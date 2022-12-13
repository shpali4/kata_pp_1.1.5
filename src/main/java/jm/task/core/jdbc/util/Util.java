package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String URL = "jdbc:mysql://localhost:3306/1.1.4DB";
    public static final String USER = "root";
    public static final String PASSWORD = "Ucduhu18z";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String DIALECT = "org.hibernate.dialect.MySQL8Dialect";

    private static SessionFactory sessionFactory;
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с базой данных установлено");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration()
                .setProperty("hibernate.connection.url", URL)
                .setProperty("hibernate.connection.username", USER)
                .setProperty("hibernate.connection.password", PASSWORD)
                .setProperty("hibernate.connection.driver_class", DRIVER)
                .setProperty("hibernate.dialect", DIALECT);
        sessionFactory = configuration.addAnnotatedClass(User.class).buildSessionFactory();
        return sessionFactory;
    }

    public static void closeSession() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
