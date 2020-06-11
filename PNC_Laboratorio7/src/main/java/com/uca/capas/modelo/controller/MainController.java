package com.uca.capas.modelo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.modelo.domain.Contribuyente;
import com.uca.capas.modelo.domain.Importancia;
import com.uca.capas.modelo.service.ContribuyenteService;
import com.uca.capas.modelo.service.ImportanciaService;


@Controller
public class MainController {
	
	@Autowired
	ContribuyenteService contribuyenteService;
	
	@Autowired
	ImportanciaService importanciaService;
	
	@RequestMapping("/inicio")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		//lista de elementos que obtenemos de la base de datos
		List<Importancia> importancias = importanciaService.findAll();
		Contribuyente contribuyente = new Contribuyente();
		mav.addObject("contribuyente", contribuyente);
		mav.addObject("importancias", importancias);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/guardar")
	public ModelAndView guardar(@ModelAttribute Contribuyente c) {
		contribuyenteService.save(c);		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exito");
		return mav;
	}
	
	@RequestMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = contribuyenteService.findAll();
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("contribuyentes");
		return mav;
	}

}
