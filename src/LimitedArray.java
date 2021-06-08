import java.util.ArrayList;

//Overriding the Arraylist add because character can carry maximum of 2 equipments on him/her
class LimitedArray extends ArrayList<Items> {
    @Override
    public boolean add(Items items) {

        int n = 2;
        if (this.size() < n) {
            return super.add(items);
        }
        return false;
    }

    public void showEquipments(LimitedArray LimitedArray) {
        System.out.println("You equipped these: " + LimitedArray);
    }
}
