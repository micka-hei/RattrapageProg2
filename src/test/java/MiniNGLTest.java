import MiniNGL.Message;
import MiniNGL.Publication;
import MiniNGL.UtilisateurAnonyme;
import MiniNGL.UtilisateurInscrit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class TestPublication {
    private Publication publication;
    private UtilisateurInscrit utilisateurInscrit;
    private UtilisateurAnonyme utilisateurAnonyme1;
    private UtilisateurAnonyme utilisateurAnonyme2;

    @BeforeEach
    void initialiser() {
        utilisateurInscrit = new UtilisateurInscrit("user123", "Jean", "Dupont", "jean.dupont@email.com");
        utilisateurAnonyme1 = new UtilisateurAnonyme("anonyme456");
        utilisateurAnonyme2 = new UtilisateurAnonyme("anonyme789");
        publication = new Publication("pub001", utilisateurInscrit);
    }

    @Test
    void testCreationPublication() {
        assertNotNull(publication);
        assertEquals("pub001", publication.getIdentifiantPublication());
        assertEquals(utilisateurInscrit, publication.getProprietaire());
        assertTrue(publication.getMessages().isEmpty());
    }

    @Test
    void testAjoutMessagesUtilisateursDifferents() {
        Message message1 = new Message("Premier message de l'utilisateur inscrit", false, utilisateurInscrit);
        Message message2 = new Message("Question anonyme", true, utilisateurAnonyme1);
        Message message3 = new Message("Autre message anonyme", false, utilisateurAnonyme2);
        Message message4 = new Message("Deuxième message de l'utilisateur inscrit", false, utilisateurInscrit);

        publication.ajouterMessage(message1);
        publication.ajouterMessage(message2);
        publication.ajouterMessage(message3);
        publication.ajouterMessage(message4);

        List<Message> messages = publication.getMessages();
        assertEquals(4, messages.size());
        assertEquals(utilisateurInscrit, messages.get(0).getAuteur());
        assertEquals(utilisateurAnonyme1, messages.get(1).getAuteur());
        assertEquals(utilisateurAnonyme2, messages.get(2).getAuteur());
        assertEquals(utilisateurInscrit, messages.get(3).getAuteur());
    }

    @Test
    void testProprietesMessage() {
        Message messageConfidentiel = new Message("Message secret", true, utilisateurAnonyme1);
        Message messagePublic = new Message("Message public", false, utilisateurInscrit);

        assertTrue(messageConfidentiel.isConfidentiel());
        assertFalse(messagePublic.isConfidentiel());
        assertEquals("Message secret", messageConfidentiel.getTexte());
        assertEquals("Message public", messagePublic.getTexte());
        assertNotNull(messageConfidentiel.getDateCreation());
        assertNotNull(messagePublic.getDateCreation());
    }

    @Test
    void testHierarchieUtilisateurs() {
        Utilisateur user1 = new UtilisateurInscrit("userInscrit", "Alice", "Martin", "alice@test.com");
        Utilisateur user2 = new UtilisateurAnonyme("userAnonyme");

        assertTrue(user1 instanceof Utilisateur);
        assertTrue(user2 instanceof Utilisateur);
        assertTrue(user1 instanceof UtilisateurInscrit);
        assertTrue(user2 instanceof UtilisateurAnonyme);
    }

    @Test
    void testAffichageAuteursUtilisateursMixtes() {
        Message msg1 = new Message("Bonjour", false, utilisateurInscrit);
        Message msg2 = new Message("Question", true, utilisateurAnonyme1);
        Message msg3 = new Message("Commentaire", false, utilisateurAnonyme2);
        Message msg4 = new Message("Réponse", false, utilisateurInscrit);

        publication.ajouterMessage(msg1);
        publication.ajouterMessage(msg2);
        publication.ajouterMessage(msg3);
        publication.ajouterMessage(msg4);

        System.out.println("=== Affichage des auteurs uniques ===");
        publication.afficherAuteursMessages();
    }

    @Test
    void testIdentifiantsUtilisateurs() {
        assertEquals("user123", utilisateurInscrit.getIdentifiant());
        assertEquals("anonyme456", utilisateurAnonyme1.getIdentifiant());
        assertEquals("anonyme789", utilisateurAnonyme2.getIdentifiant());
    }

    @Test
    void testMessagesConfidentiels() {
        Message messageNormal = new Message("Message normal", false, utilisateurInscrit);
        Message messageSecret = new Message("Message secret", true, utilisateurAnonyme1);

        publication.ajouterMessage(messageNormal);
        publication.ajouterMessage(messageSecret);

        assertEquals(2, publication.getMessages().size());
        assertFalse(publication.getMessages().get(0).isConfidentiel());
        assertTrue(publication.getMessages().get(1).isConfidentiel());
    }
}
