package jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory;

	// CRIA O FACTORY PARA A PERSISTÊNCIA NO BANCO DE ACORDO COM AS CONFIGURAÇÕES DO "persistence.xml"
	static {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("sitegerenciamentoplantio");
		}
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static Object getPrimaryKey(Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}
}
