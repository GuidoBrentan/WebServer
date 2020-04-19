package daos;

import java.util.List;
import java.util.ArrayList;

import bd.*;
import core.*;
import dbos.*;

public class Pessoas {

	
	public static void incluir(Pessoa pessoa) throws Exception
	{
		if(pessoa == null)
			throw new Exception("pessoa não fornecida");
		
		try 
		{
			String sql;
			sql = "insert into Pessoa values(?, ?, ?, ?, ?)";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setString(1, pessoa.getNome());
			BDSQLServer.COMANDO.setString(2, pessoa.getTelefone());
			BDSQLServer.COMANDO.setString(3, pessoa.getCep());
			BDSQLServer.COMANDO.setInt	 (4, pessoa.getNumero());
			BDSQLServer.COMANDO.setString(5, pessoa.getComplemento());
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao cadastrar cep");
		}
	}
		
	public static void alterar(Pessoa pessoa)throws Exception
	{
		if(pessoa == null)
			throw new Exception("Não há pessoa para alterar");
		
		try 
		{
			String sql;
			sql = "update Pessoa set nome = ?, telefone = ?, cep = ?, numero = ?, complemento = ? where codPessoa = ?";

			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setString(1, pessoa.getNome());
			BDSQLServer.COMANDO.setString(2, pessoa.getTelefone());
			BDSQLServer.COMANDO.setString(3, pessoa.getCep());
			BDSQLServer.COMANDO.setInt   (4, pessoa.getNumero());
			BDSQLServer.COMANDO.setString(5, pessoa.getComplemento());
			BDSQLServer.COMANDO.setInt	 (6, pessoa.getCodPessoa());
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao alterar a pessoa");
		}
	}
	
	public static Pessoa getPessoa(int codigo) throws Exception 
	{
		Pessoa pessoa = null;
		try 
		{
			String sql = "select * from Pessoa where codPessoa = ?";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setInt(1, codigo);
			MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
			
			if(!resultado.first())
				throw new Exception("Nao cadastrado");
			
			pessoa = new Pessoa(resultado.getInt("codPessoa"), resultado.getString("nome"), resultado.getString("telefone"), 
								resultado.getString("cep"), resultado.getInt("numero"), resultado.getString("complemento"));
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao procurar pessoa");
		}
		return pessoa;
	}
	
	public static List<Pessoa> getPessoas() throws Exception
	{
		List<Pessoa> ret = new ArrayList<Pessoa>();
		Pessoa pessoa;
		
		try 
		{
			String sql = "select * from Pessoa";
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
			while(resultado.next()) 
			{
				pessoa = new Pessoa(resultado.getInt("codPessoa"), resultado.getString("nome"), 
									resultado.getString("telefone"), resultado.getString("cep"),
									resultado.getInt("numero"),	resultado.getString("complemento"));
	
				ret.add(pessoa);
			}
		}
		catch(Exception ex)
		{
			throw new Exception("Erro ao procurar Pessoas");
		}
		
		return ret;
	}
	
	public static void excluir(int codigo) throws Exception
	{
		if(codigo <= 0)
			throw new Exception("Código de exclusão inválido");
		
		try
		{
			String sql = "delete from Pessoa where codPessoa = ?";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setInt(1, codigo);
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(Exception a)
		{
			throw new Exception("Erro ao excluir pessoa");
		}
		
	}
}