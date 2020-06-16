package gt.edu.umg.ingenieria.is.examen.examen.controller;

import gt.edu.umg.ingenieria.is.examen.examen.service.AllService.BinarySearchTree;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import gt.edu.umg.ingenieria.is.examen.examen.service.AllService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author pc
 */

@RestController
public class AllController {
    
    @Autowired
    private AllService ser;  
    @Autowired
    private BinarySearchTree tree;
        
    
     //7-----GENETIC ALGORITHM-----START
    @GetMapping("/ia")
    public Map<String, String> geneticalgorithm(@RequestParam Long generation) {    
    return this.ser.proporcionPobla(generation);
    }
    //7-----GENETIC ALGORITHM-----END
           
    //Inciso 6 Hoja de excel Inicio
     @GetMapping("/book/sheet")
       public ArrayList<String> excel(@RequestParam Integer columns) throws Exception {
       return this.ser.excel(columns);
       }  
    //Inciso 6 Hoja de excel fin
       
     //ejercicio 7  inicio
    @GetMapping("tree/binary")
    public HashMap<String, List<Integer>> addValues(@RequestParam(name = "data") int elements[])throws Exception {    
    return this.tree.createTree(elements);     
    }
    //ejercicio 7  fin

}
