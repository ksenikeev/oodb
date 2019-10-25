package ru.icmit.oodb.lab4;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import ru.icmit.oodb.lab4.domain.Bank;
import ru.icmit.oodb.lab4.domain.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Lab4LoadFromDb {

    public static Bank load() throws IOException {
        Bank bank = null;
        String bankStr = "";
        File file = new File("bank.json");

        if (file.exists()) {
            bankStr = new String(Files.readAllBytes(file.toPath()));
        }

        bank = new Gson().fromJson(bankStr, Bank.class);

        return bank;
    }

    /**
     * Пример чтения из файла массива JSON объектов
     */
    public static List<Person> loadPersonList(Connection connection) throws JsonSyntaxException, SQLException {
        String pStr = "";

        PreparedStatement statement =
                connection.prepareStatement("select contentb from jtest ");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            pStr = resultSet.getString("contentb");
            System.out.println(pStr);
        }

        statement.close();

        Gson gson = new Gson();

        Person[] plst = gson.fromJson(pStr, Person[].class);


        statement =
                connection.prepareStatement("select contentb->1 as c from jtest ");

        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            pStr = resultSet.getString("c");
            System.out.println(pStr);
        }

        return Arrays.asList(plst);
    }
}
