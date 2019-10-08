package com.jckuntz.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jckuntz.cursomc.domain.Categoria;
import com.jckuntz.cursomc.domain.Cidade;
import com.jckuntz.cursomc.domain.Cliente;
import com.jckuntz.cursomc.domain.Endereco;
import com.jckuntz.cursomc.domain.Estado;
import com.jckuntz.cursomc.domain.Produto;
import com.jckuntz.cursomc.domain.enums.TipoCliente;
import com.jckuntz.cursomc.repositories.CategoriaRepository;
import com.jckuntz.cursomc.repositories.CidadeRepository;
import com.jckuntz.cursomc.repositories.ClienteRepository;
import com.jckuntz.cursomc.repositories.EnderecoRepository;
import com.jckuntz.cursomc.repositories.EstadoRepository;
import com.jckuntz.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		Produto p1 =  new Produto(null, "Computador", 2000.00);
		Produto p2 =  new Produto(null, "Impressora", 800.00);
		Produto p3 =  new Produto(null, "Mouse", 80.00);
		
		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		
		Estado estadoMG = new Estado(null, "Minas Gerais");
		Estado estadoSP = new Estado(null, "São Paulo");
		
		Cidade cidadeUberlandia = new Cidade(null, "Uberlândia", estadoMG);
		Cidade cidadeSaoPaulo = new Cidade(null, "São Paulo", estadoSP);
		Cidade cidadeCampinas = new Cidade(null, "Campinas", estadoSP);
		
		estadoMG.getCidades().addAll((Arrays.asList(cidadeUberlandia)));
		estadoSP.getCidades().addAll((Arrays.asList(cidadeSaoPaulo, cidadeCampinas)));
		
		estadoRepository.saveAll(Arrays.asList(estadoMG, estadoSP));
		
		cidadeRepository.saveAll(Arrays.asList(cidadeUberlandia, cidadeSaoPaulo, cidadeCampinas));		
		
		categoriaRepository.saveAll(Arrays.asList(c1,c2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Cliente clienteMaria = new Cliente(null, "Maria Silva", "maria@gmail.com", "101010", TipoCliente.PESSOA_FISICA);
		clienteMaria.getTelefones().addAll(Arrays.asList("88343348", "33363785"));
		
		Endereco endereco = new Endereco(null, "Rua sim", "500", "muro amarelo", "Garcia", "90", clienteMaria, cidadeSaoPaulo);
		Endereco endereco2 = new Endereco(null, "Rua não", "200", "sem muro", "Bairro Centro", "89025365", clienteMaria, cidadeUberlandia);
		
		clienteMaria.getEnderecos().addAll(Arrays.asList(endereco, endereco2));
		
		clienteRepository.save(clienteMaria);
		enderecoRepository.saveAll(Arrays.asList(endereco, endereco2));
		
		
		
	}

}
