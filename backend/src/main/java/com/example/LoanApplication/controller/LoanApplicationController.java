package com.example.LoanApplication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.LoanApplication.model.LoanApplicationModel;
import com.example.LoanApplication.repository.LoanApplicationRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class LoanApplicationController {
	@Autowired
	LoanApplicationRepository loanApplication;

	@PostMapping("/loanApplication")
	public ResponseEntity<LoanApplicationModel> createLoanApplicationModel(
			@RequestBody LoanApplicationModel loanApplicationModel) {
		try {
			loanApplicationModel.setStatus("Pending");

			LoanApplicationModel _loanApplicationModel = loanApplication.save(new LoanApplicationModel(
					loanApplicationModel.getLamount(), loanApplicationModel.getLpurpose(),
					loanApplicationModel.getFname(), loanApplicationModel.getMname(), loanApplicationModel.getLname(),
					loanApplicationModel.getDob(), loanApplicationModel.getEmail(), loanApplicationModel.getHphone(),
					loanApplicationModel.getMphone(), loanApplicationModel.getSsn(), loanApplicationModel.getSa1(),
					loanApplicationModel.getSa2(), loanApplicationModel.getCity(), loanApplicationModel.getStatess(),
					loanApplicationModel.getZip(), loanApplicationModel.getRd(), loanApplicationModel.getRt(),
					loanApplicationModel.getStatus()));

			LoanApplicationModel _loanApplicationModel = loanApplication.save(new LoanApplicationModel(
					loanApplicationModel.getLamount(), loanApplicationModel.getLpurpose(),
					loanApplicationModel.getFname(), loanApplicationModel.getMname(), loanApplicationModel.getLname(),
					loanApplicationModel.getDob(), loanApplicationModel.getEmail(), loanApplicationModel.getHphone(),
					loanApplicationModel.getMphone(), loanApplicationModel.getSsn(), loanApplicationModel.getSa1(),
					loanApplicationModel.getSa2(), loanApplicationModel.getCity(), loanApplicationModel.getStatess(),
					loanApplicationModel.getZip(), loanApplicationModel.getRd(), loanApplicationModel.getRt(),
					loanApplicationModel.getStatus()));

			LoanApplicationModel _loanApplicationModel = loanApplication.save(new LoanApplicationModel(
					loanApplicationModel.getLamount(), loanApplicationModel.getLpurpose(),
					loanApplicationModel.getFname(), loanApplicationModel.getMname(), loanApplicationModel.getLname(),
					loanApplicationModel.getDob(), loanApplicationModel.getEmail(), loanApplicationModel.getHphone(),
					loanApplicationModel.getMphone(), loanApplicationModel.getSsn(), loanApplicationModel.getSa1(),
					loanApplicationModel.getSa2(), loanApplicationModel.getCity(), loanApplicationModel.getStatess(),
					loanApplicationModel.getZip(), loanApplicationModel.getRd(), loanApplicationModel.getRt(),
					loanApplicationModel.getStatus()));
			return new ResponseEntity<>(_loanApplicationModel, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/loanApplication")
	public ResponseEntity<List<LoanApplicationModel>> getAllLoanApplicationModel(
			@RequestParam(required = false) String id) {
		try {
			List<LoanApplicationModel> loanApplicationModels = new ArrayList<LoanApplicationModel>();
			if (id == null)
				loanApplication.findAll().forEach(loanApplicationModels::add);
			else
				loanApplication.findByIdContaining(id).forEach(loanApplicationModels::add);
			if (loanApplicationModels.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(loanApplicationModels, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/loanApplication/{id}")
	public ResponseEntity<LoanApplicationModel> updateLoanApplication(@PathVariable("id") String id,
			@RequestBody LoanApplicationModel loanApplicationModel) {
		Optional<LoanApplicationModel> loanApplicationData = loanApplication.findById(id);
		LoanApplicationModel _loanApplicationModel = loanApplicationData.get();
		try {
			if (loanApplicationData.isPresent()) {

				_loanApplicationModel.setLamount(_loanApplicationModel.getLamount());
				_loanApplicationModel.setLpurpose(_loanApplicationModel.getLpurpose());
				_loanApplicationModel.setFname(_loanApplicationModel.getFname());
				_loanApplicationModel.setMname(_loanApplicationModel.getMname());
				_loanApplicationModel.setLname(_loanApplicationModel.getLname());
				_loanApplicationModel.setDob(_loanApplicationModel.getDob());
				_loanApplicationModel.setEmail(_loanApplicationModel.getEmail());
				_loanApplicationModel.setHphone(_loanApplicationModel.getHphone());
				_loanApplicationModel.setMphone(_loanApplicationModel.getMphone());
				_loanApplicationModel.setSsn(_loanApplicationModel.getSsn());
				_loanApplicationModel.setSa1(_loanApplicationModel.getSa1());
				_loanApplicationModel.setSa2(_loanApplicationModel.getSa2());
				_loanApplicationModel.setCity(_loanApplicationModel.getCity());
				_loanApplicationModel.setStatess(_loanApplicationModel.getStatess());
				_loanApplicationModel.setZip(_loanApplicationModel.getZip());
				_loanApplicationModel.setRd(_loanApplicationModel.getRd());
				_loanApplicationModel.setRt(_loanApplicationModel.getRt());
				_loanApplicationModel.setStatus(loanApplicationModel.getStatus());

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(loanApplication.save(_loanApplicationModel), HttpStatus.OK);
	}
}