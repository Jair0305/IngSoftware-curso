package org.example.exercises.problem004;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroAConvertir = 0;
        String numeroBinario = "";
        int contadorUnos = 0;
        System.out.println("Ingrese un número entero: ");

        numeroAConvertir = scanner.nextInt();

        for(int i = numeroAConvertir; i>0; i/=2)
        {
            numeroBinario = (i%2) + numeroBinario;
        }

        for(int i = 0; i<numeroBinario.length();i++)
        {
            if(numeroBinario.charAt(i) == '1')
            {
                contadorUnos++;
            }
        }

        System.out.println(contadorUnos);

    }
}
