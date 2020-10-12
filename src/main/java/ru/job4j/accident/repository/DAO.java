package ru.job4j.accident.repository;

import ru.job4j.accident.model.Accident;

import java.util.List;

/**
 * @author madrabit on 19.09.2020
 * @version $
 * @since 0.1
 * This DAO was created for testing Mem, Jdbc and Hibernate storage.
 */
public interface DAO {
    Accident findById(int id);

    List<Accident> findAll();

    void save(Accident accident);
}
