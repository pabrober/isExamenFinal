/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.is.examen.examen.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class AllService {
     public class NodoArbol {
        //miembros de acceso

        NodoArbol nodoizquierdo;
        int datos;
        NodoArbol nododerecho;

        //iniciar dato y hacer de este nodo un nodo hoja
        public NodoArbol(int datosNodo) {
            datos = datosNodo;
            nodoizquierdo = nododerecho = null; //el nodo no tiene hijos
        }

        //buscar punto de insercion e inserter nodo nuevo
        public synchronized void insertar(int valorInsertar) {
            //insertar en subarbol izquierdo
            if (valorInsertar < datos) {
                //insertar en subarbol izquierdo
                if (nodoizquierdo == null) {
                    nodoizquierdo = new NodoArbol(valorInsertar);
                } else //continua recorriendo subarbol izquierdo
                {
                    nodoizquierdo.insertar(valorInsertar);
                }
            } //insertar nodo derecho
            else if (valorInsertar > datos) {
                //insertar nuevo nodoArbol
                if (nododerecho == null) {
                    nododerecho = new NodoArbol(valorInsertar);
                } else {
                    nododerecho.insertar(valorInsertar);
                }
            }
        } // fin del metodo insertar
    }

    class Arbol {

        private NodoArbol raiz;

        //construir un arbol vacio
        public Arbol() {
            raiz = null;
        }

        //insertar un nuevo ndo en el arbol de busqueda binaria
        public synchronized void insertarNodo(int valorInsertar) {
            if (raiz == null) {
                raiz = new NodoArbol(valorInsertar); //crea nodo raiz
            } else {
                raiz.insertar(valorInsertar); //llama al metodo insertar        
            }
        }

        // EMPIEZA EL RECORRIDO EN PREORDEN
        public synchronized void recorridoPreorden() {
            ayudantePreorden(raiz);
        }
        //meoto recursivo para recorrido en preorden

        private void ayudantePreorden(NodoArbol nodo) {
            if (nodo == null) {
                return;
            }

            System.out.print(nodo.datos + " ");     //mostrar datos del nodo
            ayudantePreorden(nodo.nodoizquierdo);   //recorre subarbol izquierdo
            ayudantePreorden(nodo.nododerecho);     //recorre subarbol derecho
        }

        //EMPEZAR RECORRIDO INORDEN
        public synchronized void recorridoInorden() {
            ayudanteInorden(raiz);
        }

        //meoto recursivo para recorrido inorden
        private void ayudanteInorden(NodoArbol nodo) {
            if (nodo == null) {
                return;
            }

            ayudanteInorden(nodo.nodoizquierdo);
            System.out.print(nodo.datos + " ");
            ayudanteInorden(nodo.nododerecho);
        }

        //EMPEZAR RECORRIDO PORORDEN
        public synchronized void recorridoPosorden() {
            ayudantePosorden(raiz);
        }

        //meotod recursivo para recorrido posorden
        private void ayudantePosorden(NodoArbol nodo) {
            if (nodo == null) {
                return;
            }

            ayudantePosorden(nodo.nodoizquierdo);
            ayudantePosorden(nodo.nododerecho);
            System.out.print(nodo.datos + " ");
        }
    }

    public ArrayList<Long> createBinaryTree(ArrayList<Long> elements) {

        Arbol arbol = new Arbol();

        Integer[] elementsArray = elements.toArray(new Integer[0]);
        int n = elements.size();
        for (int i = 1; i <= n; i++) {
            arbol.insertarNodo(elementsArray[i]);
        }

        System.out.println("\n\nRecorrido Preorden");
        arbol.recorridoPreorden();

        System.out.println("\n\nRecorrido Inorden");
        arbol.recorridoInorden();

        System.out.println("\n\nRecorrido Postorden");
        arbol.recorridoPosorden();

        return null;
    }
}
