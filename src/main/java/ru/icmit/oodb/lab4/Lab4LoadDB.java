package ru.icmit.oodb.lab4;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import ru.icmit.oodb.lab4.domain.Bank;
import ru.icmit.oodb.lab4.domain.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Lab4LoadDB {

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
    public static List<Person> loadPersonList() throws IOException, JsonSyntaxException {
        String pStr = "";
        File file = new File("persons.json");

        if (file.exists()) {
            pStr = new String(Files.readAllBytes(file.toPath()));
        } else {
            System.out.println("File persons.json not found!");
        }

        Gson gson = new Gson();

        Person[] plst = gson.fromJson(pStr, Person[].class);

        return Arrays.asList(plst);
    }
}
