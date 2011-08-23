package com.epidataconsulting.metrics.common.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * Clase de la cual extiende todas las clases de dominio
 * 
 */
@MappedSuperclass
public abstract class AbstractDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

	/**
	 * Devuelve el id del Objeto
	 * 
	 * @return el ID que identifica a ese objeto(usuario, perfil, etc)
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Utilizado para cargar el objeto con un ID
	 * 
	 * @param id identificador de la identidad
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 177;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * Determina si el objeto es igual al pasado como parámetro.<br>
	 * El criterio apra determinar la igualdad es comparando primero las instancias, es decir 
	 * haciendo <code>this == obj</code>, en caso de no ser iguales se compara según el id.
	 */
    @Override
	public boolean equals(Object obj) {
		boolean result=false;
		if ( obj != null ) {
			if(this == obj) {
				result=true;
			}else {
				if ( this.getClass().equals(obj.getClass())) {
					AbstractDomain otherObject = (AbstractDomain) obj;
					result= (this.getId().equals(otherObject.getId()));
				}
			}
		} return result;
	}
}
