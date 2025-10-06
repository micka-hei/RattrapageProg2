package MiniNGL;

public class UtilisateurInscrit extends Utilisateur {
    private String prenom;
    private String nom;
    private String email;

    public UtilisateurInscrit(String identifiant, String prenom, String nom, String email) {
        super(identifiant);
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    @Override
    public void afficherInfo() {
        System.out.println("ID: " + identifiant + ", Nom: " + prenom + " " + nom + ", Email: " + email);
    }

    public String getPrenom() { return prenom; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }

    @Override
    public void displayInfo() {

    }
}

