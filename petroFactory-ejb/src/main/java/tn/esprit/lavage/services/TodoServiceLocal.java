package tn.esprit.lavage.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.lavage.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
