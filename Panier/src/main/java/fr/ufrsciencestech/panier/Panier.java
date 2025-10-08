package fr.ufrsciencestech.panier;

import java.util.*;
/**
 * Classe Panier stockant et gérant un ensemble de fruits (oranges, bananes, ...). Chaque panier possède une contenance maximale. 
 * @author roudet
 *  
 */
public class Panier {

    /**
     * Liste des fruits constituant le panier
     */	
    private ArrayList<Fruit> fruits;  
    
    /**
     * Nombre maximum d'oranges que peut contenir le panier
     */	
    private int contenanceMax;     
	
    //méthodes à écrire 
    /**
     * Initialise un panier vide en précisant sa contenance maximale.
     * @param contenanceMax La contenance maximale
     */	
    public Panier(int contenanceMax){  
	      //à compléter
    }

    /**
     * Méthode héritée de la classe Object pour l'affichage de ce qui est contenu dans le panier : liste des fruits presents.
     * @return La chaîne de caractère à afficher.
     */
    @Override
    public String toString(){  
        String s = "Le panier contient : ";
        for(int i = 0; i < this.fruits.size(); i++) //parcourt la liste de fruits du panier
        {
            s += fruits.get(i).toString();          //écrit la description des fruits
            s += "\n";
        }
        return s;
    }
    
    /**
     * Accesseur à la liste des fruits.
     * @return La liste de fruits.
     */
    public ArrayList<Fruit> getFruits() {  
       return null;  //à modifier
    }

    /**
     * Modificateur de la liste des fruits.
     * @param fruits La nouvelle liste de fruits.
     */
    public void setFruits(ArrayList<Fruit> fruits) { 
        //à compléter
    }

    /**
     * Accesseur au nombre de fruits présents dans le panier.
     * @return Le nombre de fruits présents dans le panier.
     */
    public int getNbFruits(){  
      return 0;  //à modifier
    }
    
    /**
     * Accesseur au nombre maximum de fruits que le panier peut stocker.
     * @return La contenance maximal du panier.
     */
    public int getContenanceMax(){  
	    return 0;  //à modifier
    }

    /**
     * Accesseur au fruit stocké dans le panier à l'emplacement n°i ou "null" s'il n'y a rien à cet emplacement
     * @param i La position du fruit dans le panier.
     * @return Le fruit à l'emplacement n°i ou "null" s'il n'y a rien à cet emplacement
     */
    public Fruit getFruit(int i){  
	    return null;   //à modifier
    }
    
    /**
     * Modificateur du fruit stocké dans le panier à l'emplacement n°i : 
     * le remplacer par f (s'il y a bien dejà un fruit à cet emplacement, ne rien faire sinon)
     * @param i La position du fruit dans le panier.
     * @param f Le nouveau fruit à remplacer.
     */
    public void setFruit(int i, Fruit f){  
          //à compléter
    }
    
    /**
     * Prédicat testant si le panier est vide
     * @return 
     */ 
    public boolean estVide(){
	    return fruits.isEmpty();  
    }
    
    /**
     * Prédicat testant si le panier est plein
     * @return 
     */ 
    public boolean estPlein(){  
	    return fruits.size()== this.contenanceMax; 
    }

    /**
     * Méthode qui ajoute le fruit o à la fin du panier si celui-ci n'est pas plein
     * @param o Le fruit à ajouter dans le panier.
     * @throws PanierPleinException Si le panier est plein
     */
    public void ajoute(Fruit o) throws PanierPleinException{  
        if(!this.estPlein())                      //vérifie si le panier est plein
            fruits.add(o);                        //ajout d'un fruit o à la liste de fruir du panier
        else 
            throw new PanierPleinException();
    }
    
    /**
     * Méthode qui ajoute un fruit par défaut (une orange) à la fin du panier si celui-ci n'est pas plein
     * @throws PanierPleinException Si le panier est plein
     */
    public void ajoute() throws PanierPleinException{
       //à compléter
    }

    /**
     * Méthode qui retire le dernier fruit du panier si celui-ci n'est pas vide
     * @throws PanierVideException Si le panier est vide
     */
    public void retrait() throws PanierVideException{ 
         //à compléter
    }

    /**
     * Méthode qui calcule le prix du panier par addition des prix de tous les fruits contenus dedans
     * @return Le prix du panier
     */
    public double getPrix(){  
	    return 0;  //à modifier
    }
    
    /**
     * Méthode qui supprime du panier tous les fruits provenant du pays origine indiqué en paramètre
     * @param origine Le pays d'origine à boycotter
     */
    public void boycotteOrigine(String origine){ 
	    //à compléter
    }  
          
    /**
     * Prédicat hérité de la classe Object pour comparer this et l'objet passé en paramètre.
     * On considérera que deux paniers sont équivalents s'ils contiennent exactement les memes fruits.
     * @param o L'objet à comparer avec this
     * @return Le résultat de la comparaison entre this et o (true si les deux sont équivalents, false sinon)
     */ 
    @Override
    public boolean equals(Object o){  
        return false;    //à modifier
    }
    
    //tests POUR TOUS
    public static void main (String[] args){
	      System.out.println("premier test Panier");
	      //à compléter
    }
}
