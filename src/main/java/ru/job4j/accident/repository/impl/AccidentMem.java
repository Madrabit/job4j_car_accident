package ru.job4j.accident.repository.impl;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author madrabit on 15.09.2020
 * @version 1$
 * @since 0.1
 * This class is for memory storage test.
 */
//@Repository
public class AccidentMem implements DAO {


    private static final AtomicInteger ACC_ID = new AtomicInteger(3);
    private static final AtomicInteger TYPE_ID = new AtomicInteger(4);

    private Map<Integer, Accident> accidents;
    private Map<Integer, AccidentType> types;


    public AccidentMem() {
        this.accidents = new HashMap<>();
        this.types = new HashMap<>();
//        accidents.put(1, new Accident(1, "Petr", "lalala", "Spb", AccidentType.of(1, "Две машины")));
//        accidents.put(2, new Accident(2, "Andrew", "hohoho", "Msk", AccidentType.of(1, "Две машины")));
    }

    public Map<Integer, Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(Map<Integer, Accident> accidents) {
        this.accidents = accidents;
    }

    public Map<Integer, AccidentType> getTypes() {
        return types;
    }

    public void setTypes(Map<Integer, AccidentType> types) {
        this.types = types;
    }

    public static AtomicInteger getAccId() {
        return ACC_ID;
    }

    public static AtomicInteger getTypeId() {
        return TYPE_ID;
    }

    @Override
    public Accident findById(int id) {
        return accidents.get(id);
    }

    @Override
    public List<Accident> findAll() {
        return (List<Accident>) accidents;
    }

    @Override
    public void save(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(ACC_ID.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
    }

    public void addType(AccidentType accidentType) {
        if (accidentType.getId() == 0) {
            accidentType.setId(TYPE_ID.incrementAndGet());
        }
        types.put(accidentType.getId(), accidentType);
    }

    public Map<Integer, AccidentType> findAllTypes() {
        return types;
    }

    public AccidentType findTypeById(int id) {
        return types.get(id);
    }
}
