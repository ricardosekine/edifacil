package br.com.edifacil.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.edifacil.service.TesteService;

@Controller
public class MainController {

	@Autowired
	private TesteService testeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(){
		this.testeService.teste("Testandddooooo");
		System.out.println("Entrou");
		return "main/index";
	}
	
}