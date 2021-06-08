

public class Hero  extends Characters {


    private Rooms currentRoom  ;
    private Level currentLevel ;
    private int healthPoint = 10;

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

    public Hero(Rooms currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public void move(String roomName) {
        for (int i = 0; i <currentRoom.arrayList.size() ; i++) {
            if(currentRoom.arrayList.get(i).getName().equals(roomName)){
                System.out.println("Hero moved "+currentRoom.getName()+" to "+roomName+".");
                this.currentRoom = currentRoom.arrayList.get(i) ;

            }



        }







    }
}
