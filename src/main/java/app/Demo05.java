package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	public static void main(String[] args) {
		// eliminando ,ya habiendo obtenido los datos

		// Fabrica de de acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// Manejador de Identidad
		EntityManager em = fabrica.createEntityManager();

		// empezar los procesos....> create,delete,update,select
		em.getTransaction().begin();

		// Acciones
		// update....
		Usuario obj = em.find(Usuario.class,2);
		if (obj != null) {
			System.out.println(obj.toString());
			em.remove(obj);
			System.out.println("Se eliminó correctamente");
		}else {
			System.out.println("El codigo no existe,sorry");
		}

		// confirmacion de procesos
		em.getTransaction().commit();

		// cerrar manejador
		em.close();
	}
}
