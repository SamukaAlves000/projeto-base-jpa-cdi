package com.stefanini.teste;

import java.time.LocalDate;
import java.util.Optional;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.EnderecoServico;
import com.stefanini.servico.PerfilServico;
import com.stefanini.servico.PessoaServico;

public class App {

	@Inject
	private PessoaServico servico;
	@Inject
	private EnderecoServico enderecoServico;
	@Inject
	private PerfilServico perfilServico;

	public static void main(String[] args) {
		// CONFIGURACAO PARA INICIAR O CONTAINER PARA GERENCIAMENTO DO CDI
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (final SeContainer container = initializer.initialize()) {
			App app = container.select(App.class).get();
			app.executar();
		}
	}

	public void executar() {
		
	enderecoServico.getCidadesPorUf("GO")
	.stream()
	.distinct()
	.forEach(
			c -> {
				 	System.out.println(c);
				 }
			);
	
	
	for (Pessoa pessoa : servico.getListPessoa("Campos Belos", "GO")) {
		System.out.println(pessoa);
	}
	
	popularBancoDeDados();
	buscarTodos();
	encontrar();
    salvar();
    remover();
    
	
	}
	
	
	private void remover() {
		
	}

	private void encontrar() {
		Optional<Pessoa> pessoa = servico.encontrar(5L);
		if (pessoa.isPresent()) {
			System.out.println("Pessoa encontrada");
			System.out.println(pessoa.get());
		} else {
			System.out.println("Pessoa não encontrada");
		}
	}

	private void buscarTodos() {
		servico.getList().ifPresent(i -> {
			i.forEach(b -> {
				System.out.println(b);
			});
		});
		System.out.println();
	}

	public void salvar() {

	}
	
	
	
	private void popularBancoDeDados() {
		
		Pessoa p1 = new Pessoa("Samuel", "samuel@gmail.com", LocalDate.of(1997, 5, 27), true);
		Pessoa p2 = new Pessoa("Rafael", "rafael@gmail.com", LocalDate.of(1993,2 , 8), true);
		Pessoa p3 = new Pessoa("Katielle", "katielle@gmail.com", LocalDate.of(1995,3 , 4), false);
		Pessoa p4 = new Pessoa("Irene", "irene@gmail.com", LocalDate.of(1973,5 , 5), false);
		Pessoa p5 = new Pessoa("Thaís", "thais@gmail.com", LocalDate.of(1994,11 , 3), true);
		Pessoa p6 = new Pessoa("Lucas", "lucas@gmail.com", LocalDate.of(1998,12 , 8), true);
		Pessoa p7 = new Pessoa("Allan", "allan@gmail.com", LocalDate.of(1997,11 , 8), false);
		Pessoa p8 = new Pessoa("Bruno", "bruno@gmail.com", LocalDate.of(1994,6 , 5), false);
		Pessoa p9 = new Pessoa("Gessica", "gessica@gmail.com", LocalDate.of(1992,2 , 28), false);
		Pessoa p10 = new Pessoa("Randris", "randris@gmail.com", LocalDate.of(1991,3 , 12), true);
		
		servico.salvar(p1);
		servico.salvar(p2);
		servico.salvar(p3);
		servico.salvar(p4);
		servico.salvar(p5);
		servico.salvar(p6);
		servico.salvar(p7);
		servico.salvar(p8);
		servico.salvar(p9);
		servico.salvar(p10);
	

		Endereco end1 = new Endereco("Rua 9A", "Quadra 18 C", "Cruzeiro", "Campos Belos", "GO", "73840000",p1);
		Endereco end2 = new Endereco("Rua 9A", "Quadra 18 C", "Cruzeiro", "Campos Belos", "GO", "73840000", p2);
		Endereco end3 = new Endereco("Rua 9A", "Quadra 18 C", "Cruzeiro", "Campos Belos", "GO", "73840000", p3);
		Endereco end4 = new Endereco("Rua 9A", "Quadra 18 C", "Cruzeiro", "Campos Belos", "GO", "73840000", p4);
		Endereco end5 = new Endereco("Rua 44", "Quadra 53 B", "Centro", "Urutaí", "GO", "7579000", p5);
		Endereco end6 = new Endereco("Rua 99", "Quadra 30 B", "Imperial", "Goiânia", "GO", "7547455", p6);
		Endereco end7 = new Endereco("Rua 27", "Quadra 33 A", "Centro", "Distrito Federal", "DF", "78524300", p7);
		
		
		enderecoServico.salvar(end1);
		enderecoServico.salvar(end2);
		enderecoServico.salvar(end3);
		enderecoServico.salvar(end4);
		enderecoServico.salvar(end5);
		enderecoServico.salvar(end6);
		enderecoServico.salvar(end7);
		
		
		Perfil pf1 = new Perfil("Samel Santos", "Analista", LocalDate.of(2020, 5, 3),null);
		Perfil pf2 = new Perfil("Thais Cardoso", "Modelo", LocalDate.of(2019, 1, 1),LocalDate.of(2020,01, 01));
		Perfil pf3 = new Perfil("Rafael Santos", "fisiculturista", LocalDate.of(2020, 3, 15),null);
		Perfil pf4 = new Perfil("Samel Santos", "Progamador", LocalDate.of(2019, 5, 3),LocalDate.of(2020, 12, 02));
		
		perfilServico.salvar(pf1);
		perfilServico.salvar(pf2);
		perfilServico.salvar(pf3);
		perfilServico.salvar(pf4);
		
	}

}
