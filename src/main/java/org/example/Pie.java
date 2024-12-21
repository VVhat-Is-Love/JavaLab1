package org.example;

import java.util.Map;

public class Pie implements Nutritious {
    private final String filling; // Начинка
    private final int calories;   // Калорийность

    // Возможные начинки и их калорийность
    private static final Map<String, Integer> VALID_FILLINGS = Map.of(
            "вишнёвая", 300,
            "клубничная", 250,
            "яблочная", 200
    );

    public Pie(String filling) {
        if (!VALID_FILLINGS.containsKey(filling.toLowerCase())) {
            throw new IllegalArgumentException("Недопустимая начинка: " + filling);
        }
        this.filling = filling.toLowerCase();
        this.calories = VALID_FILLINGS.get(this.filling);
    }

    public String getFilling() {
        return filling;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public int calculateCalories() {
        return calories;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pie pie = (Pie) obj;
        return filling.equalsIgnoreCase(pie.filling);
    }

    @Override
    public String toString() {
        return "Pie{" +
                "filling='" + filling + '\'' +
                ", calories=" + calories +
                '}';
    }
}
