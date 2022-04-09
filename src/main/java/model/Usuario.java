package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	@Id
	@Column(name = "cod_usua")
	private int codigoUsuario;
	@Column(name = "nom_usua")
	private String nombre;
	@Column(name = "ape_usua")
	private String apellido;
	@Column(name = "usr_usua")
	private String usuario;
	@Column(name = "cla_usua")
	private String clave;
	@Column(name = "fna_usua")
	private String fechaNaci;
	@Column(name = "idtipo")
	private int tipo;
	@Column(name = "est_usua")
	private int estado;

	public Usuario() {
		super();
	}

	public Usuario(int codigoUsuario, String nombre, String apellido, String usuario, String clave, String fechaNaci,
			int tipo, int estado) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.fechaNaci = fechaNaci;
		this.tipo = tipo;
		this.estado = estado;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getFechaNaci() {
		return fechaNaci;
	}

	public void setFechaNaci(String fechaNaci) {
		this.fechaNaci = fechaNaci;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Usuario [codigoUsuario=" + codigoUsuario + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", usuario=" + usuario + ", clave=" + clave + ", fechaNaci=" + fechaNaci + ", tipo=" + tipo
				+ ", estado=" + estado + "]";
	}

}
