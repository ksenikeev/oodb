package ru.icmit.oodb.lab3;

import ru.icmit.oodb.lab3.model.Bank;
import ru.icmit.oodb.lab3.model.BankAccount;
import ru.icmit.oodb.lab3.model.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Пример, демонстрирующий преобразование XML документа в объект
 */
public class Lab3MainLoad {

    public static void main(String[] args) {

        Bank bank = Lab3XMLService.loadBankFromXML();

        System.out.println(bank);
    }
}
