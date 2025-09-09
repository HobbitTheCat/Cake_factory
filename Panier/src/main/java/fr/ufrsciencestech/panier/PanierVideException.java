package fr.ufrsciencestech.panier;

/**
 * Classe d'Exception personnalisée : lorsqu'un panier est vide
 * @author roudet
 */
public class PanierVideException extends Exception {
    public PanierVideException()
    {
	super("Suppression impossible car le panier est vide !");
    }
}
