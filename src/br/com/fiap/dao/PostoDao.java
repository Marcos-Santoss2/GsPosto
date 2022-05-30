package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Posto;

public class PostoDao {

	
	EntityManager manager = JpaManager.getManager();
	
	public void inserir(Posto posto) {
			
			manager.getTransaction().begin();
			manager.persist(posto);
			manager.getTransaction().commit();
		
	}
	
	public List<Posto> listarTodos() {
		TypedQuery<Posto> query = 
				manager.createQuery("SELECT p FROM Posto p", Posto.class);
		return query.getResultList();

	}
	
	
}
