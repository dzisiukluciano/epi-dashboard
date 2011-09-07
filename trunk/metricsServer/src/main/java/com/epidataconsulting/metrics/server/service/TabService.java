package com.epidataconsulting.metrics.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epidataconsulting.metrics.server.dao.TabDao;
import com.epidataconsulting.metrics.server.domain.Tab;


@Service
@RemotingDestination("tabService")
public class TabService {
	
	@Autowired
	private TabDao tabDao;


	@Transactional
	public List<Tab> findAllTabs() {
		List<Tab> tabs = tabDao.findAll();
		return tabs;
	}


}
