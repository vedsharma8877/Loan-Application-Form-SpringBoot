package com.example.LoanApplication.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.LoanApplication.model.LoanApplicationModel;

public interface LoanApplicationRepository extends MongoRepository<LoanApplicationModel, String> {
  List<LoanApplicationModel> findByIdContaining(String id);

		  
}