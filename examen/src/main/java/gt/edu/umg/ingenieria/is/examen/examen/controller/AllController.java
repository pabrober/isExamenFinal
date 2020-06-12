/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.is.examen.examen.controller;

import gt.edu.umg.ingenieria.is.examen.examen.service.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
public class AllController {
    @Autowired
    public AllService ser;
    
    //7-----GENETICALGORITHM-----START
    @PostMapping("/ia")
    public int geneticalgorithm(@RequestParam Long generation) //camniar tipo para el JSON
    {
               return 0; 
    }
    //7-----GENETICALGORITHM-----END
    
    @PostMapping("/saludo")
    public String Saludo(){
       return "hola";               
    }
}

