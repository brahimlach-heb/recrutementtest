package ma.marjane.digitalisation_processus_recrutement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Utilisateur")  // Ajout du schéma HR
public class Utilisateur {

    @Id
    private String matricule;
    private String nom;
    private String prenom;
    private String societe;
    private String codeEtablissement;
    private String etablissement;
    private String codeEmploi;
    private String emploi;
    private String codeUo;
    private String uo;
    private String mail;
    private String direction;
    private String manager1;
    private String manager2;
    private String affectation;
    private String comex;
}