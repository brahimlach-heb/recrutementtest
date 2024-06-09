package ma.marjane.digitalisation_processus_recrutement.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CollaborateurDto extends DemandeDto {

    private String natureDeRecrutement;
    private Boolean posteBudgete;
    private String motif;
    private String superviseurFonctionnel;
    private String relationsHierarchiques;
    private String relationsFonctionnelles;
    private String relationsExterne;
    private String missionGlobale;
    private String principalesActivites;
    private String indicateurs;
    private String typeContrat;
    private String categorie;
    private String typeRecrutement;
    private String societe;
    private String directionoumagasin;
    private String sousDirection;
    private String niveauDetude;

}
