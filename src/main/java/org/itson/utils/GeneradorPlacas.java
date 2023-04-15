package org.itson.utils;

import java.util.Random;

/**
 * Descripción de la clase: Esta clase genera placas aleatorias con un formato
 * UUU-###
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class GeneradorPlacas {

    //Modulo de Letras para generar la primera serie de las placas
    private char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    //Objeto para escoger aleatoriamente
    private Random random = new Random();

    /**
     * Constructor por default
     */
    public GeneradorPlacas() {

    }

    /**
     * Método que obtiene una letra aleatoria
     *
     * @return Un carácter del abecedario
     */
    private char letraAleatoria() {
        int posicionAleatoria = random.nextInt(alfabeto.length);
        return alfabeto[posicionAleatoria];
    }

    /**
     * Método que obtiene un número aleatorio del 1 al 9
     *
     * @return Número aleatorio del 1 al 9
     */
    private int numeroAleatorio() {
        return random.nextInt(10);
    }

    /**
     * Método que genera una placa con el formato UUU-### para la placa
     *
     * @return Un string que simboliza la placa que se genera.
     */
    public String generarPlaca() {
        String placa = "";
        for (int i = 0; i < 7; i++) {
            if (i < 3) {
                placa += letraAleatoria();
            } else if (i == 3) {
                placa += "-";
            } else {
                placa += numeroAleatorio();
            }
        }
        return placa;
    }
}
