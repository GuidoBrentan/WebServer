package dbos;

public class ProgramaTeste {
	public static void main(String args[])
	{
		try 
		{
			Pessoa a = new Pessoa(1, "Guilherme Brentan", "19 9 7146-4304", "13345720", 53, "");
			Pessoa b = new Pessoa(2, "Guilherme Brentan", "19 9 7146-4304", "13345720", 53, "");
			
			System.out.println(a.equals(b));
			System.out.println(a.hashCode());
		}
		catch(Exception a)
		{
			System.err.println(a.getMessage());
		}
	}
}
