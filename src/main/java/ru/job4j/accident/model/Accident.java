package ru.job4j.accident.model;

/**
 * @author madrabit on 15.09.2020
 * @version 1$
 * @since 0.1
 */
public class Accident {
    private int id;
    private String name;
    private String text;
    private String address;

    public Accident(int id, String name, String text, String address) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.address = address;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String sb = "Accident{" + "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", address='" + address + '\'' +
                '}';
        return sb;
    }
}
