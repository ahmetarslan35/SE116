import java.util.ArrayList;

public class Rooms{


    public  ArrayList<Rooms>arrayList ;
    private ArrayList<Monster>monsterArrayList;
    private ArrayList<TownsPeople>townsPeopleArrayList;
    private boolean hasAMonster =false;
    private boolean hasAUpstairs = false ;
    private boolean hasADownStairs = false;
    private boolean hasATownsPeople = false ;
    private String name ;
    private int id ;




    public Rooms() {
        this.arrayList = new ArrayList<>();
        this.monsterArrayList =new ArrayList<>();
        this.townsPeopleArrayList = new ArrayList<>();
        int x = GameLogic.rand.nextInt(2)+1;
        for (int i = 0; i < x; i++) {
            Monster monster= new Monster();
            monster.setId(i+1);
            monsterArrayList.add(monster);
        }
        if(monsterArrayList.size()>0){
            hasAMonster = true;
        }




    }


    public ArrayList<Monster> getMonsterArrayList() {
        return monsterArrayList;
    }

    public ArrayList<TownsPeople> getTownsPeopleArrayList() {
        return townsPeopleArrayList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean hasAMonster() {
        return hasAMonster;
    }

    public void setHasAMonster(boolean hasAMonster) {
        this.hasAMonster = hasAMonster;
    }

    public boolean hasAUpstairs() {
        return hasAUpstairs;
    }

    public void setHasAUpstairs(boolean hasAUpstairs) {
        this.hasAUpstairs = hasAUpstairs;
    }

    public boolean hasADownStairs() {
        return hasADownStairs;
    }

    public void setHasADownStair(boolean hasADownStairs) {
        this.hasADownStairs = hasADownStairs;
    }

    public boolean hasATownsPeople() {
        return hasATownsPeople ;

    }
    public void setHasATownsPeople(boolean hasATownsPeople) {
        this.hasATownsPeople = hasATownsPeople;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void addDoor(Rooms tempRoom) {
        arrayList.add(tempRoom);

    }




}
