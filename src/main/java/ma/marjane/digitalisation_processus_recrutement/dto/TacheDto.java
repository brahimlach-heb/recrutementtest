package ma.marjane.digitalisation_processus_recrutement.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TacheDto {


    private UUID id;  // Utilisation d'un UUID pour l'ID si vous ne fournissez pas de spécifications de type de données spécifiques pour l'ID.
    private String etape;
    private LocalDateTime dateDeDebut;


}
