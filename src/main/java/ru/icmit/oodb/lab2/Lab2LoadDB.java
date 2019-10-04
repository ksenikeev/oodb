package ru.icmit.oodb.lab2;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import ru.icmit.oodb.lab2.domain.Bank;
import ru.icmit.oodb.lab2.domain.Person;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Lab2LoadDB {

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
     * @return
     * @throws IOException
     * @throws JsonSyntaxException
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

    public static void main(String[] args) {
        try {
            loadPersonList().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
