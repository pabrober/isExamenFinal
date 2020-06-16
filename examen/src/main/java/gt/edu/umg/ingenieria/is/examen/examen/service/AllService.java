package gt.edu.umg.ingenieria.is.examen.examen.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.springframework.transaction.annotation.Transactional;
import static java.util.Collections.reverse;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Transactional
@Service
public class AllService extends Exception {

    //Exceptions
    public AllService() {
        super("N�mero de elementos fuera de rango");
    }

    public class PositiveNumber extends Exception {

        public PositiveNumber() {
            super("Los n�meros ingresados deben ser positivos");
        }
    }
    // end exception
     
//Algoritmo de ordenamiento por selección**************************************
    public ArrayList<Long> selectSort(ArrayList<Long> elements) throws Exception, AllService {
        ArrayList<Long> listaOrdenada = null;
        if (elements.size() < 2 || elements.size() > 1000) {
            throw new AllService();
        }
        int i, j, min;
        long aux;
        for (i = 0; i < elements.size(); i++) {
            min = i;
            for (j = i + 1; j < elements.size(); j++) {
                if (elements.get(j) < elements.get(min)) {
                    min = j;
                }
            }
            aux = elements.get(i);
            elements.set(i, elements.get(min));
            elements.set(min, aux);
        }
        if (elements.size() > 1) {
            Object value = elements.remove(0);
            reverse(elements);
            elements.add((Long) value);
        }
        listaOrdenada = elements;
        return listaOrdenada;
    }
//**************************************************************************    

//Algoritmo de ordenamiento de burbuja**************************************
    public ArrayList<Long> bubbleSort(ArrayList<Long> elements) throws Exception, AllService {
        ArrayList<Long> listaOrdenada = null;
        if (elements.size() < 2 || elements.size() > 1000) {
            throw new AllService();
        }
        int i, j;
        long aux;
        for (i = 0; i < elements.size() - 1; i++) {
            for (j = 0; j < elements.size() - 1; j++) {
                if (elements.get(j) > elements.get(j + 1)) {
                    aux = elements.get(j);
                    elements.set(j, elements.get(j + 1));
                    elements.set(j + 1, aux);
                }
            }
        }
        if (elements.size() > 1) {
            Object value = elements.remove(0);
            reverse(elements);
            elements.add((Long) value);
        }
        listaOrdenada = elements;
        return listaOrdenada;
    }
//************************************************************************** 

//Algoritmo de ordenamiento de burbuja**************************************
    public ArrayList<Long> insertionSort(ArrayList<Long> elements) throws Exception, AllService {
        ArrayList<Long> listaOrdenada = null;
        if (elements.size() < 2 || elements.size() > 1000) {
            throw new AllService();
        }
        int i, j, pos;
        long aux;
        for (i = 0; i < elements.size(); i++) {
            pos = i;
            aux = elements.get(i);
            while ((pos > 0) && (elements.get(pos - 1) > aux)) {
                elements.set(pos, elements.get(pos - 1));
                pos--;
            }
            elements.set(pos, aux);
        }
        if (elements.size() > 1) {
            Object value = elements.remove(0);
            reverse(elements);
            elements.add((Long) value);
        }
        listaOrdenada = elements;
        return listaOrdenada;
    }
    //************************************************************************** 

//Algoritmo de ordenamiento de quicksort**************************************   
    public ArrayList<Long> quickSort(ArrayList<Long> elements, int primero, int ultimo) throws Exception, AllService {
        ArrayList<Long> listaOrdenada = null;
        if (elements.size() < 2 || elements.size() > 1000) {
            throw new AllService();
        }
        int i, j;
        long aux, pivote;
        i = primero;
        j = ultimo;
        pivote = elements.get((primero + ultimo) / 2);
        do {
            while (elements.get(i) < pivote) {
                i++;
            }
            while (elements.get(j) > pivote) {
                j--;
            }
            if (i <= j) {
                aux = elements.get(i);
                elements.set(i, elements.get(j));
                elements.set(j, aux);
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            quickSort(elements, primero, j);
        }
        if (i < ultimo) {
            quickSort(elements, i, ultimo);
        }
        listaOrdenada = elements;
        return listaOrdenada;
    }
    //************************************************************************** 

//Algoritmo de triangulo de pascal**************************************   
    public static int triangulo(int a, int b) {
        if (b == 0 || a == b) {
            return 1;
        } else {
            return triangulo(a - 1, b - 1) + triangulo(a - 1, b);
        }
    }

    public ArrayList<String> pascalTriangle(int nfilas) throws Exception, AllService {
        ArrayList<String> lista = new ArrayList();
        if (nfilas < 1 || nfilas > 10000) {
            throw new AllService();
        }
        int triangulo[][] = new int[nfilas][nfilas];
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j <= i; j++) {
                triangulo[i][j] = triangulo(i, j);
            }
        }
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j <= i; j++) {
                lista.add(" " + triangulo[i][j]);
            }
            int r = i + 1;
            lista.add("------Fila: " + r + " ------");
        }
        return lista;
    }
    //************************************************************************** 

    //Inciso 6 Hoja de excel Inicio---------------------------------------------
    public String str(int i) {
        return i < 0 ? "" : str((i / 26) - 1) + (char) (65 + i % 26);
    }
    //Inciso 6 Hoja de excel Fin

    public ArrayList<String> excel(Integer repeat) throws AllService {
        ArrayList<String> letras = new ArrayList<String>();
        if (repeat < 1 || repeat > 100000) {
            throw new AllService();
        }
        for (int i = 0; i < repeat; ++i) {
            letras.add(this.str(i));
        }
        return letras;
    }
    // finaliza ejercicio 6-----------------------------------------------------
    
    //7-----GENETIC ALGORITHM-----START-----------------------------------------
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
    //7-----GENETIC ALGORITHM-----END-------------------------------------------
    
    //Comienzo ejecicio 8-------------------------------------------------------   
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

        public HashMap<String, List<Integer>> createTree(int elements[]) throws Exception, AllService, PositiveNumber {
            if (elements.length < 1 && elements.length > 1000000) {
                throw new AllService();
            }

            BinarySearchTree tree = new BinarySearchTree();

            HashMap<String, List<Integer>> search = new HashMap<String, List<Integer>>();

            for (int i = 0; i < elements.length; i++) {
                if (elements[i] < 1) {
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
    //--fin ejercicio 8---------------------------------------------------------
}
