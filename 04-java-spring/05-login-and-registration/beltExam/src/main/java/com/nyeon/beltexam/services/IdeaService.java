package com.nyeon.beltexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyeon.beltexam.model.Idea;
import com.nyeon.beltexam.model.User;
import com.nyeon.beltexam.repository.IdeaRepository;

@Service
public class IdeaService {
	@Autowired
	private IdeaRepository iRepo;
	
	public List<Idea> getIdeas(){
		return this.iRepo.findAll();
	}
	
	public Idea getById(Long id) {
		return this.iRepo.findById(id).orElse(null);
	}
	
	public Idea create(Idea idea) {
		return this.iRepo.save(idea);
	}
	
	public void delete(Long id) {
		this.iRepo.deleteById(id);
	}
	
	public void likeIdea(Idea idea, User user) {
		List<User> allTheLikers = idea.getLikers();
		allTheLikers.add(user);
		this.iRepo.save(idea);
	}
	
	public void unlikeIdea(Idea idea, User user) {
		List<User> allTheLikers = idea.getLikers();
		allTheLikers.remove(user);
		this.iRepo.save(idea);
	}
}
