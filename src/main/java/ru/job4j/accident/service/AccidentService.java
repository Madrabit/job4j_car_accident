package ru.job4j.accident.service;

import ru.job4j.accident.model.Accident;

import java.util.List;

/**
 * @author madrabit on 05.10.2020
 * @version 1$
 * @since 0.1
 */
public interface AccidentService {
    Accident findById(int id);

    List<Accident> findAll();

    void save(Accident accident);
}
