/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.is.examen.examen.controller;

import gt.edu.umg.ingenieria.is.examen.examen.service.AllService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
public class AllController {
    
   @Autowired 
   private AllService allServices;
         
    @RequestMapping(value="tree/binary", method=RequestMethod.GET)
    public long[] addBinaryTree(@RequestParam(name = "data") int[] arr){
    return null;
    }
}

