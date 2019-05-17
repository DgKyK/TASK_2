package ua.alex.task.model.dao;

import java.util.List;

public interface Dao<E> {
    List<E> getAll();
}
