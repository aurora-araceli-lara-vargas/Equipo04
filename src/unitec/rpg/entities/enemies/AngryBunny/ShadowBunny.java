package unitec.rpg.entities.enemies.AngryBunny;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.annotation.BossEnemy;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

@BossEnemy
public class ShadowBunny extends AngryBunny {

    public ShadowBunny(Player player) {

        super(player);
    }

    protected void initStats() {

        this.name = "Shadow Bunny";
        this.experience = 50;
        this.gold = 30;
        this.maxlevel = 20;
        this.stats.put(Stats.HP, 50);
        this.stats.put(Stats.ATTACK, 20);
        this.stats.put(Stats.DEFENSE, 20);
        this.stats.put(Stats.SPEED, 20);
        this.stats.put(Stats.EVASION, 20);
        this.stats.put(Stats.ACCURACY, 20);
        setStats(player);
    }

    @Override
    public String attack(Player player) {

        String message;
        double singleHitChance = 0.30;
        double multipleTeleportationChance = 0.30;
        double random = Math.random();
        if (random < singleHitChance) {

            message = singleHit(player);
        } else if (random < singleHitChance + multipleTeleportationChance) {

            message = multipleTeleportation(player);
        } else {

            message = flee(player);
        }
        return message;
    }

    protected String singleHit(Player player) {

        int damage = (int) ((stats.get(Stats.ATTACK) * 1.25) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("%s ataca a %s por %d puntos de daño.", name, player.getName(), damage);
    }

    private String multipleTeleportation(Player player) {

        int damage = (int) ((stats.get(Stats.ATTACK) * 1.5) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("%s se teletransporta y golpea a %s por %d puntos de daño.", name, player.getName(), damage);
    }

    @Override
    public ImageIcon getImage() {

        ImageCache.addImage("ShadowBunny", "img/enemies/Shadow_Bunny.png");
        return ImageCache.getImageIcon("ShadowBunny");
    }
}