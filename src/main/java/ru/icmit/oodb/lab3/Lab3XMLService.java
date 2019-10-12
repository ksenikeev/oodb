package ru.icmit.oodb.lab3;

import ru.icmit.oodb.lab3.model.Bank;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class Lab3XMLService {

    /**
     * метод saveBankData сохраняет объект типа Bank в XML документ
     */
    public static void saveBankData(Bank bank) {

        try {
            JAXBContext context = JAXBContext.newInstance(Bank.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(bank, new File("bank.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод loadBankFromXML преобразует XML документ в объект типа Bank
     * @return
     */
    public static Bank loadBankFromXML() {

        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Bank) un.unmarshal(new File("bank.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
