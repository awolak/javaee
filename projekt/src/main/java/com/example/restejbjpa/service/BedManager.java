package com.example.restejbjpa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Bed;
import com.example.restejbjpa.domain.Book;
import com.example.restejbjpa.domain.Producer;
import com.example.restejbjpa.domain.Person;
import com.example.restejbjpa.domain.Type;
import com.example.restejbjpa.domain.Pillow;


@Singleton
public class BedManager {
	//private List<Bed> db = Collections.synchronizedList(new ArrayList<>());
	public static Long id =(long) 1;
	@PersistenceContext
	EntityManager em;
	
	public void addBed(Bed bed){	
		//bed.setId(id++);
		em.persist(bed);
	}
	
	public Bed getBed(Long id){
		Bed retrieved = em.find(Bed.class, id);
		return retrieved;
	}
	
	public void addPillow(Pillow pillow){	
		//bed.setId(id++);
		em.persist(pillow);
	}
	
	public Pillow getPillow(Long id){
		Pillow retrieved = em.find(Pillow.class, id);
		return retrieved;
	}
	
	public void addType(Type type){	
		//bed.setId(id++);
		em.persist(type);
	}
	
	public Type getType(Long id){
		Type retrieved = em.find(Type.class, id);
		return retrieved;
	}
	
	public void addProducer(Producer producer){	
		//bed.setId(id++);
		em.persist(producer);
	}
	
	public Producer getProducer(Long id){
		Producer retrieved = em.find(Producer.class, id);
		return retrieved;
	}

//	public List<Person> getAuthorsOfBook(Long id){
//		Book retrieved = em.find(Book.class, id);
//		List<Person> result = new ArrayList<>(retrieved.getAuthors());
//		return result;
//	}
		
//	@SuppressWarnings("unchecked")
//	public List<Object[]> getBookOfAuthrByAuthorName(String firstName){		
//		return em.createNamedQuery("bookAuthor.findByAthorFirstName").setParameter("firstName", firstName).getResultList();
//	}
	
	@SuppressWarnings("unchecked")
	public List<Bed> getAllBeds(){
		return em.createNamedQuery("bed.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pillow> getAllPillows(){
		return em.createNamedQuery("pillow.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Type> getAllTypes(){
		return em.createNamedQuery("type.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Producer> getAllProducers(){
		return em.createNamedQuery("producer.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> findByCountOfSheets(int count){
		return em.createNamedQuery("bed.findByCountOfSheets").setParameter("countOfSheets", count).getResultList();
	}
	
	//znajduje producenta, ktory oferuje najwieksza liczbe przescieradel
	public Producer findMostColorfullProducer(){
		List<Producer> producers = new ArrayList<>();  
		producers = getAllProducers();
		int max = 0;
		Long id = (long) 1;
		for(Producer o : producers) {
			for(Bed b: o.getBeds()) {
				if(b.getCountOfSheets()>max) {
					max = b.getCountOfSheets();
					id = o.getId();
				}
			}
		}
		return em.find(Producer.class, id);
	}
	
	//znajduje wlasciciela, ktory ma najwiecej ptasich zabawek
		public Producer findManyPillows(){
			List<Producer> producers = new ArrayList<>();  
			producers = getAllProducers();
			int max = 0, local = 0;
			Long id = (long) 1;
			for(Producer o : producers) {
				local = 0;
				for(Bed b: o.getBeds()) {
					local += b.getPillows().size();
				}
				if(local>max) {
					id = o.getId();
					max = local;
				}
			}
			return em.find(Producer.class, id);
		}
		
		//znajduje wszystkich wlascicieli, ktorzy maja wiecej niz n zabawek
		public List<Producer> findManyPillows(int n){
			List<Producer> many = new ArrayList<>(); 
			List<Producer> producers = new ArrayList<>();  
			producers = getAllProducers();
			for(Producer o : producers) {
				int count = 0;
				for(Bed b: o.getBeds()) {
					count += b.getPillows().size();
				}
				if(count>n) {
					many.add(o);
				}
			}
			return many;
		}
	
	public void deletAllBeds(){
		em.createNamedQuery("bed.delete.all").executeUpdate();
	}

	public void deletAllPillows(){
		em.createNamedQuery("pillow.delete.all").executeUpdate();
	}
	
	public void deletAllTypes(){
		em.createNamedQuery("type.deleteAll").executeUpdate();
	}
	
	public void deletAllProducers(){
		em.createNamedQuery("producer.deleteAll").executeUpdate();
	}
	
}
