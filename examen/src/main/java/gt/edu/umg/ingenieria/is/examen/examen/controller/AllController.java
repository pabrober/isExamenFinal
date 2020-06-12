package gt.edu.umg.ingenieria.is.examen.examen.controller;
import gt.edu.umg.ingenieria.is.examen.examen.service.AllService;
import java.util.ArrayList;
import static java.util.Collections.reverse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllController {
    
     @Autowired
    public AllService allServices;
    
    @RequestMapping(value="selectSort/{elements}", method=RequestMethod.GET)
    public ArrayList<Long> selectSort(@PathVariable ArrayList<Long> elements) throws Exception{
    return this.allServices.selectSort(elements);
    }
    
    @RequestMapping(value="bubbleSort/{elements}", method=RequestMethod.GET)
    public ArrayList<Long> bubbleSort(@PathVariable ArrayList<Long> elements) throws Exception{
    return this.allServices.bubbleSort(elements);
    }
    
    @RequestMapping(value="insertionSort/{elements}", method=RequestMethod.GET)
    public ArrayList<Long> insertionSort(@PathVariable ArrayList<Long> elements) throws Exception{
    return this.allServices.insertionSort(elements);
    }
    
    @RequestMapping(value="quickSort/{elements}", method=RequestMethod.GET)
    public ArrayList<Long> quickSort(@PathVariable ArrayList<Long> elements) throws Exception{
        ArrayList<Long> aux = this.allServices.quickSort(elements,0,elements.size()-1);
        if(aux.size() > 1) {                   
            Object value = aux.remove(0);
            reverse(aux);
            aux.add((Long) value);
        }      
      return aux;  
    }
}

