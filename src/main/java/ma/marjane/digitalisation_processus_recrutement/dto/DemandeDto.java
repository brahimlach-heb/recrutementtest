package ma.marjane.digitalisation_processus_recrutement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class DemandeDto {
    private UUID id;  // Utilisation d'un UUID pour l'ID si vous ne fournissez pas de spécifications de type de données spécifiques pour l'ID.
    private String type;
    private String siteRattachement;
    private String titrePoste;
    private String matricule;
    private String competencesTechniques;
    private String competencesManageriales;
    private String formation; // Formation
    private LocalDateTime dateDeCreation;
    private LocalDateTime dateDeModification;
    private String statut;
    private boolean attributes;
    private String creerPar;
    private List<TacheDto> taches;
}
