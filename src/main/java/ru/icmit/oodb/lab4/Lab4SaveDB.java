package ru.icmit.oodb.lab4;

import com.google.gson.Gson;
import ru.icmit.oodb.lab4.domain.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Lab4SaveDB {

    public static void savePersonList(List<Person> persons, Connection connection) throws SQLException {

        if (persons != null && persons.size() > 0) {
            Gson gson = new Gson();

            String personsAsJson = gson.toJson(persons);

            PreparedStatement statement = connection.
                    prepareStatement("insert into jtest (content, contentb) values ( cast( ? as json) , cast( ? as json) )");
            statement.setString(1, personsAsJson);
            statement.setString(2, personsAsJson);

            int count = statement.executeUpdate();

            System.out.println(count + " records added!");

            statement.close();

        }
    }
}
