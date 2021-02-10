package ru.icmit.oodb.lab4;

import ru.icmit.oodb.lab4.domain.Person;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Lab4Main {

    public static void main(String[] args) {

        try {

            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/oodb";
            Connection connection =
                    DriverManager.getConnection( dbURL, "postgres", "post");

            Lab4LoadFromDb.loadPersonList(connection);

            List<Person> persons = Lab4LoadFromFile.loadPersonList();

            persons.forEach(System.out::println);

            Person prs = PersonService.findPersonByName(persons, "Иван");

            if (prs != null) {
                prs.setPhoneNumber("+71111111111");
                prs.setEmail("ivan@mail.ru");
            }


            Lab4SaveDB.savePersonList(persons, connection);


            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
