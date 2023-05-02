package ProductFactory.GameCharacter;

abstract class Character {
    protected String name;
    protected int health;
    protected int speed;

    public Character(String name, int health, int speed) {
        this.name = name;
        this.health = health;
        this.speed = speed;
    }

    public abstract void move();
    public abstract void attack();
    public abstract void die();

    static class Factory {
        static String KNIGHT = "Knight";
        static String WIZARD = "Wizard";

        public static Character create(String tipo, String name, int health, int speed) {
            if (tipo.equals(KNIGHT)) {
                return new Knight(name, health, speed);
            } else if (tipo.equals(WIZARD)) {
                return new Wizard(name, health, speed);
            } else {
                throw new RuntimeException("tipo invalido");
            }
        }
    }
}

class Knight extends Character {

    public Knight(String name, int health, int speed) {
        super(name, health, speed);
    }

    @Override
    public void move() {
        System.out.println("Knight is moving...");
    }

    @Override
    public void attack() {
        System.out.println("Knight is attacking...");
    }

    @Override
    public void die() {
        System.out.println("Knight died...");
    }
}

class Wizard extends Character {

    public Wizard(String name, int health, int speed) {
        super(name, health, speed);
    }

    @Override
    public void move() {
        System.out.println("Wizard is moving...");
    }

    @Override
    public void attack() {
        System.out.println("Wizard is attacking...");
    }

    @Override
    public void die() {
        System.out.println("Wizard died...");
    }
}







public class Main {
    public static void main(String[] args) {


        // create a knight
        Character knight = Character.Factory.create(Character.Factory.KNIGHT, "Arthur", 100, 5);
        knight.move();
        knight.attack();
        knight.die();

        // create a wizard
        Character wizard = Character.Factory.create(Character.Factory.WIZARD, "Gandalf", 80, 7);
        wizard.move();
        wizard.attack();
        wizard.die();
    }
}
