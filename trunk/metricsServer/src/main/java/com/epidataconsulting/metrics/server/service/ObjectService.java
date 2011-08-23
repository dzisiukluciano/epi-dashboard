
package com.epidataconsulting.metrics.server.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epidataconsulting.metrics.common.dao.IndicatorDAO;
import com.epidataconsulting.metrics.common.dao.PackageDAO;
import com.epidataconsulting.metrics.common.domain.Indicator;
import com.epidataconsulting.metrics.common.domain.Metric;
import com.epidataconsulting.metrics.common.domain.Package;

import flex.messaging.io.ArrayCollection;

@Service 
@RemotingDestination("objectService")
public class ObjectService {

	@Autowired
	private PackageDAO packDao;
	
	@Autowired
	private IndicatorDAO indicadorDao;
	
	private ArrayCollection treecol;
	private ArrayList<Indicator> indicadores;
	@Transactional
	public List<Package> getAllPackage(){
		
		return packDao.findAll();
	}
	@Transactional
	private List<Package> getAllPackage(long parentID){
		
		return packDao.findAllByParent(parentID);
	}
	
	@Transactional
	private void madeTreePack(Package parent){
		ArrayList<Package> hijos = (ArrayList<Package>) getAllPackage(parent.getPackID());
		if(hijos.size()!=0){	
			for(Package hijo : hijos){
				madeTreePack(hijo);
				insertarHijo(parent,hijo);
				
			}	
		}
	}
	@Transactional
	private Package getNodoRaiz(){
		Package pack = (Package) packDao.findAllByParent(0).get(0);
		treecol = new ArrayCollection();
		treecol.add(pack);
		return pack;
		
	}
	private void insertarHijo(Package padre ,Package hijo){
		if(padre.getchildren()== null){
			padre.createChils();
			padre.insertChild(hijo);
		}else{	
			padre.insertChild(hijo);
		}
	}
	@Transactional
	public ArrayCollection getTree(){
		
		madeTreePack(getNodoRaiz());
		List<Indicator>indicadores =  indicadorDao.findAll();
		for (Indicator indicador : indicadores){
			putIndicador(indicador);
		}
		return treecol;

	}
	private void putIndicador(Indicator indicador){
		
		for(Metric metrica : indicador.getRegla().getMetricas()){
			Package padre = getPack(treecol,metrica.getPackID() );
			if(padre!=null){
				Package hijo = new Package();
				hijo.setName(indicador.getName());
				hijo.setIndicadorid(indicador.getCode());
				if(!padre.contiene(hijo)){
					insertarHijo( padre ,hijo);
				}	
			}
		}
	}
	private Package getPack(ArrayCollection tree, long packId){
		Package result = null ;
		if(tree!=null){
			if(packId==0){
				return getNodoRaiz();
			}
			for(Object pack : tree){
				Package packaux = (Package) pack;
				
				if(packaux.getPackID() == packId){
					return packaux;
				}else{
					
						result = getPack(packaux.getchildren(),packId);
						if(result != null){
							break;
						}
				}
			}
		}
		return result ;		
	}
}
