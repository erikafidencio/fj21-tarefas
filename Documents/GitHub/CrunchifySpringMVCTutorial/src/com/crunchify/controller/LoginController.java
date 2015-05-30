package com.crunchify.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.bean.Usuario;

import dao.UsuarioDAO;

@Controller
public class LoginController{
    
  @RequestMapping("loginForm")
  public String loginForm() {
    return "formulario-login";
  }
  
  @RequestMapping("efetuaLogin")
  public String efetuaLogin(Usuario usuario, HttpSession session) {
    if(new UsuarioDAO().existeUsuario(usuario)) {
      session.setAttribute("usuarioLogado", usuario);
      return "menu";
    }
    return "redirect:loginForm";
  }

  @RequestMapping("logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:loginForm";
  }
  
  
}

