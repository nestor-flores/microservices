package com.mercadolibre.sales.persistence.repository;

import com.mercadolibre.sales.persistence.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sale, Long> {
}
