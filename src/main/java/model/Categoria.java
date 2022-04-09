package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	
	@Id
	@Column(name = "idcategoria")
	private int idcategoria;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	
	public Categoria() {
		super();
	}


	public Categoria(String descripcion, int idcategoria) {
		super();
		this.descripcion = descripcion;
		this.idcategoria = idcategoria;
	}


	
	

	
	
	
}
