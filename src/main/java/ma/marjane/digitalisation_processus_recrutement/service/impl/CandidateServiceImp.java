package ma.marjane.digitalisation_processus_recrutement.service.impl;

import lombok.RequiredArgsConstructor;

import ma.marjane.digitalisation_processus_recrutement.entity.Candidate;
import ma.marjane.digitalisation_processus_recrutement.entity.Collaborateur;

import ma.marjane.digitalisation_processus_recrutement.repository.CandidateRepository;
import ma.marjane.digitalisation_processus_recrutement.repository.CollaborateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.io.IOException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CandidateServiceImp {

    private final CandidateRepository candidateRepository;
    private final CollaborateurRepository collaborateurRepository;
    private final String uploadDir = "uploads/";

    public Candidate saveCandidat(Candidate candidat, MultipartFile cv, UUID demandeId) throws IOException {
        Collaborateur collaborateur = collaborateurRepository.findById(demandeId).orElseThrow(() -> new RuntimeException("Demande not found"));


        String fileName = generateFileName(candidat.getNom(), candidat.getPrenom(), demandeId);

        // Save the file to the filesystem
        Path copyLocation = Paths.get(uploadDir + fileName);
        Files.copy(cv.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);

        // Set the file path to the candidat entity
        candidat.setCvPath(copyLocation.toString());
        candidat.setDemande(collaborateur);
        return candidateRepository.save(candidat);
    }
    private String generateFileName(String nom, String prenom, UUID demandeId) {
        return nom + "_" + prenom + "_" + demandeId + ".pdf"; // Adjust the file extension as necessary
    }


    public void deleteById(UUID id) {
        candidateRepository.deleteById(id);
    }
}
