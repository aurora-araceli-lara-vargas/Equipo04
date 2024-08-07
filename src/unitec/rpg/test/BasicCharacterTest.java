package unitec.rpg.test;

import unitec.rpg.entities.BasicCharacter;

public class BasicCharacterTest {

    public static void main (String[] args) {

        //Nuevo personaje básico
        BasicCharacter character = new BasicCharacter("Shooky");

        // Imprimir los atributos del personaje
        System.out.println("Nombre: " + character.getName());
        System.out.println("Salud: " + character.getHp() + "/" + character.getMaxHP());
        System.out.println("Magía: " + character.getMp() + "/" + character.getMaxMP());
    }
}