package ru.job4j.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.Accident;

/**
 * @author madrabit on 21.09.2020
 * @version 1$
 * @since 0.1
 */
public interface AccidentRepository extends CrudRepository<Accident, Integer> {
}
