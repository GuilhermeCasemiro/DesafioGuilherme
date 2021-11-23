package com.example.desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.desafio.produto.presente.Presente;
import com.example.desafio.produto.presente.PresenteService;

@SpringBootTest
class PresenteTest {

	@Autowired
	private PresenteService presenteService;

	@Test
	void criaPresente() {
		var presente = new Presente();
		presente.setNome("Max Steel");
		presente.setPreco(21.99);
		presenteService.save(presente);
		assertNotNull(presente.getId());

	}

	@Test
	void alteraPresente() {
		var presente = new Presente();

		presente.setNome("G.I Joe");
		presente.setPreco(50.90);

		presenteService.save(presente);
		var id = presente.getId();

		presente.setPreco(69.99);

		presenteService.save(presente);

		assertEquals(id, presente.getId());
		assertEquals(69.99, presente.getPreco());

	}
	
}
