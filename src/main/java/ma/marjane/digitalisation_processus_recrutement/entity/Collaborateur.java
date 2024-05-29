package ma.marjane.digitalisation_processus_recrutement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Collaborateur extends Demande {

    private String natureDeRecrutement;

    @Column(name = "creation_reason")
    private String motifCreation;

    @Column(name = "position_budgeted")
    private Boolean posteBudgete;

    @Column(name = "estimated_budget")
    private Number budgetEstime;

    private String collaborateurARemplacer;

    @Column(name = "departure_reason")
    private String motifDepart;

    @Column(name = "functional_supervisor")
    private String superviseurFonctionnel; // Supérieur fonctionnel

    private String relationsHierarchiques; // Relations hiérarchiques

    private String relationsFonctionnelles; // Relations fonctionnelles

    private String relationsExterne;

    @Column(name = "mission_globale", length = 1024)
    private String missionGlobale; // Mission globale
    @Column(name = "principales_activités", length = 1024)
    private String principalesActivites; // Principales activités
    private String formation;
    private String experience;
    private String competenceTechnique;
    private String competenceManagerial;
    private String indicateursQuantitatifs; // Indicateurs quantitatifs
    private String indicateursQualitatifs; // Indicateurs qualitatifs

    @Column(name = "contract_type")
    private String typeContrat; // Type de contrat

    @Column(name = "Catégorie")
    private String categorie; // Catégorie

    @Column(name = "type_recruitment")
    private String typeRecrutement; // Type de recrutement


}
