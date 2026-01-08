package fr.ufrsciencestech.panier.Model.fruit;

public interface Fruit {
     boolean isSeedless();
     double getPrice();
     String getOriginCountry();
     String getName();

     @Override
     String toString();

     @Override
     boolean equals(Object o);
}
