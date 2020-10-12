package ru.job4j.accident.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.DAO;

import java.util.List;

/**
 * JDBC implementation as repository.
 */

//@Repository
public class AccidentJdbcTemplate implements DAO {
    private static final Logger LOG = LogManager.getLogger(AccidentJdbcTemplate.class.getName());

    private final JdbcTemplate jdbc;


    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void save(Accident accident) {
        jdbc.update("insert into accident (name, description, address, accident_type_id) values (?, ?, ?, ?)",
                accident.getName(),
                accident.getDescription(),
                accident.getAddress(),
                accident.getType().getId());
    }

    @Override
    public Accident findById(int id) {
        return this.jdbc.queryForObject(
                "select * from accident where id = ?",
                (resultSet, rowNum) -> {
                    Accident accident = new Accident();
                    accident.setId(resultSet.getInt("id"));
                    accident.setName(resultSet.getString("name"));
                    accident.setDescription(resultSet.getString("description"));
                    accident.setAddress(resultSet.getString("address"));
                    accident.setType(AccidentType.of(resultSet.getInt("accident_type_id"), ""));
                    return accident;
                }, id);
    }

    @Override
    public List<Accident> findAll() {
        return jdbc.query("select id, name, description, address from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setDescription(rs.getString("description"));
                    accident.setAddress(rs.getString("address"));
                    return accident;
                });
    }
}
