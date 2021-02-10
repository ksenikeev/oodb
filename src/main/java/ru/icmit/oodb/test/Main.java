package ru.icmit.oodb.test;

import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;

public class Main {

    public static void main(String[] a) throws Exception {
        test1();
        test2();
        test3();
    }

    // XML -> JSON
    private static void test1(){
        Bank bank = null;

        // Загружаем XML в оперативную память
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            bank = (Bank) un.unmarshal(new File("test/test.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }


        if (bank != null) {
            Gson gson = new Gson();

            String result = gson.toJson(bank);

            System.out.println(result);

            try(FileOutputStream fos = new FileOutputStream("test/test.json")) {
                fos.write(result.getBytes("UTF-8"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    // JSON -> XML
    private static void test2() throws IOException {
        Bank bank = null;

        String bankStr = null;

        // Загружаем JSON в оперативную память
        File file = new File("test/test.json");

        if (file.exists()) {
            bankStr = new String(Files.readAllBytes(file.toPath()));
        }

        bank = new Gson().fromJson(bankStr, Bank.class);


        if (bank != null) {
            try {
                JAXBContext context = JAXBContext.newInstance(Bank.class);
                Marshaller marshaller = context.createMarshaller();
                // устанавливаем флаг для читабельного вывода XML в JAXB
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                // маршаллинг объекта в файл
                marshaller.marshal(bank, new File("test/test.xml"));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }

    // XML -> DB

    // create database test;
    // CREATE TABLE bank(bank jsonb);
    //)
    private static void test3() throws ClassNotFoundException, SQLException {

        Bank bank = null;

        // Загружаем XML в оперативную память
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            bank = (Bank) un.unmarshal(new File("test/test.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }


        if (bank != null) {
            Gson gson = new Gson();

            String result = gson.toJson(bank);

            Class.forName("org.postgresql.Driver");
            Connection connection =
                    DriverManager.getConnection( "jdbc:postgresql://localhost:5432/test",
                            "postgres", "post");

            PreparedStatement statement = connection.prepareStatement(
                    "insert into bank (bank) values ( ?::jsonb )"
            );
            statement.setString(1, result);

            statement.executeUpdate();

            statement.close();
            connection.close();
        }

    }

}
