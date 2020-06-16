package gt.edu.umg.ingenieria.is.examen.examen.controller;

import gt.edu.umg.ingenieria.is.examen.examen.service.AllService.BinarySearchTree;
import java.util.HashMap;
import static java.util.Collections.reverse;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @Autowired
    public AllService allServices;        
       
    //INICIO Controladores de los primeros 5 casos de uso ******************************************************* 
    @RequestMapping(value = "selectSort/{elements}", method = RequestMethod.GET)
    public ArrayList<Long> selectSort(@PathVariable ArrayList<Long> elements) throws Exception {
        return this.allServices.selectSort(elements);
    }

    @RequestMapping(value = "bubbleSort/{elements}", method = RequestMethod.GET)
    public ArrayList<Long> bubbleSort(@PathVariable ArrayList<Long> elements) throws Exception {
        return this.allServices.bubbleSort(elements);
    }

    @RequestMapping(value = "insertionSort/{elements}", method = RequestMethod.GET)
    public ArrayList<Long> insertionSort(@PathVariable ArrayList<Long> elements) throws Exception {
        return this.allServices.insertionSort(elements);
    }

    @RequestMapping(value = "quickSort/{elements}", method = RequestMethod.GET)
    public ArrayList<Long> quickSort(@PathVariable ArrayList<Long> elements) throws Exception {
        ArrayList<Long> aux = this.allServices.quickSort(elements, 0, elements.size() - 1);
        if (aux.size() > 1) {
            Object value = aux.remove(0);
            reverse(aux);
            aux.add((Long) value);
        }
        return aux;
    }

    @RequestMapping(value = "pascalTriangle/{elements}", method = RequestMethod.GET)
    public List<String> pascalTrian5gle(@PathVariable int nfilas) throws Exception {
        return this.allServices.pascalTriangle(nfilas);
    }

    @GetMapping("/pascalTriangle")
    public ArrayList<String> pascalTriangle(@RequestParam(name = "levels") int nfilas) throws Exception {
        return this.allServices.pascalTriangle(nfilas);
    }
    //FIN Controladores de los primeros 5 casos de uso *******************************************************
    
    //Inciso 6 Hoja de excel Inicio
    @GetMapping("/book/sheet")
    public ArrayList<String> excel(@RequestParam Integer columns) throws Exception {
        return this.ser.excel(columns);
    }
    //Inciso 6 Hoja de excel fin
    
    //7-----GENETIC ALGORITHM-----START
    @GetMapping("/ia")
    public Map<String, String> geneticalgorithm(@RequestParam Long generation) {
        return this.ser.proporcionPobla(generation);
    }
    //7-----GENETIC ALGORITHM-----END
    
    //ejercicio 8 inicio
    @GetMapping("tree/binary")
    public HashMap<String, List<Integer>> addValues(@RequestParam(name = "data") int elements[]) throws Exception {
        return this.tree.createTree(elements);
    }
    //ejercicio 8 fin
}
