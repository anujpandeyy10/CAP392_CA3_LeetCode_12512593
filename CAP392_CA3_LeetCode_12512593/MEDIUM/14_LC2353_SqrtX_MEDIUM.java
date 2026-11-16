CAP392_CA3_LeetCode
Q2353

import java.util.*;

class FoodRatings {

    class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    HashMap<String, Food> foodMap;
    HashMap<String, TreeSet<Food>> cuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {

            Food food = new Food(foods[i], cuisines[i], ratings[i]);

            foodMap.put(foods[i], food);

            cuisineMap.putIfAbsent(cuisines[i],
                    new TreeSet<>((a, b) -> {
                        if (a.rating != b.rating)
                            return b.rating - a.rating; // higher rating first
                        return a.name.compareTo(b.name); // lexicographically smaller first
                    }));

            cuisineMap.get(cuisines[i]).add(food);
        }
    }

    public void changeRating(String food, int newRating) {

        Food f = foodMap.get(food);

        TreeSet<Food> set = cuisineMap.get(f.cuisine);

        set.remove(f);

        f.rating = newRating;

        set.add(f);
    }

    public String highestRated(String cuisine) {

        return cuisineMap.get(cuisine).first().name;
    }
}

