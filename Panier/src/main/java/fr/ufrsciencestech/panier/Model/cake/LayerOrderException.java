package fr.ufrsciencestech.panier.Model.cake;

public class LayerOrderException extends RuntimeException {
    public LayerOrderException(String message) {
        super(message+ " Wrong LayerOrder.");
    }
}
