package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

/**
 * @author madrabit on 21.09.2020
 * @version 1$
 * @since 0.1
 */
@Repository
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
    public void create(Accident accident) {
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
