package me.rybaczek.nplusonetest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, Long> {
    @Query("select distinct b from BookOrder b join fetch b.books where b.userId = ?1")
    List<BookOrder> findByUserId(Long userId);
}
