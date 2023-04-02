package org.itson.utils;

import java.util.Random;

public class GeneradorPlacas {

    private char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private Random random = new Random();

    public GeneradorPlacas(){}

    private char letraAleatoria(){
        int posicionAleatoria = random.nextInt(alfabeto.length);
        return alfabeto[posicionAleatoria];        
    }

    private int numeroAleatorio(){
        return random.nextInt(10);
    }

    public String generarPlaca(){
        String placa = "";
        for(int i = 0; i < 7; i++){
            if(i < 3){
                placa += letraAleatoria();
            }else if(i == 3){
                placa += "-";
            }else{
                placa += numeroAleatorio();
            }
        }
        return placa;
    }
}
