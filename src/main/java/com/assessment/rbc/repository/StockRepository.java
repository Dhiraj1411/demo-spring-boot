package com.assessment.rbc.repository;

import com.assessment.rbc.models.StockEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer> {
    Optional<List<StockEntity>> findByStock(String stock);
}
