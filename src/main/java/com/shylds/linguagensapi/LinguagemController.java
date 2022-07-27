package com.shylds.linguagensapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;

    @GetMapping("/linguagens") //traz um json 
    public List<Linguagem> obterLinguagens(){
        List<Linguagem> linguagens = repositorio.findAll() ;//recebe do db mongoDB

        return linguagens;
        
    }

    @GetMapping("/linguagem-preferida") 
    public String Algum(){
        return "olá";
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem){
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
        //return repositorio.save(linguagem);
    }

}
