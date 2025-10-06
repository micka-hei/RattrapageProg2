package MiniNGL;

public class UtilisateurAnonyme extends Utilisateur {

    public UtilisateurAnonyme(String identifiant) {
        super(identifiant);
    }

    @Override
    public void afficherInfo() {
        System.out.println("Utilisateur Anonyme ID: " + identifiant);
    }
}