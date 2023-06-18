package me.rybaczek.nplusonetest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;
@SpringBootTest
public class SomeTest {
    @Autowired
    private BookOrderRepository bookOrderRepository;

    @Test
    @Transactional
    void shouldCountBooksFromUserId(){

        List<BookOrder> byUserId = bookOrderRepository.findByUserId(1L);

        List<Book> list = byUserId.stream()
                .map(BookOrder::getBooks)
                .flatMap(Collection::stream)
                .toList();

        assertEquals(10,list.size());
    }
    @Transactional
    @Test
    void shouldTest(){

        List<BookOrder> summaries = bookOrderRepository.findByUserId(1L);
        summaries.forEach(System.out::println);

    }

}
