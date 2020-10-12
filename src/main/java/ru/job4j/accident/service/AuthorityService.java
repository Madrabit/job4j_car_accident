package ru.job4j.accident.service;

import ru.job4j.accident.model.Authority;

/**
 * @author madrabit on 06.10.2020
 * @version 1$
 * @since 0.1
 */
public interface AuthorityService {
    Authority findByAuthority(String role_user);
}
