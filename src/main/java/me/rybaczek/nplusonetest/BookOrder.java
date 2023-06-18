package me.rybaczek.nplusonetest;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
public class BookOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long userId;

    String name;

    @OneToMany
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "BOOK_ORDER_ID")
    List<Book> books = new ArrayList<>();

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", items=" + books +
                '}';
    }
}
