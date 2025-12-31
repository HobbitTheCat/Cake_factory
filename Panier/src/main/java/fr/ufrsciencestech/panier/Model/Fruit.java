package fr.ufrsciencestech.panier.Model;

public interface Fruit {
     boolean isSeedless();
     double getPrice();
     String getOriginCountry();

     @Override
     String toString();

     @Override
     boolean equals(Object o);
}
