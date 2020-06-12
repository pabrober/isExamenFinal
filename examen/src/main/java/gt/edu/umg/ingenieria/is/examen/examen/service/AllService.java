/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.is.examen.examen.service;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Service;


/**
 *
 * @author pc
 */
@Service
public class AllService {
    
     public HashMap<String, String> test (){
        HashMap<String, String> map = new HashMap<>();
        int a = 45, b=60,c=150;        
        ArrayList<String> array1 = new ArrayList<String>();
        for (int i=1; i<=10; i++){
	array1.add("Elemento "+i); 
        }
        map.put("man", Integer.toString(a)+"%" );
        map.put("woman", Integer.toString(b)+"%" );
        map.put("lista", array1.toString());
        return map;
    }    
        
}
