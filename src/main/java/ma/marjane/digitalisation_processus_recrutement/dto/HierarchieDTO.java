package ma.marjane.digitalisation_processus_recrutement.dto;

import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Data
public class HierarchieDTO {
    private UUID id;
    private String matricule;
    private String nom;
    private String prenom;
    private Date datedecreation;
    private String commentaire;
    private String statut = "En cours";
    private String demandeId;
}

