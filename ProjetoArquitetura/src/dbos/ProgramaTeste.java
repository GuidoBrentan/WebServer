package dbos;

public class ProgramaTeste {
	public static void main(String args[])
	{
		try
		{
			Cep cep1 = new Cep("13345720");
			cep1.setCodCep(4);
			
			Cep cep2 = new Cep(3, "13325678");
			Cep cep3 = new Cep("13345720");
			
			Cep cep4 = (Cep)cep1.clone();
			
			System.out.println(cep1);
			System.out.println(cep2);
			System.out.println(cep1.equals(cep2));
			System.out.println(cep1.equals(cep3));
			System.out.println(cep1.equals(cep1));
			System.out.println(cep1.equals(cep4));
			System.out.println(cep1.hashCode());
			System.out.println(cep4.hashCode());
		}
		catch(Exception a)
		{
			System.err.println(a.getMessage());
		}
		
	}

}
