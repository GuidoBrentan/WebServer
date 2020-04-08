package daos;

import dbos.*;

public class ProgramaTeste {
	public static void main(String args[])
	{
		try
		{
			Cep cep1 = new Cep ("13345720");
			Cep cep2 = new Cep ("13345720");
			Cep cep3 = new Cep ("13345720");
			Cep cep4 = new Cep ("13345720");
			Cep cep5 = new Cep ("13345720");
			
			Ceps.incluir(cep1);
			Ceps.incluir(cep2);
			Ceps.incluir(cep3);
			Ceps.incluir(cep4);
			Ceps.incluir(cep5);
			
			System.out.println(Ceps.selecionarCeps());
			
			Ceps.excluir(10);
			Ceps.excluir(9);
			
			System.out.println(Ceps.selecionarCeps());
			System.out.println(Ceps.getCep(7));
		}
		catch(Exception a)
		{
			System.err.println(a.getMessage());
		}
	}

}
