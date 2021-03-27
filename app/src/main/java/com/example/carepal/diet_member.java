package com.example.carepal;

public class diet_member {
    String FoodName;
    Float calorie;

    public diet_member() {
        FoodName = null;
        calorie = null;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        this.FoodName = foodName;
    }

    public Float getCalorie() {
        return calorie;
    }

    public void setCalorie(Float calorie) {
        this.calorie = calorie;
    }
    public String toString(){
        return ("Food Name: "+FoodName+"\nTotal Calorie: "+calorie);
    }
}
