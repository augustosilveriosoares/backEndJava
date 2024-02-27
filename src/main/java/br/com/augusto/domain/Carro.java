package br.com.augusto.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Carros")

public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome")
	private String nome;

	@ManyToOne
	
	
	@JoinColumn(name = "marca_id", 
	
	referencedColumnName = "id", nullable = false
)
	private Marca marca;


	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "carro_acessorio", 
        joinColumns = { @JoinColumn(name = "carro_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "acessorio_id") }
    )

	
	private List<Acessorio> acessorios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	

}
