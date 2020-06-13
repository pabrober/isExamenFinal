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
import java.util.Map;

/**
 * @author pc
 */
@RestController
public class AllController {
    
    @Autowired
    private AllService ser;        
    
     //7-----GENETIC ALGORITHM-----START
    @PostMapping("/ia")
    public Map<String, String> geneticalgorithm(@RequestParam Long generation) {    
    return this.ser.proporcionPobla(generation);
    }
           
    //7-----GENETIC ALGORITHM-----END
    
}
