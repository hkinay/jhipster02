package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Sinif;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Sinif entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SinifRepository extends JpaRepository<Sinif, Long> {}
