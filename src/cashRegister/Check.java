// このクラスは伝票を作成します。
// This class creats a check.

package cashRegister;

import java.util.ArrayList;

public class Check
{
    private int checkNumber;
    private String staffName;
    private int tableNumber;
    private int howMany;
    private ArrayList<Integer> orderP = new ArrayList<>();
    private ArrayList<String> orderN = new ArrayList<>();
    private int totalCheck;

    public Check()
    {
        this.checkNumber = (int) (Math.random() * 100000);
        this.totalCheck = 0;
    }

    public Check(int theTableNumber , int theHowMany, String theStaffName)
    {
        this.tableNumber = theTableNumber;
        this.howMany = theHowMany;
        this.staffName = theStaffName;
        this.checkNumber = (int) (Math.random() * 100000);
        this.totalCheck = 0;
    }

    public void addOrder(String foodName)
    {
        FoodNPrice a = new FoodNPrice();
        int foodPrice = a.getFoodPrice(foodName);

        this.orderP.add(foodPrice);
        this.orderN.add(foodName.toUpperCase());
        this.totalCheck += foodPrice;
    }

    public int getCheckNumber() { return checkNumber; }

    public String getStaffName() { return staffName; }

    public int getTableNumber() { return tableNumber; }

    public int getHowMany() { return howMany; }

    public int getTotalCheck() { return totalCheck; }

    public ArrayList<Integer> getOrderP() { return orderP; }

    public ArrayList<String> getOrderN() { return orderN; }

}
