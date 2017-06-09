package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	ArrayList<Produto> itens;
	private ArrayList<Produto> itensFiltrados;

	// Métodos getters and setters
	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	public ArrayList<Produto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}

	// Métodos gerais
	public void carregarListagem() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
}
