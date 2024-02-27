package br.com.augusto.domain;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Acessorios")
public class Acessorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "descricao")
	private String descricao;
	
	
	@ManyToMany(mappedBy = "acessorios")
    private List<Carro> carros;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Carro> getCarros() {
		return carros;
	}
	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	
	

}
