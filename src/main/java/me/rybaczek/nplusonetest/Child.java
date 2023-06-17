package me.rybaczek.nplusonetest;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Child {
    @Id
    @SequenceGenerator(name = "itemSeq", initialValue = 101)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSeq")
    Long id;

    String name;
    Integer age;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + age +
                '}';
    }
}
