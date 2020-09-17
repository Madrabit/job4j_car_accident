package ru.job4j.accident.repository;

import ru.job4j.accident.model.Accident;

import java.util.Map;

/**
 * @author madrabit on 17.09.2020
 * @version 1$
 * @since 0.1
 */
public interface Store {
    Accident findById(int id);

    Map<Integer, Accident> findAll();

    void create(Accident accident);
}
