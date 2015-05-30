package com.crunchify.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.bean.Tarefa;

import dao.TarefaDAO;

@Controller
public class TarefasController {

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if(result.hasFieldErrors("descricao")) {
		    return "tarefa/formulario";
		  } 
		TarefaDAO dao = new TarefaDAO();
		dao.adiciona(tarefa);
		return "tarefa/tarefa-adicionada";

	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
	  TarefaDAO dao = new TarefaDAO();
	  model.addAttribute("tarefas", dao.lista());
	  return "tarefa/lista";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
	  TarefaDAO dao = new TarefaDAO();
	  dao.remove(tarefa);
	  return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
	  TarefaDAO dao = new TarefaDAO();
	  model.addAttribute("tarefa", dao.buscaPorId(id));
	  return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
	  TarefaDAO dao = new TarefaDAO();
	  dao.altera(tarefa);
	  return "redirect:listaTarefas";
	}
	
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model) {
	  TarefaDAO dao = new TarefaDAO();
	  dao.finaliza(id);
	  model.addAttribute("tarefa", dao.buscaPorId(id));
	  return "tarefa/finalizada";
	}
}