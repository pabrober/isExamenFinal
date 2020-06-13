package gt.edu.umg.ingenieria.is.examen.examen.controller;
import gt.edu.umg.ingenieria.is.examen.examen.service.AllService.BinarySearchTree;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllController {

    @Autowired
    private BinarySearchTree tree;

    @GetMapping("tree/binary")
    public HashMap<String, List<Integer>> addValues(@RequestParam(name = "data") int elements[])throws Exception {    
    return this.tree.createTree(elements);
     
    }

}
