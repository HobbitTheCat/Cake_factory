package fr.ufrsciencestech.panier.Model.fruit;

import java.util.List;

public interface Fruit {
     boolean isSeedless();
     double getPrice();
     String getOriginCountry();
     String getName();

     @Override
     String toString();

     @Override
     boolean equals(Object o);

     List<SimpleFruit> getIngredients();
}
