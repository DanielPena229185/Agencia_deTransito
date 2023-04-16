package org.itson.sistema;

import org.itson.presentacion.PrincipalForm;
import org.itson.utils.GenerarReporte;

/**
 * Descripción de la clase: Esta clase Se dedica a inicar el sistema. Clase que
 * contiene el método main, encargado de iniciar el sistema. La clase crea una
 * instancia de PrincipalForm y la muestra en pantalla.
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class AgenciaDeTransito {

    /**
     * El método main es el punto de entrada del programa. Crea una instancia de
     * la clase PrincipalForm y lo muestra en pantalla para iniciar el sistema.
     *
     * @param args Argumentos de la línea de comandos (no se utiliza en esta
     * aplicación)
     */
    public static void main(String[] args) {

        PrincipalForm principal = new PrincipalForm();
        principal.setVisible(true);

    }
}
