package com.epidataconsulting.metrics.common.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epidataconsulting.metrics.common.domain.Indicator;
import com.epidataconsulting.metrics.common.domain.IndicatorDto;
import com.epidataconsulting.metrics.common.domain.IndicatorScale;

@Repository
public class IndicatorDAO extends AbstractBusinessDAO{

	@Override
	@SuppressWarnings("rawtypes")
	public Class getClazz() {
		return Indicator.class;
	}
	
	/*
	public Indicator findByCode(String code) {
		Indicator result = null;
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Indicator.class);
		criteria.add(Restrictions.eq("code", code));
		
		result = (Indicator) criteria.uniqueResult();
		
		return result;
	}
	*/

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<IndicatorDto> searchIndicator(String indicatorTable, String indicatorCode, String valueField, String scaleTable) {
			
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		String query = 	"select i.id, i."+valueField+" as value, i.code, s.minimo, s.regular, s.bueno, s.maximo "+
						"from "+indicatorTable+" i, "+scaleTable+" s where i.indicatorscale_id = s.id and i.code ='"+indicatorCode+"'";
		
		List<IndicatorDto> result = jdbcTemplate.query(query, new RowMapper() {
			        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	IndicatorDto indicator = new IndicatorDto();
			        	IndicatorScale scale = new IndicatorScale();
			        	indicator.setCode(rs.getString("code"));
			        	indicator.setValor(rs.getDouble("value"));
			        	indicator.setId(rs.getInt("id"));
			        	scale.setBueno(rs.getDouble("bueno"));
			        	scale.setMaximo(rs.getDouble("maximo"));
			        	scale.setRegular(rs.getDouble("regular"));
			        	scale.setMinimo(rs.getDouble("minimo"));
			        	
			        	scale.calcularValores();
			        	indicator.setIndicatorscale(scale);
			            return indicator;
			        }
			    });
		
		return result;		
	}

}
