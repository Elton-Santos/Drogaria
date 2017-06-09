package br.com.drogaria.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTeste {
	@Test	

	@org.junit.Ignore
	public void salva() throws SQLException {
		Produto p = new Produto();
		p.setDescricao("NOVALGINA COM 10 COMPRIMIDOS");
		p.setPreco(2.45);
		p.setQuantidade(13L);

		Fabricante f = new Fabricante();
		f.setCodigo(33L);

		p.setFabricante(f);

		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p);
	}

	@Test
	@org.junit.Ignore
	public void listar() throws SQLException {
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> lista = dao.listar();

		for (Produto p : lista) {
			System.out.println("Código Produto: " + p.getCodigo());
			System.out.println("Descrição: " + p.getDescricao());
			System.out.println("Preço: " + p.getPreco());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println("Código Fabricante: " + p.getFabricante().getCodigo());
			System.out.println("Nome Fabricante: " + p.getFabricante().getDescricao());
			System.out.println();
		}
	}
	
	@Test	
	@org.junit.Ignore
	public void excluir() throws SQLException{
		Produto p = new Produto();
		p.setCodigo(7L);
		
		ProdutoDAO dao =new ProdutoDAO();
		dao.excluir(p);
	}
	
	@Test
	public void deleta() throws SQLException{
		Produto p = new Produto();
		p.setCodigo(15L);
		p.setDescricao("Cataflan Pomada com 60 Gramas");
		p.setPreco(15.30);
		p.setQuantidade(20L);
	
		Fabricante f =new Fabricante();
		f.setCodigo(31L);
	
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.editar(p);
	}
}
