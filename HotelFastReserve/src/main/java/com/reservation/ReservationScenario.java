package com.reservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



import java.sql.Date;
import java.util.List;

public class ReservationScenario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HotelPU");
        EntityManager em = emf.createEntityManager();

        try {
            // Scénario 1 : Insérer un nouveau client dans la base
            insertNewClient(em);

            // Scénario 2 : Permettre à un client de réserver une chambre à une date précise
            reserveRoomForClient(em);

            // Scénario 3 : Annuler une réservation
            cancelReservation(em);

            // Scénario 4 : Retrouver toutes les réservations associées à un client particulier
            findReservationsForClient(em);

            // Scénario 5 : Lister toutes les chambres disponibles à une certaine date
            listAvailableRooms(em);
        } finally {
            // Fermer l'EntityManager à la fin
            em.close();
            emf.close();
        }
    }

    // Les autres méthodes restent inchangées avec l'utilisation de l'EntityManager
    private static void insertNewClient(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Client newClient = new Client();
        newClient.setNom("NomClient");
        newClient.setPrenom("PrenomClient");
        newClient.setEmail("client@example.com");
        newClient.setNumTel("123456789");

        em.persist(newClient);

        transaction.commit();
        
     // Afficher la liste des clients après l'insertion
        List<Client> clients = em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
        System.out.println("\nListe des clients après l'insertion :");
        for (Client client : clients) {
            System.out.println("Client ID: " + client.getClientID() +
                               ", Nom: " + client.getNom() +
                               ", Prénom: " + client.getPrenom());
        }
    }

    private static void reserveRoomForClient(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();


     
        Client client = em.find(Client.class, 1L);

       
        Chambre chambre = em.find(Chambre.class, 1L);
        
       
        
        // Créer une nouvelle réservation
        Reservation reservation = new Reservation();
        reservation.setId(new ReservationID(client.getClientID(), chambre.getChambre_id(), Date.valueOf("2024-01-25")));
        reservation.setDateReservation(Date.valueOf("2024-01-25"));
        reservation.setDate_fin(Date.valueOf("2024-01-30"));
        reservation.setMontant_total(250.0);
        reservation.setStatut_confirmation("Confirmé");

        // Ajouter la réservation à la liste des réservations du client
        client.getReservations().add(reservation);

        em.persist(reservation);

        transaction.commit();
        
     // Afficher la liste des réservations après la réservation
        List<Reservation> reservations = em.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
        System.out.println("\n Liste des réservations après la réservation :");
        for (Reservation reservation1 : reservations) {
       
            System.out.println("Réservation ID: " + reservation1.getId() +
                               ", Date de réservation: " + reservation1.getDateReservation() +
                               ", Montant total: " + reservation1.getMontant_total());
        }
    }

    private static void cancelReservation(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Obtenez la réservation à partir de la base de données 
        Reservation reservation = em.find(Reservation.class, new ReservationID(1L, 1L, Date.valueOf("2024-03-01")));

        Client client = em.find(Client.class, reservation.getId().getClientID());
        // Supprimer la réservation
        em.remove(reservation);

        transaction.commit();
        
     // Afficher la liste des réservations après l'annulation
        List<Reservation> reservationsAfterCancellation = em.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
        System.out.println("\nListe des réservations après l'annulation :");
        
        
        for (Reservation reservation1 : reservationsAfterCancellation) {
        	
        	
            System.out.println("Réservation ID: " + reservation1.getId() +
                               ", Date de réservation: " + reservation1.getDateReservation() +
                               ", Montant total: " + reservation1.getMontant_total());
        }
    }

    private static void findReservationsForClient(EntityManager em) {
        // Obtenez le client à partir de la base de données (remplacez 1L par l'ID réel du client)
        Client client = em.find(Client.class, 1L);

        // Obtenez la liste des réservations associées à ce client
        List<Reservation> reservations = client.getReservations();

        // Afficher le nom du client et les réservations
        System.out.println("\nListe des réservations d'un client :");
        System.out.println("Nom du client: " + client.getNom() +
                           ", Prenom du client: " + client.getPrenom());
        for (Reservation reservation : reservations) {
            System.out.println("Date de réservation: " + reservation.getDateReservation() +
                               ", Montant total: " + reservation.getMontant_total());
        }
    }

    private static void listAvailableRooms(EntityManager em) {
       
        Date date = Date.valueOf("2024-01-25");

        // Exemple simple : Obtenez toutes les chambres qui n'ont pas de réservations à la date spécifiée
        List<Chambre> availableRooms = em.createQuery(
                "SELECT c FROM Chambre c " +
                        "WHERE NOT EXISTS (" +
                        "   SELECT 1 FROM Reservation r " +
                        "   WHERE r.chambre = c AND :date BETWEEN r.dateReservation AND r.date_fin" +
                        ")"
        ).setParameter("date", date).getResultList();

        // Afficher les chambres disponibles
        System.out.println("\nListe des chambres disponible le " + date + " :");
        for (Chambre chambre : availableRooms) {
            System.out.println("Chambre ID: " + chambre.getChambre_id() +
                               ", Numéro de chambre: " + chambre.getNumero_chambre() +
                               ", Tarif journalier: " + chambre.getTarif_journalier());
        }
    }
}