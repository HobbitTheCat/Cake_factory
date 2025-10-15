package fr.ufrsciencestech.panier;

/**
 * Classe FruitSimple servant à définir des attributs et méthodes communs à tous les fruits simples
 * @author roudet
 *  
 */
public abstract class FruitSimple implements Fruit {
    /**
     * Le prix du fruit au kilo (en euros)
     */	
    protected double prix_au_kilo;
    
    /**
     * Le pays d'origine du fruit
     */	
    protected String pays_origine;
    
    //Accesseurs
    /**
     * Accesseur du prix du fruit au kilo
     * @return La valeur du prix.
     */
     //JML :
     //@ ensures \result == prix_au_kilo;
    @Override
    public double getPrix(){
	    return prix_au_kilo;
    }
    
    /**
     * Accesseur du pays d'origine du fruit
     * @return Le pays d'origine (chaîne de caractères).
     */
     //JML :
     //@ ensures \result == pays_origine;
     @Override
     public String getOrigine(){
	     return pays_origine;
    }
    
    //Modificateurs
    /*** Modificateur du prix de l'orange.
     * @param prix Le nouveau prix.*/
     //JML :
     //@ ensures this.prix_au_kilo > 0;
    public void setPrix(double prix){
	      if(prix < 0)
	        this.prix_au_kilo = -prix;  //une solution possible pour interdire les prix negatifs
	      else
	        this.prix_au_kilo = prix;
    }
 
    /**
     * Modificateur du pays d'origine du fruit
     * @param origine La nouvelle origine (pays).
     */
     //JML :
     //@ requires origine != null && !origine.equals("");
     //@ ensures origine.equals(this.pays_origine)
    public void setOrigine(String origine){
	      this.pays_origine=origine;
    }
    
    /**
     * Méthode utilisée dans les constructeurs des fruits (classes non abstraites)
     * @param prix
     * @param origine
     */	
    protected void initAttributs(double prix, String origine){
        if(prix < 0){   //interdire de créer un fruit ayant un prix au kilo négatif
            this.prix_au_kilo = -prix;  //ou = 0
            //ou throw new Exception();
            //ou gestion avec JML
	      } 
	      else
            this.prix_au_kilo = prix;
            
        this.pays_origine = origine;
    }
    
    /**
     * Prédicat d'équivalence entre deux fruits simples
     * @param o L'objet avec lequel comparer this
     * @return true si o et this sont équivalents
     */
    @Override
    public boolean equals(Object o){
        if(o != null && getClass() == o.getClass()){
            FruitSimple fs = (FruitSimple) o;
            return (prix_au_kilo == fs.prix_au_kilo && pays_origine.equals(fs.pays_origine));
        }
        return false;
    }
  
    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }

    @Override
    public abstract boolean estSansPepin();
}
