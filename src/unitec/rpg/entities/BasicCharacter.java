package unitec.rpg.entities;

public class BasicCharacter {

    protected String name;
    protected int hp;
    protected int maxHP;
    protected int mp;
    protected int maxMP;
    protected int attack;
    protected int defense;


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

    public String attack(BasicCharacter character) {

        int damage = this.attack - character.getDefense();
        String message;
        if (damage > 0) {
            message = String.format("%s ataca a %s y le hace %d puntos de daño.\n", this.getName(), character.getName(), damage);
            message += character.takeDamage(damage);
        } else {
            message = String.format("%s ataca a %s pero no le hace daño.\n", this.getName(), character.getName());
        }
        return message;
    }

    public String  takeDamage(int damage) {

        String message;
        this.hp -= damage;
        message = String.format("%s recibe %d puntos de daño.\n", this.getName(), damage);
        if (this.hp <= 0) {

            message += String.format("%s ha muerto.\\n", this,getName());
        }
        return message;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
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