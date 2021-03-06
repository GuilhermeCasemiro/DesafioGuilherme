package com.example.desafio.produto.presente;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenteRepository extends CrudRepository<Presente, Long> {

	List<Presente> findAll();

}
