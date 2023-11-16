package entities;

public class Cidade {

	private String nomeCidade;
	private int codCidade;
	private int qtdAcidentes;

	public Cidade() {

	}

	public Cidade(String nomeCidade, int codCidade, int qtdAcidentes) {
		this.nomeCidade = nomeCidade;
		this.codCidade = codCidade;
		this.qtdAcidentes = qtdAcidentes;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public int getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(int codCidade) {
		this.codCidade = codCidade;
	}

	public int getQtdAcidentes() {
		return qtdAcidentes;
	}

	public void setQtdAcidentes(int qtdAcidentes) {
		this.qtdAcidentes = qtdAcidentes;
	}

	public String toString() {
		return nomeCidade;
	}
}
