package fr.ufrsciencestech.panier;

public class Banane extends FruitSimple {
    /**
     * Ce constructeur par défaut produit une banane provenant du Cameroun à 0.5 euro.
     */	
     //JML :
     //@ ensures this.prix_au_kilo != null && this.pays_origine != null;
    public Banane() 
    {
        this.prix_au_kilo = 0.5;  //prix en euros
        this.pays_origine = "Cameroun";
    }
    
    /**
     * Ce constructeur donne la possibilité de produire une banane en précisant son origine et son prix au kilo (en euros).
     * @param prix
     * @param origine
     */
     //JML :
     //@ ensures this.prix_au_kilo > 0 && !this.pays_origine.equals("");
    public Banane(double prix, String origine) 
    {
	      initAttributs(prix, origine);
	      if(origine.equals(""))
            this.pays_origine="Cameroun";  //Cameroun par défaut  
    }
 
    /**
     * Modificateur de l'origine de la banane.
     * @param origine La nouvelle origine (pays) de la banane.
     */
     //JML :
     //@ requires origine != null && !origine.equals("");
     //@ ensures origine.equals(this.pays_origine)
    @Override
    public void setOrigine(String origine){
        if(origine.equals(""))
            this.pays_origine="Cameroun";  //Espagne par défaut  
        else
            this.pays_origine=origine;
    }


    /**
     * Méthode héritée de la classe Object pour l'affichage d'une banane sous forme de chaîne de caractères.
     * @return La chaîne de caractère à afficher.
     */
     //JML :
     //@ ensures \result != null;
    @Override
    public String toString(){
        return "Banane de " + getOrigine() + " a " + getPrix() + " euros";
    }

    /**
     * Prédicat hérité de la classe Object pour comparer this et l'objet passé en paramètre.
     * On considérera que deux oranges sont équivalentes si leur origine et leur prix sont les mêmes.
     * @param o L'objet à comparer avec this
     * @return Le résultat de la comparaison entre this et o (true si les deux sont équivalents, false sinon)
     */
    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 bananes sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Banane or = (Banane) o;
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
    public boolean estSansPepin() {  //predicat indiquant qu'une banane n'a pas de pepins
        return true;
    }


    /**
     * Cette méthode est le point d'entrée de notre programme.
     * Elle servira aux tests, avant d'avoir abordé les tests unitaires.
     * @param args
     */
    public static void main (String[] args){
        //Ecrire ici vos tests
	System.out.println("premier test Banane");
	      
	Banane bFr = new Banane(0.50,"France");
        Banane bBr = new Banane(0.60,"Bresil");
        Banane bCa = new Banane();
        Banane bCa2 = new Banane(-0.50,"");  //test du constructeur avec un prix negatif et une origine à ""
        
        //tests de la methode toString() :
        System.out.println("bFr : " + bFr);
        System.out.println("bBr : " + bBr);
        System.out.println("bCa : " + bCa);
        System.out.println("bCa2 : " + bCa2);
        
        //tests de la methode equals() et de setPrice() :
        System.out.println("bCa et bCa2 sont équivalentes, ce que démontre la méthode equals qui retourne : " + bCa.equals(bCa2));
        bCa2.setPrix(0.60);
        System.out.println("après le changement, bCa et bCa2 ne sont plus équivalentes, ce que confirme la méthode equals qui retourne : " + bCa.equals(bCa2));
        
        //tests de la methode setPrice() avec un prix negatif :
        bFr.setPrix(-0.60);
        System.out.println("bFr : " + bFr);
        
        //tests de la methode setCountry() avec une origine à "" :
        bFr.setOrigine("");
        System.out.println("bFr : " + bFr);
   }
}
