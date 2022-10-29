package ba.unsa.etf.rpr;

import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String rijec;
        List<Double> lista = new ArrayList<Double>(0);
        while(!(rijec = in.next()).equals("stop"))
            lista.add(Double.parseDouble(rijec));

        System.out.println(min(lista));
        System.out.println(max(lista));
        System.out.println(mean(lista));
        System.out.println(srednja_vrijednost(lista));
        System.out.println(standardna_devijacija(lista));
    }

    public static double min(List<Double> lista) {
        double min = lista.get(0);
        for(Double el : lista)
            if(el < min)
                min = el;
        return min;
    }

    public static double max(List<Double> lista) {
        double max = lista.get(0);
        for(Double el : lista)
            if(el > max)
                max = el;
        return max;
    }

    public static double mean(List<Double> lista) {
        double suma = 0;
        for(Double el : lista)
            suma += el;
        return suma /= lista.size();
    }

    public static double srednja_vrijednost(List<Double> lista) {
        Collections.sort(lista);
        if((lista.size() % 2) == 0)
            return (lista.get((lista.size() / 2) - 1) + lista.get(lista.size() / 2)) / 2;

        return lista.get(lista.size() / 2);
    }

    private static double standardna_devijacija(List<Double> lista) {
        double mean = mean(lista), sd = 0;
        for(Double el : lista)
            sd += (el - mean) * (el - mean);
        return Math.sqrt(sd / lista.size());
    }
}