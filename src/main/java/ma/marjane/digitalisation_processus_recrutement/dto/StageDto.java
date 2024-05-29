package ma.marjane.digitalisation_processus_recrutement.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StageDto extends DemandeDto {

    private String stageType;
    private String formationCandidat;
    private String niveauEducation;
    private String ecolesPreferees;
    private String natureDuStage;
    private Integer dureeDuStage;
    private LocalDateTime dateDeDebut;
    private String contenuDuStage;
    private String livrableAttendu;
}
