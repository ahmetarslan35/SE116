public class Monster extends Characters {
    private int healthPoint ;
    private int id ;
    private int attackPoint ;

    public Monster() {
        attackPoint = GameLogic.rand.nextInt(30)+20 ;
        healthPoint = GameLogic.rand.nextInt(40)+30;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void move(String roomName) {

    }
}
