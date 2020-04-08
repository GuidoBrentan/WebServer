package dbos;

public class Cep {
	
	private String cep;
	private int codCep;
	
	public Cep (String cep) throws Exception
	{
		this.setCep(cep);
	}
	
	public Cep(int codCep, String cep) throws Exception
	{
		this.setCep(cep);
		this.setCodCep(codCep);
	}
	
	public void setCep(String cep) throws Exception
	{
		if(!ehCep(cep))
			throw new Exception("cep inválido!");
		
		this.cep = cep;
	}
	
	public void setCodCep(int codCep) throws Exception
	{
		if(codCep <= 0)
			throw new Exception("codCep inválido!");
		
		this.codCep = codCep;
	}
	
	public String getCep()
	{
		return this.cep;
	}
	
	public int getCodCep()
	{
		return this.codCep;
	}
	
	private boolean ehCep(String cep)
	{
		if(cep.length() != 8)
			return false;
		
		for(byte i = 0; i <= 7 ; i++)
			if(!Character.isDigit(cep.charAt(i)))
				return false;
		
		return true;
	}
	
	/////////////////////////////////////////Métodos Obrigatórios/////////////////////////////////////////
	
	public String toString()
	{
		String ret;
		
		ret = "Codigo: " + this.codCep + " | Cep: " + this.cep;
		
		return ret;
	}
	
	public boolean equals(Object x)
	{
		if(x == this)
			return true;
		
		if(x == null)
			return false;
		
		if(x.getClass() != this.getClass())
			return false;

		Cep c = (Cep) x;
		
		if(c.cep != this.cep)
			return false;
		
		if(c.codCep != this.codCep)
			return false;
		
		return true;
	}
	
    public Object clone()
    {
        Cep ret = null;
        try
        {
            ret = new Cep(this);
        }
        catch(Exception err)
        {}

        return ret;
    }

    public Cep (Cep modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("modelo vazio");

        this.cep = modelo.cep;
        this.codCep = modelo.codCep;
    }
    
    public int hashCode()
    {
    	int ret = 256;
    	
    	ret = ret * 7 + this.cep.hashCode();
    	ret = ret * 7 + new Integer(this.codCep).hashCode();
    	
    	return ret;
    }
}










