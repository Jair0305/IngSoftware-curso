package org.example.exercises.problem001;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el numero de numeros a considerar");
        int number = scanner.nextInt();

        LinkedList<Double> numbers = new LinkedList<>();

        for (int i = 0; i < number; i++)
        {
            System.out.println("Ingresa el numero " + (i + 1) + ": ");
            numbers.add(scanner.nextDouble());
        }

        System.out.println("La media es: " + calculateMean(numbers));

        System.out.println("La desviacion estandar es: " + StandardDeviation(numbers));

        scanner.close();
    }

    public static Double calculateMean(LinkedList numbers) {
        double mean = 0, sum = 0;

        for (int i = 0; i < numbers.size(); i++)
        {
            sum += (double) numbers.get(i);
        }
        mean = sum / numbers.size();

        return mean;
    }

    public static Double StandardDeviation(LinkedList numbers) {
        Double mean = calculateMean(numbers);
        Double sum = 0.0;

        for (int i = 0; i < numbers.size(); i++)
        {
            sum += Math.pow((double) numbers.get(i) - mean, 2);
        }

        return Math.sqrt(sum / (numbers.size() - 1));
    }
}