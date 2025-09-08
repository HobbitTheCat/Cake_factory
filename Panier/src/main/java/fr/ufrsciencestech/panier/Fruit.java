package fr.ufrsciencestech.panier;

public interface Fruit {
    /**
     * Prédicat précisant si le fruit orange est sans pépin.
     * Pour simplifier, on considère que ce fruit aura toujours des pépins.
     * @return false car l'orange n'est pas sans pépin (elle en a)
     */
    public boolean estSansPepin();  //predicat indiquant si le fruit a ou non des pepins
    
    /**
     * Accesseur du prix du fruit au kilo (en euros).
     * @return La valeur du prix.
     */
    public double getPrix();       
    
    /**
     * Accesseur du pays d'origine du fruit
     * @return Le pays d'origine (chaîne de caractères).
     */
    public String getOrigine();
     
    /**
     * Prédicat hérité de la classe Object pour comparer this et l'objet passé en paramètre.
     * On considérera que deux oranges sont équivalentes si leur origine et leur prix sont les mêmes.
     * @param o L'objet à comparer avec this
     * @return Le résultat de la comparaison entre this et o (true si les deux sont équivalents, false sinon)
     */
    @Override
    public boolean equals(Object o); 
    
    /**
     * Méthode héritée de la classe Object pour l'affichage d'une orange sous forme de chaîne de caractères.
     * @return La chaîne de caractère à afficher.
     */
    @Override
    public String toString();   
}
