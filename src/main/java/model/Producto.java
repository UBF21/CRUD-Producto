package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter

@Entity
@Table(name = "tb_productos")
public class Producto {
	@Id
	@Column(name = "id_prod")
	private String idProducto;

	@Column(name = "des_prod")
	private String descripcion;

	@Column(name = "stk_prod")
	private int stock;

	@Column(name = "pre_prod")
	private double precio;

	@ManyToOne
	@JoinColumn(name = "idcategoria", insertable = false, updatable = false)
	private Categoria categoria;

	@Column(name = "idcategoria")
	private int idCategoria;

	@Column(name = "est_prod")
	private byte estado;

	@ManyToOne
	@JoinColumn(name = "idprovedor", insertable = false, updatable = false)
	private Proveedor proveedor;

	@Column(name = "idprovedor")
	private int idProveedor;

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", stock=" + stock + ", precio="
				+ precio + ", idCategoria=" + idCategoria + ", estado=" + estado + ", idProveedor=" + idProveedor + "]";
	}

}
