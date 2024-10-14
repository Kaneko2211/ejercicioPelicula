package com.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Titulo implements Comparable<Titulo>{


    private String nombre;
    private int fechaDeLanzamiento;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeEvaluaciones;
    private int duracionEnMinutos;

    public Titulo (TituloOmdb miTituloOmdb){
        this.nombre = miTituloOmdb.Title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());

        if(miTituloOmdb.runtime().contains("N/A")){
            throw new ErrorEnConversionDeDuraccionExcepcion("No pude convertir la duracion, "+
                    "porque contiene un N/A");
        }

        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime()
                .substring(0,3).replace(" ","") );

    }
    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public int getTotalDeEvaluaciones() {
        return totalDeEvaluaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void muestraFichaTecnica(){
        System.out.println("Nombre de la película: " + nombre);
        System.out.println("Año de lanzamiento: " + fechaDeLanzamiento);
    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalDeEvaluaciones++;
    }



    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaDeLanzamiento, incluidoEnElPlan, sumaDeLasEvaluaciones, totalDeEvaluaciones, duracionEnMinutos);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(" (nombre= ").append(nombre);
        sb.append(", fechaDeLanzamiento=").append(fechaDeLanzamiento);
        sb.append(", runtime= ").append(this.duracionEnMinutos).append(")\n");
        return sb.toString();
    }

    public double calculaMediaEvaluaciones(){
        return sumaDeLasEvaluaciones / totalDeEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }
}
