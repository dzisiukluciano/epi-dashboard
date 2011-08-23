package com.epidataconsulting.metrics.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.text.StyledEditorKit.BoldAction;

import flex.messaging.io.ArrayCollection;
@Entity
@Table(name="packages")
public class Package extends  AbstractDomain{

	@Column(name="pack_id")
	long packID;
	
	@Column(name="parent_id")
	long parentID;
	
	@Column(name="name")
	String name;
	
	@Transient
	private ArrayCollection children;
	
	@Transient
	String indicadorid;

	public Package (long id){
		this.packID = id ;
	}
	public Package (String name){
		this.name = name ;
	}

	public Package() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean contiene(Package packid){
		try{
			if(children==null){
				return false;
			}else{
				
				return  children.contains(packid);		
			}
		}catch(Exception e){
			e.fillInStackTrace();
			return false ;
		}
	}

	public ArrayCollection getchildren() {
		return children;
	}
	public void setchildren(ArrayCollection childs) {
		this.children = childs;
	}
	public long getPackID() {
		return packID;
	}
	public void setPackID(long packID) {
		this.packID = packID;
	}
	public long getParentID() {
		return parentID;
	}
	public void setParentID(long parentID) {
		this.parentID = parentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIndicadorid() {
		return indicadorid;
	}
	public void setIndicadorid(String indicadorid) {
		this.indicadorid = indicadorid;
	}
	
	/**/
	public void createChils(){
		
		this.children= new ArrayCollection();
	}
	@SuppressWarnings("unchecked")
	public void insertChild(Package hijo){
		this.children.add(hijo);
	}
}
