package dao;

import jpautil.JPAUtil;
import model.Setor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DaoGeneric<E> {
	
	// APENAS SALVA OS DADOS NO BANCO
	public void salvar(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	    
	    entityManager.persist(entidade);
	    entityTransaction.commit();
	    entityManager.close();
	}
	
	// SALVA OS DADOS E POSSIBILITA RETORNAR PARA A TELA
	public E merge(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	    
	    E retorno = entityManager.merge(entidade);
		
	    entityTransaction.commit();
	    entityManager.close();
	    
	    return retorno;
	}
	
	// REMOVE OS DADOS NO BANCO DE ACORDO COM A ENTIDADE INFORMADA
	public void delete(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	    
	    entityManager.remove(entidade);
	    
	    entityTransaction.commit();
	    entityManager.close();
	}
	
	// REMOVE OS DADOS NO BANCO DE ACORDO COM A ID INFORMADA
	public void deleteById(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	    
	    Object id = JPAUtil.getPrimaryKey(entidade);
	    entityManager.createQuery("delete from " + entidade.getClass().getCanonicalName() + " where id = " + id).executeUpdate();
	    
	    entityTransaction.commit();
	    entityManager.close();
	}
	
	// CARREGA UMA LISTA DE ENTIDADES QUE REPRESENTA UMA CONSULTA NO BANCO
	public List<E> getListEntity(Class<E> entidade){
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<E> retorno = entityManager.createQuery("from " + entidade.getName() + " order by codigo asc").getResultList();
		
	    entityTransaction.commit();
	    entityManager.close();
	    
	    return retorno;
	}

}
