package com.rental.backend_rental.services;

import com.rental.backend_rental.Repositories.ApprovisionnementRepository;
import com.rental.backend_rental.models.Approvisionnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionnementService {

    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;

    public void save(Approvisionnement approvisionnement)
    {
        approvisionnementRepository.save(approvisionnement);
    }

    public List<Approvisionnement> showAllApprovisionnement()
    {
        return approvisionnementRepository.findAll();
    }

    public Approvisionnement selectOneApprovisionnement(int id)
    {
        return approvisionnementRepository.findById(id).get();
    }

    public  void deleteApprovisionnement(int id)
    {
        approvisionnementRepository.deleteById(id);
    }

}