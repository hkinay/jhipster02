package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Ogrenci;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Ogrenci entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {}
