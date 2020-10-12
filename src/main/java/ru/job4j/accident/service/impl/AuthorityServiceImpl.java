package ru.job4j.accident.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.job4j.accident.model.Authority;
import ru.job4j.accident.repository.AuthorityRepository;
import ru.job4j.accident.service.AuthorityService;

/**
 * @author madrabit on 06.10.2020
 * @version 1$
 * @since 0.1
 */
public class AuthorityServiceImpl implements AuthorityService {

    AuthorityRepository authorityRepository;

    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Authority findByAuthority(String authority) {
        return authorityRepository.findByAuthority(authority);
    }
}
