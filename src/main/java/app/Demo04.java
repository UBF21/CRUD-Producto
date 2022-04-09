package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	public static void main(String[] args) {
		// obtener un objeto segun el codigo

		// Fabrica de de acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// Manejador de Identidad
		EntityManager em = fabrica.createEntityManager();

		// empezar los procesos....> create,delete,update,select
		

		// Acciones
		
		Usuario obj2 = em.find(Usuario.class,21);
		if (obj2 != null) {
			
			System.out.println(obj2); // si existe el ID ==> devuelve el obj
		}else {
			System.out.println("El codigo no existe,sorry"); 
		}
									// si no existe el ID ==> null
		// cerrar manejador
		em.close();
	}
}
