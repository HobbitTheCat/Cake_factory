package fr.ufrsciencestech.panier.Model;


public abstract class SimpleFruit implements Fruit {
    protected double price_kilogram;
    protected String origin;

    // Template method
    protected abstract String getDefaultOrigin();
    protected abstract double getDefaultPrice();

    public SimpleFruit() {
        this.setPrice(getDefaultPrice());
        this.setOrigin(getDefaultOrigin());
    }
    public SimpleFruit(double price, String origin) {
        this.setPrice(price <= 0 ? getDefaultPrice(): price);
        this.setOrigin(origin == null || origin.isEmpty() ? getDefaultOrigin() : origin);
    }

    @Override
    public double getPricePerKilogram() {return this.price_kilogram;}
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
        return (this.getPricePerKilogram() == other.getPricePerKilogram() &&
                    this.getOriginCountry().equals(other.getOriginCountry()));
    }

    @Override
    public String toString() {return this.getClass().getSimpleName();}

    @Override
    public abstract  boolean isSeedless();
}