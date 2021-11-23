package com.example.desafio.produto.presente;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PresenteService {

	@Autowired
	private PresenteRepository repository;

	public List<Presente> findAll() {
		List<Presente> result = repository.findAll();
		return result;
	}

	public Presente findById(Long id) {
		return repository.findById(id).get();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Presente save(Presente presente) {
		return repository.save(presente);
	}

}
