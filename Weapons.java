public class Weapons extends Items {

    public Weapons(String name, int value, int weight, int damage, int range) {
        super(name, value, weight);
        this.damage = damage;
        this.range = range;
    }

    private int damage;
    private int range;


    public void showInfo() {
        super.showInfo();
        if (damage >= 12) {
            System.out.println("God bless your enemies! You can cause " + damage + " damage to your enemies with this.");
        } else {
            System.out.println("This must be hard to fight! It causes " + damage + " damage to your enemies.");
        }
        if (range >= 7) {
            System.out.println("With this weapon,your enemies won't even come close to you! You can attack from " + range + " ranges far.");
        } else {
            System.out.println("It will be a very close fight! The range of this weapons is: " + range);
        }
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
