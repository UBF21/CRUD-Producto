package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import model.Producto;
import model.Usuario;

public class Login {

	public static void main(String[] args) {
		String usuario, clave;

		usuario = JOptionPane.showInputDialog("Ingrese el usuario");
		clave = JOptionPane.showInputDialog("Ingrese la clave");
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// Manejador de Identidad
		//EntityManager em = fabrica.createEntityManager();

		//TypedQuery<Usuario> consulta = em.createQuery("select x from Usuario x where x.usuario = :xsr and x.clave = :clave", Usuario.class);
		//consulta.setParameter("clave",clave);
		//consulta.setParameter("xsr",usuario);
		
		//Usuario obj = consulta.getSingleResult();
		
		//try {
			//System.out.println(obj);
			//System.out.println(obj.getUsuario());
			//System.out.println(obj.getClave());
		//} catch (Exception e) {
			//System.out.println("Usuario no valido");
		//}
		
		//em.close();
	}
}
