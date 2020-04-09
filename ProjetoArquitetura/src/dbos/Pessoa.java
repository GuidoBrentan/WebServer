package dbos;

public class Pessoa {
	private String nome, telefone, cep, complemento;
	private int numero, codPessoa;
	
	public Pessoa (String nome, String telefone, String cep, int numero, String complemento) throws Exception
	{
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setCep(cep);
		this.setNumero(numero);
		this.setComplemento(complemento);
	}
	
	public Pessoa (int codPessoa, String nome, String telefone, String cep, int numero, String complemento) throws Exception
	{
		this.setCodPessoa(codPessoa);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setCep(cep);
		this.setNumero(numero);
		this.setComplemento(complemento);
	}
	
	public void setCodPessoa(int codPessoa) throws Exception
	{
		if(codPessoa <= 0)
			throw new Exception("codPessoa inválido!");
		
		this.codPessoa = codPessoa;
	}
	
	public void setNome(String nome) throws Exception
	{
		if(nome == null || nome.length() > 50)
			throw new Exception("nome inválido!");
		
		this.nome = nome;
	}
	
	public void setTelefone(String telefone) throws Exception
	{
		if(telefone == null || telefone.length() > 15)
			throw new Exception("telefone inválido!");
		
		this.telefone = telefone;
	}
	
	public void setCep(String cep) throws Exception
	{
		if(cep == null || cep.length() > 8 || !ehCep(cep))
			throw new Exception("cep inválido!");
		
		this.cep = cep;
	}
	
	public void setNumero(int numero) throws Exception
	{
		if(numero <= 0)
			throw new Exception("numero inválido!");
		
		this.numero = numero;
	}
	
	public void setComplemento(String complemento) throws Exception
	{
		if(complemento == null || complemento.length() > 20)
			throw new Exception("complemento inválido!");
	}
	
	public int getCodPessoa()
	{
		return this.codPessoa;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public String getTelefone()
	{
		return this.telefone;
	}
	
	public String getCep()
	{
		return this.cep;
	}
	
	public int getNumero()
	{
		return this.numero;
	}
	
	public String getComplemento()
	{
		return this.complemento;
	}
	
	private boolean ehCep(String cep)
	{
		if(cep.length() > 8)
			return false;
		
		for(byte i = 0; i < 7; i++)
			if(!Character.isDigit(cep.charAt(i)))
				return false;
		
		return true;
	}
	
	public String toString()
	{
		String ret;
		
		ret = "| Codigo: " + this.codPessoa + " | Nome:  " + this.nome + " | Telefone: " + this.telefone + 
			 " | CEP: " + this.cep + " | Numero: " + this.numero + " | Complemento: " + this.complemento + " |";
		
		return ret;
	}
	
	public boolean equals(Object x)
	{
		if(x == null)
			return false;
		
		if(x == this)
			return true;
		
		if(x.getClass() != this.getClass())
			return false;
		
		Pessoa pes = (Pessoa) x;
		
		if(pes.codPessoa != this.codPessoa || pes.nome != this.nome || 
			pes.telefone != this.telefone || pes.cep != this.cep ||
			pes.numero != this.numero || pes.complemento != this.complemento)
			return false;
		
		return true; 
	}
	
	public int hashCode()
	{
		int ret = 666;
		
		ret = ret * 7 + new Integer(this.codPessoa).hashCode();
		ret = ret * 7 + this.nome.hashCode();
		ret = ret * 7 + this.telefone.hashCode();
		ret = ret * 7 + this.cep.hashCode();
		ret = ret * 7 + new Integer(this.numero).hashCode();
		ret = ret * 7 + this.complemento.hashCode();
		
		if(ret < 0)
			ret = -ret;
		
		return ret;
	}
	
	public Object clone()
	{
		Pessoa ret = null;
		
		try
		{
			ret = new Pessoa(this);
		}
		catch(Exception a)
		{}
		
		return ret;
	}
	
	public Pessoa (Pessoa modelo) throws Exception
	{
		if(modelo == null)
			throw new Exception("modelo invalido");
		
		this.codPessoa = modelo.codPessoa;
		this.nome = modelo.nome;
		this.telefone = modelo.telefone;
		this.cep = modelo.cep;
		this.numero = modelo.numero;
		this.complemento = modelo.complemento;
	}
}










