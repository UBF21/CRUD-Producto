package app;





import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		
		//registrar un nuevo usuario
		
		//Fabrica de de acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql"); 
		
		//Manejador de Identidad
		EntityManager em = fabrica.createEntityManager();
		
		//empezar los procesos....> create,delete,update,select
		em.getTransaction().begin();
		
		//Acciones
		Usuario obj = new Usuario(32,"Felipe","galvez","felipe@gmail.com","5321","2021/05/21",2,2);
		em.persist(obj);
		
		//confirmacion de procesos
		em.getTransaction().commit();
	
			
		//cerrar manejador
		em.close();
	}
}
