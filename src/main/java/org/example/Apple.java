package org.example;
public class Apple implements Nutritious {
    private final String type; // Тип яблока
    private final int calories; // Калорийность яблока

    public Apple() {
        this.type = "яблоко"; // Стандартное название
        this.calories = 500; // Установим калорийность яблока
    }

    public String getType() {
        return type;
    }

    @Override
    public int calculateCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "type='" + type + '\'' +
                ", calories=" + calories +
                '}';
    }
}
