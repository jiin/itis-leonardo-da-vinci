package iti.note.test;

import iti.note.model.Nota;
import iti.note.model.Taccuino;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myFirstPersistenceUnit");
		
		EntityManager em = emf.createEntityManager();
		
		Taccuino taccuino = new Taccuino("Il mio taccuino persistente");
		Nota nota = new Nota("La mia nota persistente");
		taccuino.addNota(nota);

		em.getTransaction().begin();
		
		em.persist(taccuino);

		em.getTransaction().commit();
	}
}