package fr.ufrsciencestech.panier.Model.fruit;


public abstract class SimpleFruit implements Fruit {
    protected double price_kilogram;
    protected String origin;
    
    public static Fruit createFruit(String fruitType, double price, String origin){
        switch (fruitType){
            case "Orange": return new Orange(price, origin);
            case "Banana": return new Banana(price, origin);
            case "Cherry": return new Cherry(price, origin);
            case "Pineapple": return new Pineapple(price, origin);
            case "Raspberry": return new Raspberry(price, origin);
            default: return new Orange();
        }
    }
    
    public static Fruit createFruit(String fruitType){
        switch (fruitType){
            case "Orange": return new Orange();
            case "Banana": return new Banana();
            case "Cherry": return new Cherry();
            case "Pineapple": return new Pineapple();
            case "Raspberry": return new Raspberry();
            default: return new Orange();
        }
    }
    
    

    // Template method
    protected abstract String getDefaultOrigin();
    protected abstract double getDefaultPrice();

    public SimpleFruit() {
        this.setPrice(getDefaultPrice());
        this.setOrigin(getDefaultOrigin());
    }
    public SimpleFruit(double price, String origin) {
        this.setPrice(price <= 0 ? -price: price);
        this.setOrigin(origin == null || origin.isEmpty() ? getDefaultOrigin() : origin);
    }

    @Override
    public double getPrice() {return this.price_kilogram;}
    @Override
    public String getOriginCountry() {return this.origin;}

    public void setPrice(double price_kilogram) {
        if (price_kilogram < 0) this.price_kilogram = -price_kilogram;
        else this.price_kilogram = price_kilogram;
    }
    public void setOrigin(String origin) {this.origin = origin;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SimpleFruit other = (SimpleFruit) o;
        return (this.getPrice() == other.getPrice() &&
                    this.getOriginCountry().equals(other.getOriginCountry()));
    }

    @Override
    public String toString() {return this.getClass().getSimpleName();}

    @Override
    public abstract  boolean isSeedless();
}