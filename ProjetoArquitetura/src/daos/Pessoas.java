package daos;

import java.util.List;
import java.util.ArrayList;

import bd.*;
import core.*;
import dbos.*;

public class Pessoas {
	
	public static void incluir(Cep cep) throws Exception
	{
		if(cep == null)
			throw new Exception("Cep não fornecidos");
		
		try 
		{
			String sql;
			sql = "insert into Cep values(?)";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setString(1, cep.getCep());
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao cadastrar cep");
		}
	}
		
	public static void alterar(Cep cep)throws Exception
	{
		if(cep == null)
			throw new Exception("Preencha todos os espaços");
		
		try 
		{
			String sql;
			sql = "update Cep set cep = ? where codCep = ?";

			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setString(1, cep.getCep());
			BDSQLServer.COMANDO.setInt(2, cep.getCodCep());
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao alterar o cep");
		}
	}
	
	public static Cep getCep(int codigo) throws Exception 
	{
		Cep cep = null;
		try 
		{
			String sql = "select * from Cep where codCep = ?";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setInt(1, codigo);
			MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
			
			if(!resultado.first())
				throw new Exception("Nao cadastrado");
			
			cep = new Cep(resultado.getInt("codCep"), resultado.getString("cep"));
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao procurar cep");
		}
		return cep;
	}
	
	public static List<Cep> selecionarCeps() throws Exception
	{
		List<Cep> ret = new ArrayList<Cep>();
		Cep cep;
		
		try 
		{
			String sql = "select * from Cep";
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
			while(resultado.next()) 
			{
				cep = new Cep(resultado.getInt("codCep"), resultado.getString("cep"));
	
				ret.add(cep);
			}
		}
		catch(Exception ex)
		{
			throw new Exception("Erro ao procurar Ceps");
		}
		
		return ret;
	}
	
	public static void excluir(int codigo) throws Exception
	{
		if(codigo <= 0)
			throw new Exception("Código de exclusão inválido");
		
		try
		{
			String sql = "delete from Cep where codCep = ?";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setInt(1, codigo);
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(Exception a)
		{
			throw new Exception("Erro ao excluir cep");
		}
		
	}
}