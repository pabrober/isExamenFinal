/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.is.examen.examen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import gt.edu.umg.ingenieria.is.examen.examen.service.AllService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author pc
 */

@RestController
public class AllController {
       
    @Autowired
    private AllService ser;
    //Inciso 6 Hoja de excel Inicio
      @GetMapping("/book/sheet")
        public ArrayList<String> excel(@RequestParam Integer columns) throws Exception {
        return this.ser.excel(columns);
    }
    //Inciso 6 Hoja de excel Fin
}


