package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo3 {
	public static void main(String[] args) {
		// eliminar los datos

		// Fabrica de de acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// Manejador de Identidad
		EntityManager em = fabrica.createEntityManager();

		// empezar los procesos....> create,delete,update,select
		em.getTransaction().begin();

		// Acciones
		// forma 1 = borrado fisico
		//forma 2 = update del estado o campo donde el codigo coincida....borrado logico
		// delete....where....codigo
		Usuario obj = new Usuario();
		obj.setCodigoUsuario(2);
		obj.setNombre("Zoila");
		obj.setApellido("Baca");
		obj.setUsuario("U002@gmail.com");
		obj.setClave("41424");
		obj.setFechaNaci("2022-03-22");
		obj.setTipo(2);
		obj.setEstado(1);
		em.remove(obj); //necesitamos pasar un objeto con todos los campos

		// confirmacion de procesos
		em.getTransaction().commit();

		// cerrar manejador
		em.close();

	}
}
