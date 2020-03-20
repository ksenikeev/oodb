package ru.icmit.oodb.lab8;

import ru.icmit.oodb.lab8.annotation.Entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class EntityManagerImpl implements EntityManager {

    /**
     * Метод сохраняет экземпляр класса в базу данных
     * @param var1
     */
    @Override
    public void persist(Object var1) throws Exception {
        // Задача этого метода сформировать и выполнить запрос
        // INSERT INTO ...
        // Для этого мы должны получить имя таблицы, имена полей и их значения

        // 1. Проверяем наличие аннотации @Entity
        Annotation entity = var1.getClass().getAnnotation(Entity.class);
        // Если аннотации @Entity нет, то прекращаем работу, генерируя исключение
        if (entity == null)
            throw new Exception("Class " + var1.getClass().getCanonicalName() + " is not Entity!");

        // 1. Получаем имя таблицы
        String tableName = var1.getClass().getSimpleName().toLowerCase();

        // Получаем список членов класса
        Field[] fields = var1.getClass().getDeclaredFields();
        for (Field field : fields) {

        }

    }

    @Override
    public <T> T merge(T var1) {
        return null;
    }

    @Override
    public void remove(Object var1) {

    }

    @Override
    public <T> T find(Class<T> var1, Object var2) {
        return null;
    }

    @Override
    public void refresh(Object var1) {

    }
}
