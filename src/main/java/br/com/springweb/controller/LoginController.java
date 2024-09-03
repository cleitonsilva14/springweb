package br.com.springweb.controller;

import br.com.springweb.models.Administrador;
import br.com.springweb.repositorio.AdministradoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/login")
    public String index(){
        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, Administrador admParam, String lembrar){

        Administrador adm = this.repo.Login(admParam.getEmail(), admParam.getSenha());
        System.out.printf("%s - %s\n",admParam.getEmail(), admParam.getSenha());
        System.out.println(adm);
        if(adm != null){
            return "redirect:/";
        }

        model.addAttribute("erro", "Usuário ou senha inválidos");

        return "login/index";
    }

}
