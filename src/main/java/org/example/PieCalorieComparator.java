package org.example;

import java.util.Comparator;

public class PieCalorieComparator implements Comparator<Pie> {
    @Override
    public int compare(Pie p1, Pie p2) {
        return Integer.compare(p1.getCalories(), p2.getCalories());
    }
}
