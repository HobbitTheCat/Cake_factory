package fr.ufrsciencestech.panier;

public class Orange extends FruitSimple {
    /**
     * Ce constructeur par défaut produit une orange provenant d'Espagne à 0.5 euro.
     */	
     //JML :
     //@ ensures this.price != null && this.country != null;
    public Orange() 
    {
        this.price = 0.5;  //prix en euros
        this.country = "Espagne";
    }
    
    /**
     * Ce constructeur donne la possibilité de produire une orange en précisant son origine et son prix au kilo (en euros).
     */
     //JML :
     //@ ensures this.price > 0 && !this.country.equals("");
    public Orange(double price, String country) 
    {
	      initAttributes(price, country);
	      if(country.equals(""))
            this.country="Espagne";  //Espagne par défaut  
    }
 
    /**
     * Modificateur de l'origine de l'orange.
     * @param country La nouvelle origine (pays) de l'orange
     */
     //JML :
     //@ requires country != null && !country.equals("");
     //@ ensures country.equals(this.country)
    @Override
    public void setCountry(String country){
        if(country.equals(""))
            this.country="Espagne";  //Espagne par défaut  
        else
            this.country=country;
    }

    /**
     * Méthode héritée de la classe Object pour l'affichage d'une orange sous forme de chaîne de caractères.
     * @return La chaîne de caractère à afficher.
     */
     //JML :
     //@ ensures \result != null;
    @Override
    public String toString(){
        return "Orange de " + getCountry() + " a " + getPrice() + " euros";
    }

    /**
     * Prédicat hérité de la classe Object pour comparer this et l'objet passé en paramètre.
     * On considérera que deux oranges sont équivalentes si leur origine et leur prix sont les mêmes.
     * @param o L'objet à comparer avec this
     * @return Le résultat de la comparaison entre this et o (true si les deux sont équivalents, false sinon)
     */
    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 oranges sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Orange or = (Orange) o;
            return (price == or.price && country.equals(or.country));
        }
        return false;
    }

    /**
     * Prédicat précisant si le fruit orange est sans pépin.
     * Pour simplifier, on considère que ce fruit aura toujours des pépins.
     * @return false car l'orange n'est pas sans pépin (elle en a)
     */
    @Override
    public boolean isSeedless() {  //predicat indiquant qu'une orange a des pepins
        return false;
    }


    /**
     * Cette méthode est le point d'entrée de notre programme.
     * Elle servira aux tests, avant d'avoir abordé les tests unitaires.
     */
    public static void main (String[] args){
        //Ecrire ici vos tests
	      System.out.println("premier test Orange");
   }
}
