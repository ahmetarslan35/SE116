import java.util.ArrayList;

public class Hero  extends Characters {

    private String name ;
    private int healthPoint ;
    private int attackPoint ;
    private Rooms currentRoom  ;
    private Level currentLevel ;

    private ArrayList<Level>  Dungeon = new ArrayList<>();
    private ArrayList<LimitedSizedArray> Inventory ;
    private ArrayList<LimitedArray> Equipment ;



    public ArrayList<LimitedArray> getEquipment() {
        return Equipment;
    }

    public ArrayList<LimitedSizedArray> getInventory() {
        return Inventory;
    }

    public Hero() {

        this.healthPoint = GameLogic.rand.nextInt(100)+50 ;
        this.attackPoint = GameLogic.rand.nextInt(40)+30;
        Inventory = new ArrayList<>();
        Equipment = new ArrayList<>();
        LimitedSizedArray Weapons = new LimitedSizedArray();
        LimitedSizedArray Clothings= new LimitedSizedArray();
        LimitedArray Weapon = new LimitedArray();
        LimitedArray Clothing = new LimitedArray();
        LimitedSizedArray ValuableItems = new LimitedSizedArray();

        Inventory.add(Weapons);
        Inventory.add(Clothings);
        Inventory.add(ValuableItems);
        Equipment.add(Weapon);
        Equipment.add(Clothing);
        Weapon.add(GameLogic.getItem(0,0));
        Clothing.add(GameLogic.getItem(1,0));




        for (int i = 0; i <16 ; i++) {
            Dungeon.add(Level.generateLevel());
            Dungeon.get(i).setName("Level "+(i+1));



        }
        this.currentRoom =Dungeon.get(0).allRooms.get(0);
        this.currentLevel = Dungeon.get(0);
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
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
        int roomID =Integer.parseInt(roomName.substring(1));


        for (int i = 0; i <currentRoom.arrayList.size(); i++) {
            if(currentRoom.arrayList.get(i).getId()==roomID){
                this.currentRoom = currentRoom.arrayList.get(i) ;


            }

        }


        if(!exRoom.equals(currentRoom.getName()))
            System.out.println("Hero moved "+exRoom+" to "+currentRoom.getName()+".");




        }

    public void moveUpperLevel() {
        String exLevel =currentLevel.getName();
        int i = Dungeon.indexOf(currentLevel);

        this.currentLevel =  Dungeon.get(i+1);
        System.out.println("Hero moved "+exLevel+" to "+currentLevel.getName()+".");
        this.currentRoom = currentLevel.allRooms.get(0);




    }
    public void moveLowerLevel() {
        String exLevel =currentLevel.getName();
        int i = Dungeon.indexOf(currentLevel);

        this.currentLevel =  Dungeon.get(i-1);
        System.out.println("Hero moved "+exLevel+" to "+currentLevel.getName()+".");
        this.currentRoom = currentLevel.allRooms.get(0);




    }

    public Monster chooseMonster(String monsterName){
        int monsterID = Integer.parseInt(monsterName.substring(1));
        for (int i = 0; i < currentRoom.getMonsterArrayList().size(); i++) {
            if(currentRoom.getMonsterArrayList().get(i).getId()==monsterID){
                return currentRoom.getMonsterArrayList().get(i) ;
            }
        }
        return null;
    }










}
