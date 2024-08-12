package unitec.rpg.entities.enemies.shadow;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.annotation.Enemy;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

@Enemy
public class AngryShadow extends Enemy {

    public AngryShadow(Player player) {

        super(player);
    }

    protected void initStats() {

        this.name = "Angry Shadow";
        this.experience = 55;
        this.gold = 35;
        this.maxlevel = 25;
        this.stats.put(Stats.HP, 55);
        this.stats.put(Stats.ATTACK, 25);
        this.stats.put(Stats.DEFENSE, 20);
        this.stats.put(Stats.SPEED, 20);
        this.stats.put(Stats.EVASION, 20);
        this.stats.put(Stats.ACCURACY, 20);
        setStats(player);
    }

    @Override
    public String attack(Player player) {
        String message;
        double plainAttackChance = 0.60;
        double echoOfDarkness = 0.20;
        double shadowyEmbrace = 0.20;
        double random = Math.random();
        if (random < plainAttackChance) {
            message = plainAttack(player);
        } else if (random < plainAttackChance + echoOfDarkness) {
            message = echoOfDarkness(player);
        } else {
            message = shadowyEmbrace(player);
        }
        return message;
    }

    private String plainAttack(Player player) {
    }

    protected String echoOfDarkness(Player player) {

        int damage = (int) ((stats.get(Stats.ATTACK) * 2.00) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("%s lanza un grito fantasmal a %s por %d puntos de daño."), name, player.getName(), damage);
    }

    protected String shadowyEmbrace(Player player) {

        int damage = (int) ((stats.get(Stats.ATTACK) * 2.50) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("% envuelve a %s en una densa oscuridad por %d puntos de daño.", name, player.getName(), damage);
    }

    @Override
    public ImageIcon getImage() {

        ImageCache.addImage("AngryShadow", "img/enemies/Angry_Shadow.png")-,
        return ImageCache.getImageIcon("AngryShadow");
    }
}