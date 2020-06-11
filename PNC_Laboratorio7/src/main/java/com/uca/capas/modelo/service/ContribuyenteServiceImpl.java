package com.uca.capas.modelo.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uca.capas.modelo.dao.ContribuyenteDAO;
import com.uca.capas.modelo.domain.Contribuyente;
/*
 (Clase 15)-> @Service: Esta anotación le dicta a Spring que dicha clase es de Servicio, 
 con lo cual se podrá manejar los métodos dentro de transacciones
 */
@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {
	
	@Autowired
	ContribuyenteDAO contribuyenteDAO;
	
	@Autowired
	ImportanciaService importanciaService;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		return contribuyenteDAO.findAll();
	}
/*
 * C 15
  El método save está siendo anotado por @Transactional, 
  esto debido a que como es una operación de persistencia la que se realizará 
  (INSERT o UPDATE) Spring necesita realizarlo dentro de una Transacción, 
  caso contrario, nos lanzará una excepción mencionando que no hay Transacción en curso.
 */
	@Override
	@Transactional
	public void save(Contribuyente c) throws DataAccessException {
		c.setF_ingreso(new Date());
		c.setImportancia(importanciaService.findOne(c.getC_importancia()));
		contribuyenteDAO.save(c);	
		
	}

}
