package ru.job4j.accident.service.impl;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.service.AccidentService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madrabit on 15.09.2020
 * @version 1$
 * @since 0.1
 */
@Service
public class AccidentServiceImpl implements AccidentService {

    AccidentRepository accidents;

    public AccidentServiceImpl(AccidentRepository accidents) {
        this.accidents = accidents;
    }

    public Accident findById(int id) {
        return accidents.findById(id).get();
    }

    @Override
    public List<Accident> findAll() {
        List<Accident> list = new ArrayList<>();
        this.accidents.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void save(Accident accident) {
        accidents.save(accident);
    }
}
