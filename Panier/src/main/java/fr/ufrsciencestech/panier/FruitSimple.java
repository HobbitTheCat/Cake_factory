public abstract class FruitSimple implements Fruit {
    /**
     * Le prix du fruit au kilo (en euros)
     */	
    protected double price;
    
    /**
     * Le pays d'origine du fruit
     */	
    protected String country;
    
    //Accesseurs
    /**
     * Accesseur du prix du fruit au kilo
     * @return La valeur du prix.
     */
     //JML :
     //@ ensures \result == price;
    @Override
    public double getPrice(){
	    return price;
    }
    
    /**
     * Accesseur du pays d'origine du fruit
     * @return Le pays d'origine (chaîne de caractères).
     */
     //JML :
     //@ ensures \result == country;
     @Override
     public String getCountry(){
	     return country;
    }
    
    //Modificateurs
    /**
     * Modificateur du prix de l'orange.
     * @param price Le nouveau prix.
     */
     //JML :
     //@ ensures this.price > 0;
    public void setPrice(double price){
	      if(price < 0)
	        this.price = -price;  //une solution possible pour interdire les prix negatifs
	      else
	        this.price = price;
    }
 
    /**
     * Modificateur du pays d'origine du fruit
     * @param country La nouvelle origine (pays).
     */
     //JML :
     //@ requires country != null && !country.equals("");
     //@ ensures country.equals(this.country)
    public void setCountry(String country){
	      this.country=country;
    }
    
    /**
     * Méthode utilisée dans les constructeurs des fruits (classes non abstraites)
     */	
    protected void initAttributes(double price, String country){
        if(price < 0){   //interdire de créer un fruit ayant un prix au kilo négatif
            this.price = -price;  //ou = 0
            //ou throw new Exception();
            //ou gestion avec JML
	      } 
	      else
            this.price = price;
            
        this.country = country;
    }
    
    @Override
    public boolean equals(Object o){
        if(o != null && getClass() == o.getClass()){
            FruitSimple fs = (FruitSimple) o;
            return (price == fs.price && country.equals(fs.country));
        }
        return false;
    }
  
    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }

    @Override
    public abstract boolean isSeedless();
}
