package com.epidataconsulting.metrics.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epidataconsulting.metrics.server.dao.PodDataDao;
import com.epidataconsulting.metrics.server.domain.PodData;

@Service
@RemotingDestination("podDataService")
public class PodDataService {

	@Autowired
	private PodDataDao podDataDao;
	
	@Transactional
	public List<PodData> retrievePodData(String dataSource, String categoryField, String valueField) throws Exception{
		try{
			return podDataDao.retrievePodData(dataSource,categoryField,valueField);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}
}
