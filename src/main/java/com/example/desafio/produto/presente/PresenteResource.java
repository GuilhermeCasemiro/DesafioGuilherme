package com.example.desafio.produto.presente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/presentes")
public class PresenteResource {

    @Autowired 
    private PresenteService presenteService;
    
    @PostMapping
    public ResponseEntity<Presente> save(@RequestBody Presente presente){
    	Presente result = presenteService.save(presente);
    	return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Presente>> findAll(){
    	List<Presente> result = presenteService.findAll();
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Presente> findById(@PathVariable Long id){
    	Presente result = presenteService.findById(id);
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Presente> deleteById(@PathVariable Long id){
    	presenteService.deleteById(id);
    	return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Presente> update(@PathVariable Long id, @RequestBody Presente presente){
    	Presente result = presenteService.findById(id);
    	result.setNome(presente.getNome());
    	result.setPreco(presente.getPreco());
    	result.getItensPresente().addAll(presente.getItensPresente());
    	presenteService.save(result);
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
    
