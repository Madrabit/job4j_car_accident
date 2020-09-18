package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.impl.AccidentMem;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author madrabit on 15.09.2020
 * @version 1$
 * @since 0.1
 */
@Service
public class AccidentService implements BaseService {

    private AccidentMem mem;

    public AccidentService(AccidentMem mem) {
        this.mem = mem;
    }

    @Override
    public Accident findById(int id) {
        return mem.getAccidents().get(id);
    }

    @Override
    public Map<Integer, Accident> findAll() {
        return mem.getAccidents();
    }

    @Override
    public void create(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(AccidentMem.getAccId().incrementAndGet());
        }
        mem.getAccidents().put(accident.getId(), accident);
    }

    @Override
    public void addType(AccidentType accidentType) {
        if (accidentType.getId() == 0) {
            accidentType.setId(AccidentMem.getTypeId().incrementAndGet());
        }
        mem.getTypes().put(accidentType.getId(), accidentType);
    }

    @Override
    public Map<Integer, AccidentType> findAllTypes() {
        return mem.getTypes();
    }

    @Override
    public AccidentType findTypeById(int id) {
        return mem.getTypes().get(id);
    }
}
