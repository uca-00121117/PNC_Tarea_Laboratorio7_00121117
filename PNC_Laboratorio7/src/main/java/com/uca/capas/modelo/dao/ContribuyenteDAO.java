package com.uca.capas.modelo.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.capas.modelo.domain.Contribuyente;

public interface ContribuyenteDAO {
	
	public List<Contribuyente> findAll() throws DataAccessException;
	
	public void save(Contribuyente c) throws DataAccessException;

}
