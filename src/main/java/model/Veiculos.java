package model;

public class Veiculos {
	
	private Integer cod_veiculo;
	private String nome_veiculo;
	private String marca;
	private Integer ano_veiculo;
	
	
	public Veiculos(String nome_veiculo, String marca, Integer ano_veiculo) {
		super();
		this.nome_veiculo = nome_veiculo;
		this.marca = marca;
		this.ano_veiculo = ano_veiculo;
	}



	public Integer getCod_veiculo() {
		return cod_veiculo;
	}



	public void setCod_veiculo(Integer cod_veiculo) {
		this.cod_veiculo = cod_veiculo;
	}



	public String getNome_veiculo() {
		return nome_veiculo;
	}



	public void setNome_veiculo(String nome_veiculo) {
		this.nome_veiculo = nome_veiculo;
	}



	public Integer getAno_veiculo() {
		return ano_veiculo;
	}

	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setAno_veiculo(Integer ano_veiculo) {
		this.ano_veiculo = ano_veiculo;
	}



	public String toString() {
		return this.cod_veiculo + ": " +
				this.marca + ": "+
			   this.nome_veiculo + ": " +
			   this.ano_veiculo;
	}




	
}
