import java.util.ArrayList;
import java.util.Random;

public class Level {

    private static int corridorAmount;

    public ArrayList<Corridor> corridorArrayList;
    public ArrayList<Rooms> allRooms ;
    static Random rand  = new Random();

    public  int getCorridorAmount() {
        return corridorAmount;
        
    }





    public Level() {
        corridorAmount = rand.nextInt(2)+2; // amount of Corridor
        corridorArrayList= new ArrayList<>();
        allRooms = new ArrayList<>();

    }




    public static Level generateLevel(){
        Level tempLevel = new Level() ;
        int counter =0 ;

        for(int i =0 ; i<corridorAmount ; i++){
            Corridor corridor1 = Corridor.generateCorridor();
            tempLevel.corridorArrayList.add(corridor1);
            counter += tempLevel.corridorArrayList.get(i).getRoomAmount();
        } // corridor and rooms were generated

        for(int i =0 ; i<corridorAmount ; i++){
            Corridor corridor2 = tempLevel.corridorArrayList.get(i);
             for (int j = 0 ; j < corridor2.roomsArrayList.size() ; j++){
                 if(j+1 != corridor2.roomsArrayList.size()){
                     corridor2.roomsArrayList.get(j).addDoor(corridor2.roomsArrayList.get(j+1));
                 }


             }
        }// rooms that in the same corridor were linked forwardly

        for(int i =0 ; i<corridorAmount ; i++){


            if(i+1 != corridorAmount){
                Corridor corridor3 = tempLevel.corridorArrayList.get(i);
                Corridor corridor4= tempLevel.corridorArrayList.get(i+1)  ;
                int x = rand.nextInt(corridor3.roomsArrayList.size());
                int y = rand.nextInt(corridor4.roomsArrayList.size());
                corridor3.roomsArrayList.get(x).addDoor(corridor4.roomsArrayList.get(y));
                corridor4.roomsArrayList.get(y).addDoor(corridor3.roomsArrayList.get(x));
            }

        }// rooms that in the different corridors were linked randomly

        for(int i= 0 ; i<corridorAmount ; i++){ Corridor corridor5 = tempLevel.corridorArrayList.get(i);
            for (int j =corridor5.roomsArrayList.size()-1 ; j >=0 ; j--){
                if(j+1 != corridor5.roomsArrayList.size()){
                    corridor5.roomsArrayList.get(j+1).addDoor(corridor5.roomsArrayList.get(j));
                }


            }
        }// rooms that in the same corridor were linked backwardly

        for(int i =0 ; i <corridorAmount;i++){
            Corridor corridor6 = tempLevel.corridorArrayList.get(i);
            for (int j= 0 ;j <corridor6.roomsArrayList.size();j++ ){
                tempLevel.allRooms.add(corridor6.roomsArrayList.get(j));

            }
        } // all rooms were added to the arraylist for setting their name

        for(int i =1; i <=counter;i++){
            tempLevel.allRooms.get(i-1).setName("Room"+i);
        }        // all rooms has a name

        return  tempLevel ;
    }




}
