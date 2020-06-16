/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.is.examen.examen.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class AllService extends Exception  {   
    //Exceptions
  public AllService(){
        super("numero de elementos fuera de rango");
    }    
    
    //7-----GENETIC ALGORITHM-----START
    public Long[] genes(Long muestra) {
        //algoritmo de genes
        double propo = Math.random() * 0.9 + 0.1;
        //  canitad hombres
        Long hombres = Math.round(muestra * propo);
        //  cantidad mujeres
        Long mujeres = muestra - hombres;

        Long[] data = {hombres, mujeres};

        return data;
    }

    public HashMap<String, String> proporcionPobla(Long muestra) {
        HashMap<String, String> map = new HashMap< String, String>();
        Long[] datapro = this.genes(muestra);
        int porcentajeHombres = 0, porcentajeMujeres = 0;
        ArrayList<String> detail = new ArrayList<String>();

        if (muestra >= 1 && muestra <= 10000) {
            //porcentaje hombre
            porcentajeHombres = Math.round((datapro[0] * 100) / muestra);
            //porcentaje mujeres
            porcentajeMujeres = 100 - porcentajeHombres;

            for (int i = 0; i < datapro[0]; i++) {
                detail.add("h");
            }
            for (int j = 0; j < datapro[1]; j++) {
                detail.add("m");
            }
            Collections.shuffle(detail);

            map.put("women", Integer.toString(porcentajeMujeres) + "%");
            map.put("Detail", detail.toString());
            map.put("men", Integer.toString(porcentajeHombres) + "%");
        } else {
            map.put("error", "numero invalido");
        }
        return map;
    }
    //7-----GENETIC ALGORITHM-----END

    //Inciso 6 Hoja de excel Inicio
   public String str(int i) {
    return i < 0 ? "" : str((i / 26)-1 ) + (char)(65 + i % 26); 
   }    
    //Inciso 6 Hoja de excel Fin

    public ArrayList<String> excel(Integer repeat) throws AllService {
         ArrayList<String> letras = new ArrayList<String>();
   if(repeat <1 || repeat > 100000){
        throw new AllService();
        }
   for (int i = 0; i < repeat; ++i) {
       letras.add(this.str(i));
  }
      return letras;
    }
}

