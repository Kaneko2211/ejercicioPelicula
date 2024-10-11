package com.alura.screenmatch.Principal;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    public static void main(String[] args) {


        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(9);
        Serie lost = new Serie("Lost", 2000);

        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.evalua(10);
        var peliculaDeBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaDeBruno.evalua(6);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(peliculaDeBruno);
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(lost);

        for (Titulo item: lista) {
            System.out.println(item.toString());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println("Clasificacion: " +pelicula.getClasificacion());
            }

        }
        System.out.println("-------------------------------------");

        lista.forEach(item-> System.out.println(item));

        System.out.println("***************************/*/*******");
        lista.forEach(System.out::println);


        ArrayList<String> listaDeArtista = new ArrayList<>();
        listaDeArtista.add("Penelope");
        listaDeArtista.add("Antonio Banderas");
        listaDeArtista.add("Ricardo Larin");
        System.out.println(listaDeArtista);

        Collections.sort(listaDeArtista);

        System.out.println("Lista de artista ordenadas: "+listaDeArtista);

        Collections.sort(lista);
        System.out.println("Lista de titulo ordenado: "+ lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println(lista);
    }

}
