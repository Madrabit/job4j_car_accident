package ru.job4j.accident.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author madrabit on 15.09.2020
 * @version 1$
 * @since 0.1
 */
@Entity
@Table(name = "accident")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accident_type_id", foreignKey = @ForeignKey(name = "TYPE_ID_FK"))
    private AccidentType type;

    @Transient
    private Set<Rule> rules;

    public Accident(int id, String name, String description, String address, AccidentType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.type = type;
    }

    public Accident() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AccidentType getType() {
        return type;
    }

    public void setType(AccidentType type) {
        this.type = type;
    }

    public Set<Rule> getRules() {
        return rules;
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Accident accident = (Accident) o;
        return id == accident.id
                && Objects.equals(name, accident.name)
                && Objects.equals(description, accident.description)
                && Objects.equals(address, accident.address)
                && Objects.equals(type, accident.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, address, type);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Accident{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", type=").append(type);
        sb.append(", rules=").append(rules);
        sb.append('}');
        return sb.toString();
    }
}
