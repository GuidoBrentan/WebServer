package dbos;

public class ProgramaTeste {
	public static void main(String args[])
	{
		try 
		{
			Pessoa a = new Pessoa("Guilherme Brentan", "19 9 7146-4304", "13345720", 53, "null");
			
			System.out.println(a);
		}
		catch(Exception a)
		{
			System.err.println(a.getMessage());
		}
	}
}
