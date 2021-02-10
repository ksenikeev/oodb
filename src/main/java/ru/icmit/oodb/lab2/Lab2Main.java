package ru.icmit.oodb.lab2;

import ru.icmit.oodb.lab2.domain.Person;

import java.io.IOException;
import java.util.List;

public class Lab2Main {

    public static void main(String[] args) {
        try {

            List<Person> persons = Lab2LoadDB.loadPersonList();

            persons.forEach(System.out::println);

            Person prs = PersonService.findPersonByName(persons, "Иван");

            if (prs != null) {
                prs.setPhoneNumber("+71111111111");
                prs.setEmail("ivan@mail.ru");
            }

            Lab2SaveDB.savePersonList(persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
