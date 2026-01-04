package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.cake.Cake;
import fr.ufrsciencestech.panier.Model.cake.CakeBuilder;
import fr.ufrsciencestech.panier.Model.fruit.Banana;
import fr.ufrsciencestech.panier.Model.fruit.Orange;
import fr.ufrsciencestech.panier.Model.strategy.FruitSaladStrategy;

public class Main {
    public static void main(String args[]){
        Cake cake = new CakeBuilder("Pâte Sablé",10.0)
                .addCreamLayer("Patissière",1.5)
                .addFruitLayer(new FruitSaladStrategy(),new Orange(),new Banana())
                .addToppingLayer("pépite de chocolat",75)
                .build();
        System.out.println(cake.toString());
        System.out.println(cake.getPrice());

        Cake cake1 = new CakeBuilder().addCreamLayer("Patissière",1.5).build();
        System.out.println(cake1.toString());
        System.out.println(cake1.getPrice());
    }

}
