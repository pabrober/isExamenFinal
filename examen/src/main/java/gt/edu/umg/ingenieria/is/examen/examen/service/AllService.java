/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.is.examen.examen.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllService extends Exception  {
  //Exceptions
  public AllService(){
        super("Número de elementos fuera de rango");
    }    
 //Inciso 6 Hoja de excel Inicio
   public String str(int i) {
    return i < 0 ? "" : str((i / 26)-1 ) + (char)(65 + i % 26); 
}
  public ArrayList<String> excel(Integer repeat) throws Exception, AllService{
   ArrayList<String> letras = new ArrayList<String>();
   if(repeat <1 || repeat > 100000){
        throw new AllService();
        }
   for (int i = 0; i < repeat; ++i) {
       letras.add(this.str(i));
  }
      return letras;
  }
//Inciso 6 Hoja de excel Fin
}