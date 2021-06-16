import java.util.ArrayList;

public class Corridor {
    public ArrayList<Rooms> roomsArrayList;


    private int roomAmount ;

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }

    public int getRoomAmount() {
        return roomAmount;
    }



    public Corridor() {
        roomAmount = GameLogic.rand.nextInt(3)+2;

        roomsArrayList = new ArrayList<>();
    }
    public static Corridor generateCorridor(){
        Corridor tempCorridor = new Corridor() ;


        for(int i =0 ; i< tempCorridor.roomAmount ; i++){
            tempCorridor.roomsArrayList.add(new Rooms());
        }
        return  tempCorridor ;
    }


}
