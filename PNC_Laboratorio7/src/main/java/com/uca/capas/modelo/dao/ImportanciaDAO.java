package com.uca.capas.modelo.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.capas.modelo.domain.Importancia;


public interface ImportanciaDAO {
	
	public List<Importancia> findAll() throws DataAccessException;
	
	public Importancia findOne(Integer cimportancia) throws DataAccessException;

}
