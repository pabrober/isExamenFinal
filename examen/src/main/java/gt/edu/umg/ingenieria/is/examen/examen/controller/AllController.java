/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.is.examen.examen.controller;

import gt.edu.umg.ingenieria.is.examen.examen.service.AllService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
public class AllController {
    
    @Autowired
    private AllService ser;        
    
    @PostMapping("/test")
    public Map<String, String> test() {    
    return this.ser.test();

    }
    
}

        
    
    


