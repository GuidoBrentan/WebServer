package daos;


public class ProgramaTeste {
	public static void main(String args[])
	{
		try 
		{
			System.out.println(Pessoas.getPessoa(14));
			
		}
		catch(Exception a)
		{
			System.err.println(a.getMessage());
		}
	}
}
