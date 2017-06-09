package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.PreparedStatement;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {
	public void salvar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();
	}

	public void excluir(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM Fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());

		comando.executeUpdate();
	}

	public void editar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE Fabricante ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());

		comando.executeUpdate();
	}

	public Fabricante buscarPorCodigo(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM Fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());

		ResultSet resultado = comando.executeQuery();
		Fabricante retorno = null;

		if (resultado.next()) {
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		return retorno;
	}

	public ArrayList<Fabricante> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM Fabricante ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		while (resultado.next()) {
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			lista.add(f);
		}
		return lista;
	}

	public ArrayList<Fabricante> buscarPorDescricao(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM Fabricante ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + f.getDescricao() + "%");
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		
		while (resultado.next()) {
			Fabricante item = new Fabricante();
			item.setCodigo(resultado.getLong("codigo"));
			item.setDescricao(resultado.getString("descricao"));
			lista.add(item);
		}
		return lista;
	}

	public static void main(String[] args) {
		/*
		 * Fabricante f1 = new Fabricante(); f1.setDescricao("DESCRIÇÃO 1");
		 * Fabricante f2 = new Fabricante(); f2.setDescricao("DESCRICAO 2");
		 * FabricanteDAO fdao = new FabricanteDAO();
		 * 
		 * try { fdao.salvar(f1); fdao.salvar(f2);
		 * System.out.println("Dados Salvos!"); } catch (SQLException e) {
		 * e.printStackTrace(); System.out.println("Erro"); } }
		 */

		/*
		 * FabricanteDAO fdao = new FabricanteDAO(); Fabricante f1 = new
		 * Fabricante(); f1.setCodigo(1l);
		 * 
		 * Fabricante f2 = new Fabricante(); f2.setCodigo(2l);
		 * 
		 * try { fdao.excluir(f2); fdao.excluir(f1);
		 * System.out.println("Dado Excluido"); } catch (SQLException e) {
		 * e.printStackTrace(); System.out.println("Erro: "); }
		 */

		/*
		 * Fabricante f1 = new Fabricante(); f1.setCodigo(3l);
		 * f1.setDescricao("ABC"); FabricanteDAO fdao = new FabricanteDAO();
		 * 
		 * try { fdao.editar(f1); System.out.println("Dados alterdos"); } catch
		 * (SQLException e) { e.printStackTrace();
		 * System.out.println("Dados não alterados"); }
		 */

		/*
		 * Fabricante f1 = new Fabricante(); f1.setCodigo(3l); Fabricante f2 =
		 * new Fabricante(); f2.setCodigo(5l);
		 * 
		 * FabricanteDAO fdao = new FabricanteDAO();
		 * 
		 * try { Fabricante f3 = fdao.buscarPorCodigo(f1); Fabricante f4 =
		 * fdao.buscarPorCodigo(f2);
		 * 
		 * System.out.println("Resultado 1: " + f3);
		 * System.out.println("Resultado 2: " + f4); } catch (SQLException e) {
		 * e.printStackTrace(); System.out.println("Erro "); }
		 */

		/*
		 * FabricanteDAO dao = new FabricanteDAO(); try { ArrayList<Fabricante>
		 * lista = dao.listar();
		 * 
		 * for (Fabricante f : lista) { System.out.println("Resultado" + f); } }
		 * catch (SQLException e) { e.printStackTrace();
		 * System.out.println("Erro "); }
		 */
		
		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRIÇÃO");
		
		
		FabricanteDAO dao = new FabricanteDAO();
		
		
		try {
			ArrayList<Fabricante> lista = dao.buscarPorDescricao(f1);
			
			for (Fabricante f : lista) {
				System.out.println("Resultado: " + f);
			}	
		} catch (SQLException e) {
			System.out.println("Erro: ");
			e.printStackTrace();
			
		}		
	}
}
