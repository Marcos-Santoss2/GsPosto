package br.com.fiap.model;

import java.util.List;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posto {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String avaliacao;
//	private List<String> plugins;
	private Float precoKwh;
	private int starRate;
	
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	public float getPrecoKwh() {
		return precoKwh;
	}
	public void setPrecoKwh(Float precoKwh) {
		this.precoKwh = precoKwh;
	}
//	public List<String> getPlugins() {
//		return plugins;
//	}
//	public void setPlugins(List<String> plugins) {
//		this.plugins = plugins;
//	}
	public Long getStarRate() {
		return (long) starRate;
	}
	public void setStarRate(int starRate) {
		this.starRate = starRate;
	}
	
public Vector<String> getData() {
		
		Vector<String> data = new Vector<String>(); 
		data.add(id.toString());
		data.add(nome);
		data.add(rua);
		data.add(bairro);
		data.add(cidade);
		data.add(estado);
		data.add(getStarRate().toString());
		data.add(new String().valueOf(precoKwh));
	
		
		return data;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Posto [id=" + id + ", nome=" + nome + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", estado=" + estado + ", avaliacao=" + avaliacao + ", precoKwh=" + precoKwh + ", starRate="
				+ starRate + "]";
	}
	
	
	
}
