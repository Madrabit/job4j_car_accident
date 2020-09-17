package ru.job4j.accident.repository.impl;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.Store;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author madrabit on 15.09.2020
 * @version 1$
 * @since 0.1
 */
@Repository
public class AccidentMem implements Store {

    final Map<Integer, Accident> accidents;
    private static final AtomicInteger POST_ID = new AtomicInteger(3);

    private static final class Lazy {
        private static final Store INST = new AccidentMem();
    }

    public static Store instOf() {
        return Lazy.INST;
    }

    public AccidentMem() {
        this.accidents = new HashMap<>();
        accidents.put(1, new Accident(1, "Petr", "lalala", "Spb"));
        accidents.put(2, new Accident(2, "Andrew", "hohoho", "Msk"));
    }

    @Override
    public Accident findById(int id) {
        return accidents.get(id);
    }

    @Override
    public Map<Integer, Accident> findAll() {
        return accidents;
    }

    @Override
    public void create(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(POST_ID.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
    }
}
