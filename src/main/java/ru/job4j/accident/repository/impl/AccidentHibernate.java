package ru.job4j.accident.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.DAO;

import java.util.List;

/**
 * @author madrabit on 21.09.2020
 * @version 1$
 * @since 0.1
 * Hibernate DAO implementation.
 */
//@Repository
public class AccidentHibernate implements DAO {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<Accident> findAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident", Accident.class)
                    .list();
        }
    }

    @Override
    public void save(Accident accident) {
        try (Session session = sf.openSession()) {
            session.save(accident);
        }
    }


    @Override
    public Accident findById(int id) {
        try (Session session = sf.openSession()) {
            return session.get(Accident.class, id);

        }
    }
}
