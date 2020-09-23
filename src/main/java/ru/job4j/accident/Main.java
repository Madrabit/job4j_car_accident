package ru.job4j.accident;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author madrabit on 23.09.2020
 * @version 1$
 * @since 0.1
 */
public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode("secret");
        System.out.println(pwd);
    }
}
