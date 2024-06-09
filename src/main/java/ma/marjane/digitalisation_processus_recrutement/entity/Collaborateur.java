package ma.marjane.digitalisation_processus_recrutement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Optional;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Collaborateur extends Demande {

    private String natureDeRecrutement;


    @Column(name = "position_budgeted")
    private Boolean posteBudgete;

    @Column(name = "departure_reason")
    private String motif;

    @Column(name = "functional_supervisor")
    private String superviseurFonctionnel; // Supérieur fonctionnel

    private String relationsHierarchiques; // Relations hiérarchiques

    private String relationsFonctionnelles; // Relations fonctionnelles

    private String relationsExterne;

    @Column(name = "mission_globale", length = 1024)
    private String missionGlobale; // Mission globale
    @Column(name = "principales_activités", length = 1024)
    private String principalesActivites; // Principales activités

    private String indicateurs; // Indicateurs quantitatifs

    @Column(name = "contract_type")
    private String typeContrat; // Type de contrat

    @Column(name = "Catégorie")
    private String categorie; // Catégorie

    @Column(name = "typeRecrutement")
    private String typeRecrutement; // Type de recrutement

    @Column(name ="societe")
    private String societe;

    @Column(name ="directionoumagasin")
    private String directionoumagasin;

    @Column(name ="sous_direction")
    private String sousDirection;

    @Column(name ="niveaudetude")
    private String niveauDetude;



}
