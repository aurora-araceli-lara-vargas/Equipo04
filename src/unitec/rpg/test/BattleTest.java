package unitec.rpg.test;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.Enemy;

public class BattleTest {

    public static void main(String[] args) {

        //Nuevo jugador
        Player player = new Player("Liana");

        //Nuevo enemigo
        Enemy enemy = new Enemy("Shadow");

        //Imprimir los atributos del jugador y el enemigo
        System.out.println("Jugador: " + player.getName());
        System.out.println("Salud: " + player.getHp() + "/" + player.getMaxHP());
        System.out.println("Magía: " + player.getMp() + "/" + player.getMaxMp());
        System.out.println("Ataque: " + player.getAttack());
        System.out.println("Defensa: " + player.getDefense());
        System.out.println("Experiencia: " + player.getExperience());
        System.out.println("Nivel: " + player.getLevel());
        System.out.println("Oro: " + player.getGold());

        System.out.println("Enemigo: " + enemy.getName());
        System.out.println("Salud: " + enemy.getHp() + "/" + enemy.getMaxHP());
        System.out.println("Magía: " + enemy.getMp() + "/" + enemy.getMaxMP());
        System.out.println("Ataque: " + enemy.getAttack());
        System.out.println("Defensa: " + enemy.getDefense());
        System.out.println("Experiencia: " + enemy.getExperience());
        System.out.println("Oro: " + enemy.getGold());

        //Batalla entre jugador y enemigo
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }
        if (player.isAlive()) {
            System.out.println("¡" + player.getName() + " ha derrotado a " + enemy.getName() + "!");
            enemy.dropLoot(player);
        } else {
            System.out.println("¡" + enemy.getName() + " ha derrotado a " + player.getName() + "!");
        }
    }
}