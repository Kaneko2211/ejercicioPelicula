package com.alura.screenmatch.modelos;

import com.alura.screenmatch.calculos.Clasificable;

public class Pelicula extends Titulo implements Clasificable {
    private String director;

    public Pelicula(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pelicula{");
        sb.append("Nombre='").append(this.getNombre()).append('\'');
        sb.append(" Fecha de lanzamiento='").append(this.getFechaDeLanzamiento()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int getClasificacion() {
        return (int) calculaMediaEvaluaciones() / 2;
    }
}
