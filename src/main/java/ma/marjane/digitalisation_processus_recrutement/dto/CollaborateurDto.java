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
    private String motifCreation;
    private Boolean posteBudgete;
    private Number budgetEstime;
    private String collaborateurARemplacer;
    private String motifDepart;
    private String superviseurFonctionnel;
    private String relationsHierarchiques;
    private String relationsFonctionnelles;
    private String relationsExterne;
    private String missionGlobale;
    private String principalesActivites;
    private String formation;
    private String experience;
    private String competenceTechnique;
    private String competenceManagerial;
    private String indicateursQuantitatifs;
    private String indicateursQualitatifs;
    private String typeContrat;
    private String categorie;
    private String typeRecrutement;

}
