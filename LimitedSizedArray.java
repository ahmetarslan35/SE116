import java.util.ArrayList;

//Overriding the Arraylist add because Character can carry some number of items in their inventory
class LimitedSizedArray extends ArrayList<Items> {
    @Override
    public boolean add(Items items) {

        int n = 5;
        if (this.size() < n) {
            return super.add(items);
        }
        return false;
    }

    public void showInventory(LimitedSizedArray LimitedSizedArray) {
        System.out.println("Here are the items in your inventory: " + LimitedSizedArray);
    }

    //methods below help character for switching items between inventory and equipped ones
    public void swapWeapons(LimitedSizedArray limitedSizedArray, LimitedArray limitedArray, Weapons weapon1, Weapons weapon2) {
        if (limitedSizedArray.contains(weapon1)) {
            if (limitedArray.contains(weapon2)) {
                limitedSizedArray.remove(weapon1);
                limitedArray.remove(weapon2);
                limitedSizedArray.add(weapon2);
                limitedArray.add(weapon1);
                System.out.println("You equipped: "+weapon1);
                System.out.println(weapon2+" added to your inventory.");
            }
        }


    }

    public void swapClothings(LimitedSizedArray limitedSizedArray, LimitedArray limitedArray, Clothings clothing1, Clothings clothing2) {
        if (limitedSizedArray.contains(clothing1)) {
            if (limitedArray.contains(clothing2)) {
                limitedSizedArray.remove(clothing1);
                limitedArray.remove(clothing2);
                limitedSizedArray.add(clothing2);
                limitedArray.add(clothing1);
                System.out.println("You equipped: "+clothing1);
                System.out.println(clothing2+" added to your inventory.");
            }

        }
    }
}
