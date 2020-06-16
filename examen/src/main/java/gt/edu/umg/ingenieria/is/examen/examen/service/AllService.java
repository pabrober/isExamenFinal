package gt.edu.umg.ingenieria.is.examen.examen.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc
 */
@Transactional
@Service
public class AllService extends Exception  {   
    //Exceptions
  public AllService(){
        super("Número de elementos fuera de rango");
    }      
    
  public class PositiveNumber extends Exception {
    
    public PositiveNumber(){
        super("Los números ingresados deben ser positivos");
    }    
    }
  // end exception
    
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
 // finaliza ejercicio 6
    
//Comienzo ejecicio 8    
    @Transactional
    @Service
    public class BinarySearchTree {

        
        class Node {

            int key;
            Node left, right;

            public Node(int item) {
                key = item;
                left = right = null;
            }
        }

         
        Node root;
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> z = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
         
        BinarySearchTree() {
            root = null;
        }

         
        void insert(int key) {
            root = insertRec(root, key);
        }

        
        Node insertRec(Node root, int key) {

           
            if (root == null) {
                root = new Node(key);
                return root;
            }

           
            if (key < root.key) {
                root.left = insertRec(root.left, key);
            } else if (key > root.key) {
                root.right = insertRec(root.right, key);
            }

            /* return the (unchanged) node pointer */
            return root;
        }

         
        List<Integer> inorder() {
            return inorderRec(root);
        }

         
        List<Integer> inorderRec(Node root) {

            if (root != null) {
                inorderRec(root.left);
                x.add(root.key);    
                
                inorderRec(root.right);
                
            }
            return x;
        }

        List<Integer> preorder() {
            return preorderRec(root);
        }

        List<Integer> preorderRec(Node root) {

            if (root != null) {
                z.add(root.key);
                preorderRec(root.left);
                preorderRec(root.right);
   
            }
            return z;
        }

        List<Integer> postorder() {
            return postorderRec(root);
        }

        List<Integer> postorderRec(Node root) {

            if (root != null) {
                postorderRec(root.left);
                postorderRec(root.right);
                y.add(root.key);
   
            }
            return y;
        }


        public  HashMap<String, List<Integer>> createTree(int elements[]) throws Exception, AllService, PositiveNumber {
           if(elements.length<1 && elements.length >1000000){
           throw new AllService();
        }
            
            BinarySearchTree tree = new BinarySearchTree();
            
            
            HashMap<String, List<Integer>> search = new HashMap<String, List<Integer>>();
            
            
            for (int i = 0; i < elements.length; i++) {
                if(elements[i]<1){
                    throw new PositiveNumber();
                }
                tree.insert(elements[i]);

            }
            
            search.put("Pre Order", tree.preorder());
            search.put("In Order", tree.inorder());
            search.put("Post Order", tree.postorder());                        
            return search;

        }

    }
}

