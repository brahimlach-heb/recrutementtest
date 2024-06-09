package ma.marjane.digitalisation_processus_recrutement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tache")
@EntityListeners(AuditingEntityListener.class)
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;  // Utilisation d'un UUID pour l'ID si vous ne fournissez pas de spécifications de type de données spécifiques pour l'ID.

    private String etape;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateDeDebut;

    @Column(name = "demande_id", nullable = false)
    private UUID demandeId;  // Référence à la demande associée

}
