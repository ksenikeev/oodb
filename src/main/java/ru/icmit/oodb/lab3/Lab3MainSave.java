package ru.icmit.oodb.lab3;

import ru.icmit.oodb.lab3.model.Bank;
import ru.icmit.oodb.lab3.model.BankAccount;
import ru.icmit.oodb.lab3.model.Client;
import java.util.ArrayList;
import java.util.List;

/**
 * Пример, демонстрирующий сохранение (маршаллинг) объекта в XML документ
 */
public class Lab3MainSave {

    public static void main(String[] args) {

        // Создаем объект банк
        Bank bank = new Bank();

        // Создаем объекты - клиенты банка
        Client client1 = new Client("Иван","Иванов","","");
        Client client2 = new Client("Петр","Петров","","");

        // Добавляем объекту client1 расчетный счет
        BankAccount account = new BankAccount(1299876);
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(account);
        client1.setAccounts(accounts);

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        // Прикрепляем клиентов к банку
        bank.setClients(clients);

        // сохраняем объект в в XML документ
        Lab3XMLService.saveBankData(bank);
    }
}
