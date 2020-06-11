package com.uca.capas.modelo.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.capas.modelo.domain.Contribuyente;

public interface ContribuyenteService {
	
	public List<Contribuyente> findAll() throws DataAccessException;
	
	public void save(Contribuyente c) throws DataAccessException;

}
