package com.designPattern.old.builder.demo;

import com.designPattern.old.builder.sub.child.ChickenBurger;
import com.designPattern.old.builder.sub.child.Coke;
import com.designPattern.old.builder.sub.child.Pepsi;
import com.designPattern.old.builder.sub.child.VegBurger;

/**
 * Created by Brian in 19:22 2018/5/2
 */
public class MealBuilder {
    public Meal prepareVegMeal(){
        Meal vegMeal = new Meal();
        vegMeal.addItems(new VegBurger());
        vegMeal.addItems(new Coke());

        return vegMeal;
    }

    public Meal prepareNonVegMeal(){
        Meal nonVegMeal = new Meal();
        nonVegMeal.addItems(new ChickenBurger());
        nonVegMeal.addItems(new Pepsi());

        return nonVegMeal;
    }
}
