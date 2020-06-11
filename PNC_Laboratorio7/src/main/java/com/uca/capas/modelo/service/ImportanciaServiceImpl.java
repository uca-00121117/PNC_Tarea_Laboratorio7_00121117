package com.uca.capas.modelo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.uca.capas.modelo.dao.ImportanciaDAO;
import com.uca.capas.modelo.domain.Importancia;
/*
(Clase 15)-> @Service: Esta anotación le dicta a Spring que dicha clase es de Servicio, 
con lo cual se podrá manejar los métodos dentro de transacciones
*/
@Service
public class ImportanciaServiceImpl implements ImportanciaService {
	
	@Autowired
	ImportanciaDAO importanciaDAO;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		return importanciaDAO.findAll();
	}

	@Override
	public Importancia findOne(Integer c_importancia) throws DataAccessException {
		return importanciaDAO.findOne(c_importancia);
	}

}
