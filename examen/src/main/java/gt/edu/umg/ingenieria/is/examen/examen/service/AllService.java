/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.is.examen.examen.service;

import java.util.ArrayList;
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
public class AllService {

    @Transactional
    @Service
    public class BinarySearchTree {

        /* Class containing left and right child of current node and key value*/
        class Node {

            int key;
            Node left, right;

            public Node(int item) {
                key = item;
                left = right = null;
            }
        }

        // Root 
        Node root;
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> z = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
        // Constructor 
        BinarySearchTree() {
            root = null;
        }

        // This method mainly calls insertRec() 
        void insert(int key) {
            root = insertRec(root, key);
        }

        /* A recursive function to insert a new key in BT */
        Node insertRec(Node root, int key) {

            /* If the tree is empty, return a new node */
            if (root == null) {
                root = new Node(key);
                return root;
            }

            /* Otherwise, recur down the tree */
            if (key < root.key) {
                root.left = insertRec(root.left, key);
            } else if (key > root.key) {
                root.right = insertRec(root.right, key);
            }

            /* return the (unchanged) node pointer */
            return root;
        }

        // This method mainly calls InorderRec() 
        List<Integer> inorder() {
             return inorderRec(root);
        }

        // A utility function to do inorder traversal of BT 
        List<Integer> inorderRec(Node root) {
            
            
            if (root != null) {
                inorderRec(root.left);
                x.add(root.key);    
                //System.out.println(root.key);
                inorderRec(root.right);
                //return map;
            }
           return x;
        }

        List<Integer> preorder() {
            return preorderRec(root);
        }

        List<Integer> preorderRec(Node root) {
            
            if (root != null) {
                z.add(root.key);
                //System.out.print(" \n" + root.key);
                preorderRec(root.left);
                preorderRec(root.right);
                //return map;
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
                //System.out.print(" \n" + root.key);
                
            //return map;
            }
            return y;
        }

        // Driver Program to test above functions 
        public  HashMap<String, List<Integer>> main(int elements[]) {
            BinarySearchTree tree = new BinarySearchTree();
            
            
            HashMap<String, List<Integer>> subjects = new HashMap<>();
            
            
            
            //Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
            
            //map.put("Inorder", new ArrayList<Integer>(tree.inorder()));
           //map.put("mango", new ArrayList<Integer>((tree.inorder())));
           
            //subjects = new HashMap<String, Integer[]>();
           // subjects.put("calculus", tree.inorder());

            /* Let us create following Tree 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 */
            
            for (int i = 0; i < elements.length; i++) {
                tree.insert(elements[i]);

                // print inorder traversal of the BST
            }
            
            subjects.put("Pre Order", tree.preorder());
            subjects.put("In Order", tree.inorder());
            subjects.put("Post Order", tree.postorder());
            
            
            return subjects;

        }
    }
}
