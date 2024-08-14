package unitec.rpg.entities.enemies.shadow;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.Enemy;
import unitec.rpg.entities.enemies.annotation.RegularEnemy;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

@RegularEnemy
public class AngryShadow extends Enemy {

    public AngryShadow(Player player) {

        super(player);
    }

    protected void initStats() {

        this.name = "Angry Shadow";
        this.experience = 10;
        this.gold = 10;
        this.maxlevel = 10;
        this.stats.put(Stats.HP, 11);
        this.stats.put(Stats.ATTACK, 6);
        this.stats.put(Stats.DEFENSE, 5);
        this.stats.put(Stats.SPEED, 5);
        this.stats.put(Stats.EVASION, 5);
        this.stats.put(Stats.ACCURACY, 5);
        setStats(player);
    }

    /**
     * Función que permitirá al enemigo atacar al jugador utilizando de forma aleatoria los métodos de ataque del enemigo
     *
     * @param player el jugador al que se atacará
     * @return un mensaje que indica el ataque realizado
     */
    @Override
    public String attack(Player player) {

        String message;
        //Probabilidades de ataque
        double plainAttackChance = 0.30;
        double echoOfDarkness = 0.30;
        double shadowyEmbrace = 0.30;
        double random = Math.random();
        if (random < plainAttackChance) {

            message = plainAttack(player);
        } else if (random < plainAttackChance + echoOfDarkness) {

            message = echoOfDarkness(player);
        } else if (random < plainAttackChance + echoOfDarkness + shadowyEmbrace){

            message = shadowyEmbrace(player);
        } else {
            message = stealGold(player);
        }
        return message;
    }

    protected String plainAttack(Player player) {

        int damage = stats.get(Stats.ATTACK) - player.getStatus(Stats.DEFENSE);
        player.takeDamage(damage);
        return String.format("%ataca a %s por %d puntos de daño.\n", name, player.getName(), damage);
    }

    protected String echoOfDarkness(Player player) {

        int damage = (int) ((stats.get(Stats.ATTACK) * 1.15) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("%ataca a %s con un grito fantasmal por %d puntos de daño.\n", name, player.getName(), damage);
    }

    protected String shadowyEmbrace(Player player) {

        int damage = (int) ((stats.get(Stats.ATTACK) * 1.50) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("% envuelve a %s en una densa oscuridad por %d puntos de daño.", name, player.getName(), damage);
    }

    protected String stealGold(Player player) {

        int goldStolen = Math.max((player.getGold() - 5), 0);
        player.setGold(player.getGold() - goldStolen);
        gold += goldStolen;
        return goldStolen == 0 ? String.format("%s intenta robar a %s, pero no tiene oro.\n", name, player.getName()) :
                String.format("%s roba %d monedas de oro a %s.\n", name, goldStolen, player.getName());
    }

    /**
     * Devuelve la imagen del enemigo
     *
     * @return
     */
    @Override
    public ImageIcon getImage() {

        ImageCache.addImage("AngryShadow", "img/enemies/Angry_Shadow.png");
        return ImageCache.getImageIcon("AngryShadow");
    }
}