/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;

    /**
     * 
     * @author kelian
     */

public class Framboise extends FruitSimple {
    /**
     * Ce constructeur par défaut produit une Framboise provenant de France à 1 euro.
     */	
     //JML :
     //@ ensures this.prix_au_kilo != null && this.pays_origine != null;
    public Framboise() 
    {
        this.prix_au_kilo = 1;  //prix en euros
        this.pays_origine = "France";
    }
    
    /**
     * Ce constructeur donne la possibilité de produire une Framboise en précisant son origine et son prix au kilo (en euros).
     * @param prix
     * @param origine
     */
     //JML :
     //@ ensures this.prix_au_kilo > 0 && !this.pays_origine.equals("");
    public Framboise(double prix, String origine) 
    {
	initAttributs(prix, origine);
	if(origine.equals(""))
            this.pays_origine="France";  //France par défaut  
    }
 
    /**
     * Modificateur de l'origine de la Framboise.
     * @param origine La nouvelle origine (pays) de la Framboise
     */
     //JML :
     //@ requires origine != null && !origine.equals("");
     //@ ensures origine.equals(this.pays_origine)
    @Override
    public void setOrigine(String origine){
        if(origine.equals(""))
            this.pays_origine="France";  //France par défaut  
        else
            this.pays_origine=origine;
    }

    /**
     * Méthode héritée de la classe Object pour l'affichage d'une Framboise sous forme de chaîne de caractères.
     * @return La chaîne de caractère à afficher.
     */
     //JML :
     //@ ensures \result != null;
    @Override
    public String toString(){
        return "Framboise de " + getOrigine() + " à " + getPrix() + " euros";
    }

    /**
     * Prédicat hérité de la classe Object pour comparer this et l'objet passé en paramètre.
     * On considérera que deux Framboises sont équivalentes si leur origine et leur prix sont les mêmes.
     * @param f L'objet à comparer avec this
     * @return Le résultat de la comparaison entre this et f (true si les deux sont équivalents, false sinon)
     */
    @Override
    public boolean equals(Object f){  //predicat pour tester si 2 Framboises sont equivalentes
        if(f != null && getClass() == f.getClass()){
            Framboise fr = (Framboise) f;
            return (prix_au_kilo == fr.prix_au_kilo && pays_origine.equals(fr.pays_origine));
        }
        return false;
    }

    /**
     * Prédicat précisant si le fruit Framboise est sans pépin.
     * Pour simplifier, on considère que ce fruit n'aura jamais de pépins.
     * @return true car la Framboise est sans pépin
     */
    @Override
    public boolean estSansPepin() {  //predicat indiquant qu'une Framboise n'a pas de pepins
        return true;
    }
}
