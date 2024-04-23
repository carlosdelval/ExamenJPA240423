package controladores;

import javax.persistence.EntityManager;

import entidades.Usuario;

public class ControladorUsuario extends SuperControladorJPA{

	public ControladorUsuario() {
		super("usuario", Usuario.class);
		// TODO Auto-generated constructor stub
	}
	
	public void update(Usuario p) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}

}
