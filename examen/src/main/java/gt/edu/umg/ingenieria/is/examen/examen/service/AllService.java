/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.is.examen.examen.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class AllService {
    
    public class TreeArray {

        int startValues[] = {50, 25, 75, 10, 15, 5, 53, 29, 79, 78, 111, 33};
        int[] aTree = new int[100];

        public TreeArray() {
            for (int i = 0; i < startValues.length; i++) {
                insert(startValues[i]);
            }
            System.out.println("Pre-Order:");
            preOrder(0, "");
        }

        public void insert(int key) {

            if (aTree[0] == 0) {
                aTree[0] = key;
                return;
            }

            boolean add = false;
            int curIdx = 0;

            while (!add) {
                if (key < aTree[curIdx]) {
                    //go left
                    if (aTree[curIdx * 2 + 1] == 0) {
                        aTree[curIdx * 2 + 1] = key;
                        add = true;
                    } else {
                        curIdx = curIdx * 2 + 1;
                    }
                } else {
                    //go right
                    if (aTree[curIdx * 2 + 2] == 0) {
                        aTree[curIdx * 2 + 2] = key;
                        add = true;
                    } else {
                        curIdx = curIdx * 2 + 2;
                    }
                }
            }
        }

        public void preOrder(int idx, String i) {
            if (idx>=aTree.length) {
                return;
            } else {
                System.out.println(i + aTree[idx]);
                preOrder(((2 * idx) + 1), i + ".");
                preOrder(((2 * idx) + 2), i + ".");

            }
        }
    }
}
