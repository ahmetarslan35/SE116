import java.util.ArrayList;

public class Hero  extends Characters {


    private Rooms currentRoom  ;
    private Level currentLevel ;
    private ArrayList<Level>  Dungeon = new ArrayList<>();
    private LimitedSizedArray Inventory = new LimitedSizedArray();
    private int healthPoint ;

    public Hero() {

        for (int i = 0; i <16 ; i++) {
            Dungeon.add(Level.generateLevel());
            Dungeon.get(i).setName("Level-"+(i+1));
            System.out.println(Dungeon.get(i).getName());


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



    @Override
    public void move(int index) {
        String exRoom =currentRoom.getName() ;
        this.currentRoom = currentRoom.arrayList.get(index-1) ;
        System.out.println("Hero moved "+exRoom+" to "+currentRoom.getName()+".");




        }



    public int printOptions(){
        int counter = 1 ;
        for (int i = 0; i < currentRoom.arrayList.size(); i++) {
            System.out.println("["+(i+1)+"]"+" "+currentRoom.arrayList.get(i).getName());
            counter++ ;
        }
        if(currentRoom.isHasAMonster()){
            System.out.println("["+counter+"]"+" "+"Attack Monster");
        }

        if(currentRoom.isHasAUpstairs()){
            System.out.println("["+counter+"]"+" "+"Move to Upper Level");
        }
        if(currentRoom.isHasADownStairs()){
            System.out.println("["+counter+"]"+" "+"Move to Lower Level");
        }
        return counter ;
    }







}
