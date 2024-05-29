package ma.marjane.digitalisation_processus_recrutement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class DirectionOuMagasin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // Utilisation d'un UUID pour l'ID si vous ne fournissez pas de spécifications de type de données spécifiques pour l'ID.

    private String nom; // Nom de la direction ou du magasin.

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateDeCreation;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime dateDeModification;

//    @OneToMany(mappedBy = "directionOuMagasin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Demande> demandes; // Liste des demandes associées à cette direction ou magasin.

}
