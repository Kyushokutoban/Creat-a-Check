#FoodNriceクラスは、商品の名前と価格のデータを管理するクラスです。
#This class FoodNPrice manage the data of food name and its price.
    
package cashRegister;

import java.util.HashMap;

public class FoodNPrice
{
    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    public FoodNPrice()
    {
        mapping();
    }

    public void mapping()
    {
        // Hot drinks
        map.put("BRAND COFFEE", 450);
        map.put("CAFE ORE", 450);
        map.put("AMERICAN COFFEE", 450);
        map.put("MILK COFFEE", 450);

        // Ice drinks
        map.put("ICE COFFEE", 450);
        map.put("ICE ORE",450);
        map.put("ICE MILK COFFEE",450);

        // Shiro-no-wares
        map.put("MINI SHIRONOWARE",500);
        map.put("SHIRONOWARE",600);

        // Sandwiches
        map.put("MIX SANDWICH",580);
        map.put("EGG SAND", 550);

        // Hamburger
        map.put("FISH FRY BURGER",480);
    }

    public int getFoodPrice(String foodName) { return map.get(foodName.toUpperCase()); }
}
