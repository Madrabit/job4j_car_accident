package ru.job4j.accident.repository;

/**
 * @author madrabit on 23.09.2020
 * @version 1$
 * @since 0.1
 */
import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    Authority findByAuthority(String authority);
}
