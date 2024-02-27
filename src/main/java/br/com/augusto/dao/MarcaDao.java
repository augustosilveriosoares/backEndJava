package br.com.augusto.dao;



import javax.persistence.*;

import br.com.augusto.domain.Marca;

public class MarcaDao implements IMarcaDao {

	@Override
	public Marca cadastrar(Marca marca) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pu");
		EntityManager em = emf.createEntityManager();

		try {
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(marca);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return marca;
	}
}
