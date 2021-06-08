import java.util.ArrayList;
import java.util.Random;

public class Corridor {
    public ArrayList<Rooms> roomsArrayList;


    private static int roomAmount ;

    public int getRoomAmount() {
        return roomAmount;
    }


    static Random rand =new Random();

    public Corridor() {
        roomAmount = rand.nextInt(3)+2;

        roomsArrayList = new ArrayList<>();
    }
    public static Corridor generateCorridor(){
        Corridor tempCorridor = new Corridor() ;


        for(int i =0 ; i<roomAmount ; i++){
            tempCorridor.roomsArrayList.add(new Rooms());
        }
        return  tempCorridor ;
    }


}
