package unitec.rpg.entities.enemies.BadHorse;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.annotation.Enemy;
import unitec.rpg.entities.enemies.annotation.RegularEnemy;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

@RegularEnemy
public class Horse extends Enemy {

    public Horse(Player player) {

        super(player);
    }

    protected void initStats() {

        this.name = "BadHorse";
        this.experience = 10;
        this.gold = 5;
        this.maxlevel = 10;
        this.stats.put(Stats.HP, 10);
        this.stats.put(Stats.ATTACK, 5);
        this.stats.put(Stats.DEFENSE, 5);
        this.stats.put(Stats.SPEED, 5);
        this.stats.put(Stats.EVASION, 5);
        this.stats.put(Stats.ACCURACY, 5);
        setStats(player);
    }

    @Override
    public ImageIcon getImage() {

        ImageCache.addImage("BadHorse", "img/enemies/Bad_Horse.png");
        return new ImageIcon("img/enemies/Bad_Horse.png");
    }

    @Override
    public String attack(Player player) {

        double decision = Math.random();
        double wildKickProbability = 0.3;
        double healProbability = 0.1;
        double thunderousWhinnyProbability = 0.1;

        if (decision < wildKickProbability) {
            return wildKickAttack(player);
        } else if (decision < wildKickProbability + healProbability) {
            return heal();
        } else if (decision < wildKickProbability + healProbability + thunderousWhinnyProbability) {
            return thunderousWhinny();
        } else {
            return plainAttack(player);
        }
    }

    protected String wildKickAttack(Player player) {

        player.takeDamage((int) (getStatus(Stats.ATTACK) * 1.15 - player.getStatus(Stats.DEFENSE)));
        return String.format("%s ataca a %s con una patada salvaje.", this.getName(), player.getName());
    }

    protected String plainAttack(Player player) {

        player.takeDamage(getStatus(Stats.ATTACK) - player.getStatus(Stats.DEFENSE));
        return String.format("%s ataca a %s.", this.getName(), player.getName());
    }

    protected String wildKick() {

        increaseStat(Stats.HP, 2);
        return String.format("%s se cura.", this.getName());
    }

    protected String thunderousWhinny() {

        player.takeDamage((int) (getStatus(Stats.ATTACK) * 1.2 - player.getStatus(Stats.DEFENSE)));
        return String.format("%s ataca a %s con un relinchido atronador.", this.getName(), player.getName());
    }
}