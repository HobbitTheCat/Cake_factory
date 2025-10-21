package fr.ufrsciencestech.panier;

public class Orange extends FruitSimple {
    /**
     * Ce constructeur par défaut produit une orange provenant d'Espagne à 0.5 euro.
     */	
     //JML :
     //@ ensures this.prix_au_kilo != null && this.pays_origine != null;
    public Orange() 
    {
        this.prix_au_kilo = 0.5;  //prix en euros
        this.pays_origine = "Espagne";
    }
    
    /**
     * Ce constructeur donne la possibilité de produire une orange en précisant son origine et son prix au kilo (en euros).
     * @param prix
     * @param origine
     */
     //JML :
     //@ ensures this.prix_au_kilo > 0 && !this.pays_origine.equals("");
    public Orange(double prix, String origine) 
    {
	      initAttributs(prix, origine);
	      if(origine.equals(""))
            this.pays_origine="Espagne";  //Espagne par défaut  
    }
 
    /**
     * Modificateur de l'origine de l'orange.
     * @param origine La nouvelle origine (pays) de l'orange
     */
     //JML :
     //@ requires origine != null && !origine.equals("");
     //@ ensures origine.equals(this.pays_origine)
    @Override
    public void setOrigine(String origine){
        if(origine.equals(""))
            this.pays_origine="Espagne";  //Espagne par défaut  
        else
            this.pays_origine=origine;
    }

    /**
     * Méthode héritée de la classe Object pour l'affichage d'une orange sous forme de chaîne de caractères.
     * @return La chaîne de caractère à afficher.
     */
     //JML :
     //@ ensures \result != null;
    @Override
    public String toString(){
        return "Orange de " + getOrigine() + " a " + getPrix() + " euros";
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
            return (prix_au_kilo == or.prix_au_kilo && pays_origine.equals(or.pays_origine));
        }
        return false;
    }

    /**
     * Prédicat précisant si le fruit orange est sans pépin.
     * Pour simplifier, on considère que ce fruit aura toujours des pépins.
     * @return false car l'orange n'est pas sans pépin (elle en a)
     */
    @Override
    public boolean estSansPepin() {  //predicat indiquant qu'une orange a des pepins
        return false;
    }

}
