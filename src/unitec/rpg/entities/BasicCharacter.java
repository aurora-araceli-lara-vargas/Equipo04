package unitec.rpg.entities;

public abstract class BasicCharacter {

    protected String name;
    protected int hp;
    protected int maxHP;
    protected int mp;
    protected int maxMP;

    public BasicCharacter(String name) {
        this.name = name;
        this.hp = 50;
        this.maxHP = 50;
        this.mp = 20;
        this.maxMP = 20;
    }

    public BasicCharacter() {
        this("Sunho");
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void defend(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    //Getter and Setters

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    //Constructor

    public BasicCharacter(String name, int hp, int maxHP, int mp, int maxMP) {
        this.name = name;
        this.hp = hp;
        this.maxHP = maxHP;
        this.mp = mp;
        this.maxMP = maxMP;
    }
}