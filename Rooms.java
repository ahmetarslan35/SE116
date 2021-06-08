import java.util.ArrayList;

public class Rooms{


    public ArrayList<Rooms>arrayList ;
    private String name = "Default";


    public Monster monster ;
    public TownsPeople townsPeople ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rooms() {
        this.arrayList = new ArrayList<>();

    }

    public void addDoor(Rooms tempRoom) {
        arrayList.add(tempRoom);

    }
    public void printPossibleRooms(){
        System.out.println("Room :"+getName());
        for (int i = 0; i <arrayList.size() ; i++) {
            System.out.println(arrayList.get(i).getName());
        }

    }



}
