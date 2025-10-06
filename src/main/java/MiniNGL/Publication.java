package MiniNGL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Publication {
    private String identifiantPublication;
    private Utilisateur proprietaire;
    private List<Message> messages;

    public Publication(String identifiantPublication, Utilisateur proprietaire) {
        this.identifiantPublication = identifiantPublication;
        this.proprietaire = proprietaire;
        this.messages = new ArrayList<>();
    }

    public void ajouterMessage(Message message) {
        messages.add(message);
    }

    public void afficherAuteursMessages() {
        Set<Utilisateur> auteursUniques = new HashSet<>();

        for (Message message : messages) {
            auteursUniques.add(message.getAuteur());
        }

        for (Utilisateur auteur : auteursUniques) {
            auteur.afficherInfo();
        }
    }

    public String getIdentifiantPublication() { return identifiantPublication; }
    public Utilisateur getProprietaire() { return proprietaire; }
    public List<Message> getMessages() { return messages; }
}