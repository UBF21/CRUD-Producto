package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		// Actualizar los datos

		// Fabrica de de acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// Manejador de Identidad
		EntityManager em = fabrica.createEntityManager();

		// empezar los procesos....> create,delete,update,select
		em.getTransaction().begin();

		// Acciones
		//update....
		Usuario obj = new Usuario(71, "aaaa", "aaa", "aaa@gmail.com", "51613", "2001/10/15", 1, 1);
		
		em.merge(obj);

		// confirmacion de procesos
		em.getTransaction().commit();

		// cerrar manejador
		em.close();
	}
}
