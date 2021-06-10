import java.util.ArrayList;

public class Hero  extends Characters {


    private Rooms currentRoom  ;
    private Level currentLevel ;
    private String name ;

    private ArrayList<Level>  Dungeon = new ArrayList<>();
    private ArrayList<LimitedSizedArray> Inventory ;
    private int healthPoint ;


    public Hero() {

        this.healthPoint = 50 ;
        Inventory = new ArrayList<>();
        LimitedSizedArray Weapon = new LimitedSizedArray();
        LimitedSizedArray Clothing= new LimitedSizedArray();
        Inventory.add(Weapon);
        Inventory.add(Clothing);



        for (int i = 0; i <16 ; i++) {
            Dungeon.add(Level.generateLevel());
            Dungeon.get(i).setName("Level "+(i+1));



        }
        this.currentRoom =Dungeon.get(0).allRooms.get(0);
        this.currentLevel = Dungeon.get(0);
    }

    public Rooms getCurrentRoom() {
        return currentRoom;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void move(String roomName) {
        String exRoom =currentRoom.getName() ;
        for (int i = 0; i <currentRoom.arrayList.size(); i++) {
            if(currentRoom.arrayList.get(i).getName().equals(roomName)){
                this.currentRoom = currentRoom.arrayList.get(i) ;


            }

        }


        System.out.println("Hero moved "+exRoom+" to "+currentRoom.getName()+".");




        }
    public void moveUpperLevel() {
        String exLevel =currentLevel.getName();
        int i = Dungeon.indexOf(currentLevel);

        this.currentLevel =  Dungeon.get(i+1);
        System.out.println("Hero moved "+exLevel+" to "+currentLevel.getName()+".");




    }
    public void moveLowerLevel() {
        String exLevel =currentLevel.getName();
        int i = Dungeon.indexOf(currentLevel);

        this.currentLevel =  Dungeon.get(i-1);
        System.out.println("Hero moved "+exLevel+" to "+currentLevel.getName()+".");




    }










}
