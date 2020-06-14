package gt.edu.umg.ingenieria.is.examen.examen.service;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class AllService extends Exception {

    public class PositiveNumber extends Exception {
    
    public PositiveNumber(){
        super("Los números ingresados deben ser positivos");
    }
    
}
    
  public AllService(){
        super("Número de elementos fuera de rango");
    }    
    
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
           if(elements.length<1){
           throw new AllService();
        }
            
            BinarySearchTree tree = new BinarySearchTree();
            
            
            HashMap<String, List<Integer>> search = new HashMap<>();
            
            
            for (int i = 0; i < elements.length; i++) {
                if(elements[i]<1 && elements[i]>1000000 ){
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
