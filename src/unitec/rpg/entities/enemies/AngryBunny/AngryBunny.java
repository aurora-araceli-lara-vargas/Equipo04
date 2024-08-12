package unitec.rpg.entities.enemies.AngryBunny;

import unitec.rpg.entities.enemies.annotation.Enemy;
import unitec.rpg.entities.Player;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

public class AngryBunny extends Enemy {

    public AngryBunny(Player player) {

        super(player);
    }

    protected void initStats() {

        this.name = "AngryBunny";
        this.experience = 9;
        this.gold = 4;
        this.maxlevel = 10;
        this.stats.put(Stats.HP, 10);
        this.stats.put(Stats.ATTACK, 5);
        this.stats.put(Stats.DEFENSE, 5);
        this.stats.put(Stats.SPEED, 5);
        this.stats.put(Stats.EVASION, 5);
        this.stats.put(Stats.ACCURACY, 5);
        setStats(player);
    }

    /**
     * Función que permite al enemigo atacar al jugador utilizando de fortma aleatoria los métodos de ataque del enemigo.
     *
     * @param player el jugador al que se atacará
     * @return un mensaje que indica el ataque realizado
     */
    @Override
    public String attack(Player player) {

        String message;
        //Probabilidades de ataque
        double singleHitChance = 0.30;
        double quickKickChance = 0.30;
        double fleeChance = 0.30;
        double random = Math.random();
        if (random < singleHitChance) {

            message = singleHit(player);
        } else if (random < singleHitChance + quickKickChance) {

            message = quickKick(player);
        } else if (random < singleHitChance + quickKickChance + fleeChance) {

            message = flee(player);
        } else {
            message = stealGold(player);
        }
        return message;
    }

    protected String singleHit(Player player) {

        int damage = stats.get(Stats.ATTACK) - player.getStatus(Stats.DEFENSE);
        player.takeDamage(damage);
        return String.format("%s golpea a %s por %d puntos de daño.", name, player.getName(), damage);
    }

    protected String quickKick(Player player) {

        int damage = (int) ((stats.get(Stats.ATTACK) * 1.15) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("%s pateá a %s por %d puntos de daño.", name, player.getName(), damage);
    }

    protected String flee(Player player) {

        return String.format("%s huye", name);
    }

    protected String stealGold(Player player) {

        int goldStolen = Math.max((player.getGold() - 5), 0);
        player.setGold(player.getGold() - goldStolen);
        gold += goldStolen;
        return goldStolen == 0 ? String.format("%s intenta robar a %s, pero no tiene oro.", name, player.getName()) :
                String.format("%s roba %d monedad de oro a %s.", name, goldStolen, player.getName());
    }

    /**
     * Devuelve la imagen de enemigo.
     *
     * @return la imagen del enemigo
     */
    @Override
    public ImageIcon getImage() {

        ImageCache.addImage("AngryBunny", "img/enemies/Enemy.png");
        return ImageCache.getImageIcon("AngryBunny");
    }
}
