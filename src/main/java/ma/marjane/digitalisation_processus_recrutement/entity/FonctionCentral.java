package ma.marjane.digitalisation_processus_recrutement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class FonctionCentral {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code_uo;

    private String libelle;

    private boolean fc;

}
