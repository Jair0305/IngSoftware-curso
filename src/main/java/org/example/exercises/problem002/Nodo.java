package org.example.exercises.problem002;

public class Nodo {
    private int valor;
    private Nodo derecha;
    private Nodo izquierda;

    public Nodo(int valor)
    {
        this.valor = valor;
        this.derecha = null;
        this.izquierda = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public void insert(int valor)
    {
        if(valor < this.valor)
        {
            if (this.izquierda == null)
            {
                this.izquierda = new Nodo(valor);
            }else
            {
                this.izquierda.insert(valor);
            }
        }else
        {
            if(this.derecha == null)
            {
                this.derecha = new Nodo(valor);
            }else
            {
                this.derecha.insert(valor);
            }
        }
    }
}
