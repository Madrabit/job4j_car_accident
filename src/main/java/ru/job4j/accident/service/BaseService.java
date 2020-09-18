package ru.job4j.accident.service;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.Map;

/**
 * @author madrabit on 17.09.2020
 * @version 1$
 * @since 0.1
 */
public interface BaseService {
    Accident findById(int id);

    Map<Integer, Accident> findAll();

    void create(Accident accident);

    void addType(AccidentType accidentType);

    Map<Integer, AccidentType> findAllTypes();

    AccidentType findTypeById(int id);
}
