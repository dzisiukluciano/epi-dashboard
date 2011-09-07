package com.epidataconsulting.metrics.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epidataconsulting.metrics.common.dao.AbstractDomainDAO;
import com.epidataconsulting.metrics.server.domain.PodData;

@Repository
public class PodDataDao extends AbstractDomainDAO{
	
	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return PodData.class;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<PodData> retrievePodData(String dataSource, String categoryField, String valueField) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		String query = "select t."+categoryField+" as categoryField, t."+valueField+" as valueField from "+dataSource+ " t";
		
//		List<PodData> result = this.searchByQuery(query, Transformers.aliasToBean(PodData.class));	
		
		List<PodData> result = jdbcTemplate.query(query, new RowMapper() {
			        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	PodData podData = new PodData();
			        	podData.setCategoryField(rs.getString("categoryField"));
			        	podData.setValueField(rs.getDouble("valueField"));
			            return podData;
			        }
			    });
		
		return result;
	}

}
