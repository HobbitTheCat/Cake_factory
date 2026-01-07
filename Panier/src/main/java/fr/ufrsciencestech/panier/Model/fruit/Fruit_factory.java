/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.Model.fruit;

/**
 *
 * @author kelian
 */
public class Fruit_factory {
    
    public static SimpleFruit createFruit(String fruitType, double price, String origin){
        switch (fruitType){
            case "Orange": return new Orange(price, origin);
            case "Banana": return new Banana(price, origin);
            case "Cherry": return new Cherry(price, origin);
            case "Pineapple": return new Pineapple(price, origin);
            case "Raspberry": return new Raspberry(price, origin);
            case "Apple": return new Apple(price, origin);
            default: return new Orange();
        }
    }
    
    public static SimpleFruit createFruit(String fruitType){
        switch (fruitType){
            case "Orange": return new Orange();
            case "Banana": return new Banana();
            case "Cherry": return new Cherry();
            case "Pineapple": return new Pineapple();
            case "Raspberry": return new Raspberry();
            case "Apple": return new Apple();
            default: return new Orange();
        }
    }
    
}
