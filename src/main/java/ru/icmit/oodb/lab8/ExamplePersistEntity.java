package ru.icmit.oodb.lab8;

import ru.icmit.oodb.lab8.annotation.Column;
import ru.icmit.oodb.lab8.annotation.Entity;
import ru.icmit.oodb.lab8.domain.Bank;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ExamplePersistEntity {

    private Connection connection;

    private Properties dbProperties;

    public ExamplePersistEntity(Properties dbProperties) {
        this.dbProperties = dbProperties;
        getConnection();
    }

    public static void main(String[] args) throws Exception {

        Properties dbProperties = new Properties();
        dbProperties.setProperty("url","jdbc:postgresql://localhost:5432/lab8");
        dbProperties.setProperty("username","postgres");
        dbProperties.setProperty("password","post");

        ExamplePersistEntity epe = new ExamplePersistEntity(dbProperties);

        Bank bank = new Bank();
        bank.setName("Центробанк");
        epe.persist(bank);

        epe.close();
    }

    public void persist(Object var1) throws Exception {

        Annotation entity = var1.getClass().getAnnotation(Entity.class);
        if (entity == null)
            throw new Exception("Class " + var1.getClass().getCanonicalName() + " is not Entity!");


        String tableName = var1.getClass().getSimpleName().toLowerCase();

        System.out.println(tableName);

        Field[] fields = var1.getClass().getDeclaredFields();
        for (Field field : fields) {

            Annotation[] annotations = field.getAnnotations();
            for (Annotation a : annotations) {
                if (a.annotationType().equals(Column.class)) {

                    try {
                        Method method = var1.getClass().getMethod(
                                "get"+field.getName().substring(0,1).toUpperCase()+
                                        field.getName().substring(1),null);
                        System.out.println(method.getName());

                        String value = (String) method.invoke(var1);
                        System.out.println(value);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    System.out.println(field.getName());
                }
            }
        }



    }

    public Connection getConnection() {

        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                connection = DriverManager.getConnection(dbProperties.getProperty("url"),
                        dbProperties.getProperty("username"), dbProperties.getProperty("password"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public void close() {
        closeConnection();
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
