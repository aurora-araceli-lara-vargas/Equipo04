package unitec.rpg.entities;

public class Player {

    private int attack;
    private int defense;
    private int experience;
    private int level;
    private int gold;

    public Player(String name) {
        super();
        this.attack = 15;
        this.defense = 10;
        this.experience = 0;
        this.level = 1;
    }

    public Player() {
        this("Sunho");
    }

    public void attack(Enemy enemy) {
        int damage = this.attack - enemy.getDefense();
        if (damage > 0) {
            System.out.println(this.getName() + " ataca a " + enemy.getName() + " y le hace " + damage + " puntos de daño.");
            enemy.takeDamage(damage);
        } else {
            System.out.println(this.getName() + " ataca a " + enemy.getName() + " pero no le hace daño.");
        }
    }

    public void defend(Enemy enemy) {
        int damage = enemy.getAttack() - this.defense;
        this.takeDamage(damage);
    }

    private void takeDamage(int damage) {
    }

    public void levelUp() {
        
    }

    public void gainExperience(int exp) {
        this.experience += exp;
        if (this.experience >= 100 * this.level) {
            levelUp();
        }
    }

    public void gainGold(int gold) {
        this.gold += gold;
    }

    // Getters and Setters

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getName() {
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }
}
