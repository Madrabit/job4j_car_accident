package ru.job4j.accident.repository.impl;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
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
    final Map<Integer, AccidentType> types;

    private static final AtomicInteger ACC_ID = new AtomicInteger(3);
    private static final AtomicInteger TYPE_ID = new AtomicInteger(4);

    private static final class Lazy {
        private static final Store INST = new AccidentMem();
    }

    public static Store instOf() {
        return Lazy.INST;
    }

    public AccidentMem() {
        this.accidents = new HashMap<>();
        this.types = new HashMap<>();
//        accidents.put(1, new Accident(1, "Petr", "lalala", "Spb", 1));
//        accidents.put(2, new Accident(2, "Andrew", "hohoho", "Msk", 2));
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
            accident.setId(ACC_ID.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
    }

    @Override
    public void addType(AccidentType accidentType) {
        if (accidentType.getId() == 0) {
            accidentType.setId(TYPE_ID.incrementAndGet());
        }
        types.put(accidentType.getId(), accidentType);
    }

    @Override
    public Map<Integer, AccidentType> findAllTypes() {
        return types;
    }

    @Override
    public AccidentType findTypeById(int id) {
        return types.get(id);
    }
}
