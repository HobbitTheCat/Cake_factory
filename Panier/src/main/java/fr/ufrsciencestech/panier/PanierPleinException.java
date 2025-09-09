package fr.ufrsciencestech.panier;

/**
 * Classe d'Exception personnalisée : lorsqu'un panier est plein
 * @author roudet
 */
public class PanierPleinException extends Exception {
    
    public PanierPleinException()
    {
	super("Ajout impossible car le panier est plein !");
    }

}
