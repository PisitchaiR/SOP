package com.example.week6.repository;

import com.example.week6.pojo.Wizard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface WizardRepository extends MongoRepository<Wizard, String> {
    @Query(value="{_id: '?0'}")
    public Wizard getWizardById(String id);
}
