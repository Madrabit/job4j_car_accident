package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;
import java.util.Map;

/**
 * @author madrabit on 15.09.2020
 * @version 1$
 * @since 0.1
 */
@Repository
public class AccidentMem {

    Map<Integer, Accident> accidents = new HashMap<>();
}
