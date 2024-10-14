package com.alura.screenmatch.modelos;

public class ErrorEnConversionDeDuraccionExcepcion extends RuntimeException {
    private String mensaje;

    public ErrorEnConversionDeDuraccionExcepcion(String mensaje) {

        this.mensaje = mensaje;

    }


    @Override
    public String getMessage(){
        return this.mensaje;
    }
}
