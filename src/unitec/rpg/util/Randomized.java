package unitec.rpg.util;

import java.util.Random;

/**
 * Randomized es una interfaz que genera números aleatorios, así como valores booleanos como
 * si se tratara de una moneda.
 *
 * @author jesus
 * @version 1.0
 */
public interface Randomized {

    /**
     * Genera un número aleatorio entre los valores especificados.
     *
     * @param min el valor mínimo del número generado.
     * @param max el valor máximo del número generado.
     *
     * @return un número aleatorio entre los valores especificados.
     */
    static int randomizedNumber (int min, int max) {

        return new Random().nextInt(max - min + 1) + min;
    }

    /**
     * Genera un valor booleano aleatorio.
     *
     * @return un valor booleano aleatorio
     */
    static boolean randomizeBoolean() {

        return new Random().nextBoolean();
    }

    /**
     * Genera un número decimal aleatorio entre los valores especificados.
     *
     * @param min el valor mínimo del número generado.
     * @param max el valor máximo del número generado.
     *
     * @return un número decimal aleatorio entre los valores especificados
     */
    static double randomizedDouble(double min, double max) {

        return new Random().nextDouble() * (max - min) + min;
    }

    /**
     * Genera un número decimal aleatorio entre 0 y el valor especificado.
     *
     * @param total el valor máximo del número generado.
     *
     * @return un número decimal aleatorio entre 0 y el valor especificado.
     */
    static double randomizeDouble(double total) {

        return new Random().nextDouble() * total;
    }
}