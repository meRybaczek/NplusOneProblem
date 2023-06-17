package me.rybaczek.nplusonetest;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Parents {
    @Id
    @SequenceGenerator(name = "orderSeq", initialValue = 101)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSeq")
    Long id;

    Long motherId;

    String name;

    @OneToMany()
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 2)
    @JoinColumn(name = "SUMMARY_ID")
    List<Child> children = new ArrayList<>();

    public Long getMotherId() {
        return motherId;
    }

    public String getName() {
        return name;
    }

    public List<Child> getChild() {
        return children;
    }

    @Override
    public String toString() {
        return "OrderSummary{" +
                "id=" + id +
                ", userId=" + motherId +
                ", name='" + name + '\'' +
                ", items=" + children +
                '}';
    }
}
