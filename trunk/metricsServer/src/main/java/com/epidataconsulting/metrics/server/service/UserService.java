package com.epidataconsulting.metrics.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epidataconsulting.metrics.server.dao.UserDAO;

@Service
@RemotingDestination(value="userService")
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Transactional
	public String getDato(){
		//usuarioDAO.buscarTodos();
		return "String de prueba de comunicacion java-flex";
	}

}
