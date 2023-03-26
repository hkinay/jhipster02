package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Ogretmen;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Ogretmen entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OgretmenRepository extends JpaRepository<Ogretmen, Long> {}
