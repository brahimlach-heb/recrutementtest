package ma.marjane.digitalisation_processus_recrutement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners(AuditingEntityListener.class)
public abstract class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;  // Utilisation d'un UUID pour l'ID si vous ne fournissez pas de spécifications de type de données spécifiques pour l'ID.
    private String type;
    private String siteRattachement;
    private String titrePoste;
    private String matricule;
    private String competencesTechniques;
    private String competencesManageriales;
    private String formation; // Formation
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateDeCreation= LocalDateTime.now();

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime dateDeModification;

    @Column(name = "statut")
    private String statut = "En cours";

    @Column(name = "attributes")
    private boolean attributes;
    @Column(name = "creerpar")
    private String creerPar;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "demande_id")
    private List<Tache> taches= new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "demande_id")
    private List<Hierarchie> hierarchies= new ArrayList<>();

    @OneToMany(mappedBy = "demande")
    @JsonIgnore
    private List<Candidate> candidates;

}
