package org.example.exercises.problem002;

public class ArbolBinario {
    private Nodo inicial;

    public ArbolBinario()
    {
        this.inicial = null;
    }

    public void insert(int valor)
    {
        if(this.inicial == null)
        {
            this.inicial = new Nodo(valor);
        }else
        {
            this.inicial.insert(valor);
        }
    }

    public void hojasInOrden()
    {
        hojasInOrden(this.inicial);
    }

    private void hojasInOrden(Nodo nodo)
    {
        if(nodo != null)
        {
            if(nodo.getIzquierda() == null && nodo.getDerecha() == null)
            {
                System.out.println(nodo.getValor());
            }
            hojasInOrden(nodo.getIzquierda());
            hojasInOrden(nodo.getDerecha());
        }
    }
}
