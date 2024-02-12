package org.example.exercises.problem002;

public class Main {

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insert(30);
        arbol.insert(25);
        arbol.insert(35);
        arbol.insert(12);
        arbol.insert(28);
        arbol.insert(32);
        arbol.insert(40);
        arbol.insert(7);
        arbol.insert(15);
        arbol.insert(27);
        arbol.insert(29);
        arbol.insert(31);
        arbol.insert(34);
        arbol.insert(38);
        arbol.insert(45);
        System.out.println("Hojas del árbol en orden: ");
        arbol.hojasInOrden();
    }
}
