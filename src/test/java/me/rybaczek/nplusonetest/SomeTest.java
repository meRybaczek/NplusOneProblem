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
    private ParentRepository summaryRepository;

    @Test
    @Transactional
    void shouldExtractItemsFromOrders(){

        List<Parents> summaries = summaryRepository.findByParentId(1L);

        List<Child> list = summaries.stream()
                .map(Parents::getChild)
                .flatMap(Collection::stream)
                .toList();

        assertEquals(8,list.size());
    }
    @Transactional
    @Test
    void shouldTest(){

        List<Parents> summaries = summaryRepository.findByParentId(1L);
        summaries.forEach(System.out::println);

    }

}
