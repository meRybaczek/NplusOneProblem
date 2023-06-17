package me.rybaczek.nplusonetest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parents, Long> {
    //@Query("select distinct s from OrderSummary s join s.items where s.userId = ?1")
    List<Parents> findByParentId(Long parentId);
}
