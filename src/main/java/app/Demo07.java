package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo07 {
	public static void main(String[] args) {
		// listado de la tabla usuarios

		// Fabrica de de acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// Manejador de Identidad
		EntityManager em = fabrica.createEntityManager();

		
		// Acciones
		// select * from usuarios....
		TypedQuery<Usuario> consulta = em.createQuery("select x from Usuario x where x.tipo = :tipo", Usuario.class); 
		consulta.setParameter("tipo", 2);
		List<Usuario> listaUsuarios = consulta.getResultList();

		for(Usuario obj : listaUsuarios) {
			System.out.println(obj.toString());
		}
		// cerrar manejador
		em.close();
	}
}
