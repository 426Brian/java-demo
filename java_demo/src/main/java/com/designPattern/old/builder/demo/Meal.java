package com.designPattern.old.builder.demo;

import com.designPattern.old.builder.service.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian in 19:19 2018/5/2
 */
public class Meal {
    private List<Item> itemList = new ArrayList<>();

    public void addItems(Item item) {
        itemList.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item : itemList) {
            cost += item.price();
        }

        return cost;
    }

    public void showItems() {
        int i = 0;
        for (Item item : itemList) {
            System.out.print(" "+ ++i+" item: "+item.name());
            System.out.print(", packing: "+item.packing().pack());
            System.out.println(", price: "+item.price());
        }
    }
}
