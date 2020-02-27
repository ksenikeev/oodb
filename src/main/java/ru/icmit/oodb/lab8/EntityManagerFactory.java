package ru.icmit.oodb.lab8;

import java.sql.Connection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;

public class EntityManagerFactory {

    /**
     * Подключение к БД. Это подключение передается в класс реализацию EntityManager
     * при его создании.
     */
    private Connection connection;

    /**
     * Параметры подключения к базе данных:
     * <p> url - путь к БД для JDBC драйвера (например "jdbc:postgresql://localhost:5432/lab8")
     * <p> username - имя пользователя СУБД
     * <p> password - пароль пользователя СУБД
     */
    private Properties dbProperties;

    /**
     * Структура для хранения сведений о базе данных (таблицы, их поля)
     */
    private HashMap<String, HashSet<String>> tables = new HashMap<>();

    /**
     * Конструктор класса
     * @param dbProperties - параметры подключения к базе данных
     */
    public EntityManagerFactory(Properties dbProperties) {
        this.dbProperties = dbProperties;
    }

    /**
     * Метод создает, инициализирует экземпляр класса, реализующего EntityManager
     */
    public EntityManager createEntityManager() {
        return null;
    }

    /**
     * Метод создает (если еще не создано) и возвращает подключение к БД
     */
    private Connection getConnection() {
        return null;
    }

    /**
     * Метод сканирует структуру классов модели, структуру базы данных,
     * сравнивает их и возвращает булевский результат сравнения
     */
    private boolean scanModel() {
        return true;
    }
}
