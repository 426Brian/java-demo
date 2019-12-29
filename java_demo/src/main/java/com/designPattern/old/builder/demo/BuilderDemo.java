package com.designPattern.old.builder.demo;

/**
 * Created by Brian in 19:25 2018/5/2
 */
public class BuilderDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("vegMeal");
        vegMeal.showItems();
        System.out.println("total price: "+vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n nonVegMeal");
        nonVegMeal.showItems();
        System.out.println("total price: "+nonVegMeal.getCost());
    }
}
