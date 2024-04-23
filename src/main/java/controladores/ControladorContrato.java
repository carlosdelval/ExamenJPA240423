package controladores;

import javax.persistence.EntityManager;

import entidades.Contrato;

public class ControladorContrato extends SuperControladorJPA{

	public ControladorContrato() {
		super("contrato", Contrato.class);
		// TODO Auto-generated constructor stub
	}
	
	public void update(Contrato p) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
}
