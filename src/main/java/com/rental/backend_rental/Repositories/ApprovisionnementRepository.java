package com.rental.backend_rental.Repositories;

import com.rental.backend_rental.models.Approvisionnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovisionnementRepository extends JpaRepository<Approvisionnement,Integer> {

}