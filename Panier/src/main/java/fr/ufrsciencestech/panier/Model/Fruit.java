package fr.ufrsciencestech.panier.Model;

public interface Fruit {
     boolean isSeedless();
     double getPricePerKilogram();
     String getOriginCountry();

     @Override
     String toString();

     @Override
     boolean equals(Object o);
}
