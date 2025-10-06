package MiniNGL;

import java.time.LocalDateTime;

public class Message {
    private String texte;
    private LocalDateTime dateCreation;
    private boolean confidentiel;
    private Utilisateur auteur;

    public Message(String texte, boolean confidentiel, Utilisateur auteur) {
        this.texte = texte;
        this.confidentiel = confidentiel;
        this.auteur = auteur;
        this.dateCreation = LocalDateTime.now();
    }

    public String getTexte() { return texte; }
    public LocalDateTime getDateCreation() { return dateCreation; }
    public boolean isConfidentiel() { return confidentiel; }
    public Utilisateur getAuteur() { return auteur; }
}