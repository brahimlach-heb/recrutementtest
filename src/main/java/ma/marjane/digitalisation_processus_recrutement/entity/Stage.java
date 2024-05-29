package ma.marjane.digitalisation_processus_recrutement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stage extends Demande {

    private String typeDeStage;
    private String formation;
    private String niveauEducation;
    private String ecolesouhetee;

    @Column(name = "natureDuStage") // Mappe le champ sur le nom de colonne spécifié dans la base de données.
    private String natureDuStage; // Nature du stage

    @Column(name = "dureeDuStage")
    private Integer dureeDuStage; // Durée du stage

    private LocalDateTime dateDeDebut;

    @Column(name = "contenuDuStage", length = 1024) // Définition de la colonne spécifiée.
    private String contenuDuStage; // Contenu du stage

    @Column(name = "livrableAttendu", length = 1024)
    private String livrableAttendu; // Livrable attendu

}
