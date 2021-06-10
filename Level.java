import java.util.ArrayList;
import java.util.Random;

public class Level {

    private int corridorAmount;
    private static int levelNumber = 1;
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Corridor> corridorArrayList;
    public ArrayList<Rooms> allRooms ;


    public int getCorridorAmount() {
        return corridorAmount;
        
    }





    public Level() {
        corridorAmount = GameLogic.rand.nextInt(2)+2; // amount of Corridor
        corridorArrayList= new ArrayList<>();
        allRooms = new ArrayList<>();

    }




    public static Level generateLevel(){
        Level tempLevel = new Level() ;
        int counter =0 ;
        int x;

        for(int i =0 ; i<tempLevel.getCorridorAmount() ; i++){
            Corridor corridor = Corridor.generateCorridor();
            tempLevel.corridorArrayList.add(corridor);
            counter += tempLevel.corridorArrayList.get(i).getRoomAmount();
        } // corridor and rooms were generated

        for(int i =0 ; i<tempLevel.getCorridorAmount() ; i++){
            Corridor corridor= tempLevel.corridorArrayList.get(i);
             for (int j = 0 ; j < corridor.roomsArrayList.size() ; j++){
                 if(j+1 != corridor.roomsArrayList.size()){
                     corridor.roomsArrayList.get(j).addDoor(corridor.roomsArrayList.get(j+1));
                 }


             }
        }// rooms that in the same corridor were linked forwardly

        for(int i =0 ; i<tempLevel.getCorridorAmount() ; i++){

            if(i+1 != tempLevel.getCorridorAmount()){
                Corridor corridor1 = tempLevel.corridorArrayList.get(i);
                Corridor corridor2= tempLevel.corridorArrayList.get(i+1)  ;
                int a = GameLogic.rand.nextInt(corridor1.roomsArrayList.size());
                int b = GameLogic.rand.nextInt(corridor2.roomsArrayList.size());
                corridor1.roomsArrayList.get(a).addDoor(corridor2.roomsArrayList.get(b));
                corridor2.roomsArrayList.get(b).addDoor(corridor1.roomsArrayList.get(a));
            }

        }// rooms that in the different corridors were linked randomly

        for(int i= 0 ; i<tempLevel.getCorridorAmount() ; i++){
            Corridor corridor = tempLevel.corridorArrayList.get(i);
            for (int j =corridor.roomsArrayList.size()-1 ; j >=0 ; j--){
                if(j+1 != corridor.roomsArrayList.size()){
                    corridor.roomsArrayList.get(j+1).addDoor(corridor.roomsArrayList.get(j));
                }


            }
        }// rooms that in the same corridor were linked backwardly

        for(int i =0 ; i <tempLevel.getCorridorAmount();i++){
            Corridor corridor = tempLevel.corridorArrayList.get(i);
            tempLevel.allRooms.addAll(corridor.roomsArrayList);
        } // all rooms were added to the arraylist for setting their name

        for(int i =1; i <=counter;i++){
            tempLevel.allRooms.get(i-1).setName("Room"+i);
        }        // all rooms has a name


        if(levelNumber<16){
            Corridor tempCorridor = tempLevel.corridorArrayList.get(GameLogic.rand.nextInt(tempLevel.getCorridorAmount()));
            x =GameLogic.rand.nextInt(tempCorridor.roomsArrayList.size());
            tempCorridor.roomsArrayList.get(x).setHasAUpstairs(true);

        } // upstairs was generated

        if(levelNumber > 1){
            Corridor tempCorridor1 = tempLevel.corridorArrayList.get(GameLogic.rand.nextInt(tempLevel.getCorridorAmount()));
            x =GameLogic.rand.nextInt(tempCorridor1.getRoomAmount());
            tempCorridor1.roomsArrayList.get(x).setHasADownStair(true);

        } // downstairs was generated



        levelNumber++;






        return  tempLevel ;
    }




}
