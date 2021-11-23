package com.example.desafio.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Iterable<Produto> saveAll(Iterable<Produto> produtos) {
		return repository.saveAll(produtos);
	}

	public List<ProdutoDTO> getTop10Notas() {
		List<Double> medias = new ArrayList<>();
		List<Produto> produtos = repository.findAll();
		List<ProdutoDTO> top10 = new ArrayList<>();
		for (Produto produto : produtos) {
			medias.add(produto.getNota().stream().mapToDouble(Double::doubleValue).average().getAsDouble());
			double media = medias.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
			top10 = produto.getNota().stream().filter(n -> n.doubleValue() >= media)
					.map(p -> new ProdutoDTO(produto.getNome(), media)).limit(10).collect(Collectors.toList());
		}

		return top10;
	}
}
