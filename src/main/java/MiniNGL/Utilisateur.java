package MiniNGL;
public abstract class Utilisateur {
    protected String identifier;

    public Utilisateur(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public abstract void displayInfo();
}
