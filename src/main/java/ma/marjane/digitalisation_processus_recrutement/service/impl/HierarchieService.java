package ma.marjane.digitalisation_processus_recrutement.service.impl;

import jdk.jshell.execution.Util;
import ma.marjane.digitalisation_processus_recrutement.dto.CollaborateurDto;
import ma.marjane.digitalisation_processus_recrutement.dto.HierarchieDTO;
import ma.marjane.digitalisation_processus_recrutement.entity.Collaborateur;
import ma.marjane.digitalisation_processus_recrutement.entity.Hierarchie;
import ma.marjane.digitalisation_processus_recrutement.entity.ListRH;
import ma.marjane.digitalisation_processus_recrutement.entity.Utilisateur;
import ma.marjane.digitalisation_processus_recrutement.mapper.impl.HierarchieMapper;
import ma.marjane.digitalisation_processus_recrutement.repository.CollaborateurRepository;
import ma.marjane.digitalisation_processus_recrutement.repository.HierarchieRepository;
import ma.marjane.digitalisation_processus_recrutement.repository.ListRHRepository;
import ma.marjane.digitalisation_processus_recrutement.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HierarchieService {
    @Autowired
    private HierarchieRepository hierarchieRepository;

    @Autowired
    private CollaborateurRepository collaborateurRepository;

    @Autowired
    private HierarchieMapper hierarchieMapper;

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private ListRHRepository listRHRepository;

    public List<HierarchieDTO> getAllHierarchies() {
        List<Hierarchie> hierarchies = hierarchieRepository.findAll();
        return hierarchies.stream()
                .map(hierarchieMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public List<HierarchieDTO> getHierarchieById(UUID demandeId) {
        List<Hierarchie> hierarchies = hierarchieRepository.findByDemandeId(demandeId);
        List<HierarchieDTO> hierarchieDTOS = hierarchies.stream()
                .map(hierarchieMapper::convertToDto)
                .toList();
        return hierarchieDTOS;
    }
    public boolean validerdemande(UUID demandeId, String matricule) {
        List<Hierarchie> hierarchies = hierarchieRepository.findByDemandeId(demandeId);
        Collaborateur collaborateur = collaborateurRepository.findById(demandeId).get();
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(collaborateur.getMatricule());
        if (utilisateur == null) {
            // Handle the case where the user is not found
            return false;
        }else if (hierarchies.isEmpty()) {
            // Handle the case where the hierarchy is not found
            return false;
        }else if (hierarchies.get(hierarchies.size() - 1).getMatricule().equals(utilisateur.getMatricule()) && !utilisateur.getMatricule().equals(utilisateur.getComex())) {
            // Handle the case where the hierarchy has more than two elements
            Utilisateur manager1 = utilisateurRepository.findByMatricule(utilisateur.getManager1());

            hierarchies.get(hierarchies.size() - 1).setStatut("valider");
            hierarchieRepository.save(hierarchies.get(hierarchies.size() - 1));
            if (manager1 != null) {
                Hierarchie hierarchie = new Hierarchie();
                hierarchie.setMatricule(manager1.getMatricule());
                hierarchie.setDemandeId(demandeId);
                hierarchie.setStatut("En cours");
                hierarchie.setPrenom(manager1.getPrenom());
                hierarchie.setNom(manager1.getNom());
                hierarchie.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                hierarchieRepository.save(hierarchie);
                // Handle the case where the first manager is not found
                return true;
            }

            return true;
        }
        for (Hierarchie hierarchie : hierarchies) {
            if (utilisateur.getMatricule().equals((utilisateur.getComex())) && hierarchie.getStatut().equals("En cours")) {
                hierarchie.setStatut("valider");
                hierarchie.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                hierarchieRepository.save(hierarchie);
                Hierarchie hierarchie1 = new Hierarchie();
                hierarchie1.setDemandeId(demandeId);
                hierarchie1.setMatricule("RH");
                hierarchie1.setStatut("En cours");
                hierarchie1.setPrenom("");
                hierarchie1.setNom("RH");
                hierarchie1.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                hierarchieRepository.save(hierarchie1);
                return true;
            }
            if (utilisateur.getMatricule().equals(matricule) && hierarchie.getStatut().equals("En cours")) {

                // Handle the case where the hierarchy has more than two elements
                Utilisateur manager1 = utilisateurRepository.findByMatricule(utilisateur.getManager1());

                hierarchie.setStatut("valider");
                if (manager1 != null) {
                    Hierarchie hierarchie1 = new Hierarchie();
                    hierarchie1.setMatricule(manager1.getMatricule());
                    hierarchie1.setDemandeId(demandeId);
                    hierarchie1.setStatut("En cours");
                    hierarchie1.setPrenom(manager1.getPrenom());
                    hierarchie1.setNom(manager1.getNom());
                    hierarchie1.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                    hierarchieRepository.save(hierarchie);
                    hierarchieRepository.save(hierarchie1);
                    // Handle the case where the first manager is not found
                    return true;
                }
            } else
            if (utilisateur.getMail().equals("labarar@marjane.ma") && hierarchie.getStatut().equals("En cours") && hierarchie.getMatricule().equals(matricule)){
                hierarchie.setStatut("valider");
                hierarchie.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                hierarchieRepository.save(hierarchie);
                return true;
            } else if (hierarchie.getStatut().equals("En cours") && utilisateur.getManager1().equals(matricule)) {
                hierarchie.setStatut("Valider");
                hierarchie.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                hierarchieRepository.save(hierarchie);
                String managerMatricule = utilisateur.getManager2();
                Utilisateur manager = utilisateurRepository.findByMatricule(managerMatricule);
                if (manager != null) {
                    Hierarchie hierarchie1 = new Hierarchie();
                    hierarchie1.setMatricule(managerMatricule);
                    hierarchie1.setDemandeId(demandeId);
                    hierarchie1.setStatut("En cours");
                    hierarchie1.setPrenom(manager.getPrenom());
                    hierarchie1.setNom(manager.getNom());
                    hierarchie1.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                    hierarchieRepository.save(hierarchie1);
                }
                return true;
            }
            else if (hierarchie.getStatut().equals("En cours") && utilisateur.getManager2().equals(matricule)){

                String managerMatricule = utilisateur.getManager2();
                Utilisateur manager = utilisateurRepository.findByMatricule(managerMatricule);

                if (manager != null && manager.getMail().equals(utilisateurRepository.findByMatricule(utilisateur.getComex()).getMail())){
                    hierarchie.setStatut("Valider");
                    hierarchieRepository.save(hierarchie);
                    Hierarchie hierarchie1 = new Hierarchie();
                    hierarchie1.setDemandeId(demandeId);
                    hierarchie1.setMatricule("RH");
                    hierarchie1.setStatut("En cours");
                    hierarchie1.setPrenom("");
                    hierarchie1.setNom("RH");
                    hierarchie1.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                    hierarchieRepository.save(hierarchie1);

                }
                else {
                    hierarchie.setStatut("Valider");
                    hierarchieRepository.save(hierarchie);
                    String managerMatricule1 = utilisateur.getComex();
                    Utilisateur manager1 = utilisateurRepository.findByMatricule(managerMatricule1);
                    if (manager1 != null) {
                        Hierarchie hierarchie1 = new Hierarchie();
                        hierarchie1.setMatricule(managerMatricule1);
                        hierarchie1.setDemandeId(demandeId);
                        hierarchie1.setStatut("En cours");
                        hierarchie1.setPrenom(manager1.getPrenom());
                        hierarchie1.setNom(manager1.getNom());
                        hierarchie1.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                        hierarchieRepository.save(hierarchie1);
                    }

                }
                return true;
            }else if (hierarchie.getStatut().equals("En cours") && utilisateur.getComex().equals(matricule)){
                hierarchie.setStatut("Valider");
                hierarchie.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                hierarchieRepository.save(hierarchie);
                Hierarchie hierarchie1 = new Hierarchie();
                hierarchie1.setDemandeId(demandeId);
                hierarchie1.setMatricule("RH");
                hierarchie1.setStatut("En cours");
                hierarchie1.setPrenom("");
                hierarchie1.setNom("RH");
                hierarchie1.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                hierarchieRepository.save(hierarchie1);
                return true;
            }
            else if (hierarchie.getStatut().equals("En cours") && listRHRepository.findByMatricule(matricule) != null){
                ListRH listRH = listRHRepository.findByMatricule(matricule);
                hierarchie.setDemandeId(demandeId);
                hierarchie.setMatricule(listRH.getMatricule());
                hierarchie.setNom(listRH.getNom());
                hierarchie.setPrenom(listRH.getPrenom());
                hierarchie.setStatut("Valider");
                hierarchie.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                hierarchieRepository.save(hierarchie);
                return true;
            }
        }
        return false;
    }

    public boolean refuserdemande(UUID demandeId, String matricule, String commentaire) {
        List<Hierarchie> hierarchies = hierarchieRepository.findByDemandeId(demandeId);
        Collaborateur collaborateur = collaborateurRepository.findById(demandeId).get();
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(collaborateur.getMatricule());
        for (Hierarchie hierarchie : hierarchies) {
            if (hierarchie.getStatut().equals("En cours") && hierarchie.getMatricule().equals(matricule)) {
                hierarchie.setStatut("Refuser");
                Hierarchie hierarchie1 = new Hierarchie();
                hierarchie1.setDemandeId(demandeId);
                hierarchie1.setStatut("En cours");
                hierarchie1.setMatricule(utilisateur.getMatricule());
                hierarchie1.setCommentaire(commentaire);
                hierarchie1.setNom(utilisateur.getNom());
                hierarchie1.setPrenom(utilisateur.getPrenom());
                hierarchie1.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                hierarchieRepository.save(hierarchie1);
                hierarchieRepository.save(hierarchie);
                return true;
            }else if (hierarchie.getStatut().equals("En cours") && listRHRepository.findByMatricule(matricule) != null){
                ListRH listRH = listRHRepository.findByMatricule(matricule);
                hierarchie.setDemandeId(demandeId);
                hierarchie.setMatricule(listRH.getMatricule());
                hierarchie.setNom(listRH.getNom());
                hierarchie.setPrenom(listRH.getPrenom());
                hierarchie.setStatut("Refuser");
                hierarchie.setCommentaire(commentaire);
                hierarchie.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                ///////////////////////////////////////
                Hierarchie hierarchie1 = new Hierarchie();
                hierarchie1.setDemandeId(demandeId);
                hierarchie1.setStatut("En cours");
                hierarchie1.setMatricule(utilisateur.getMatricule());
                hierarchie1.setCommentaire(commentaire);
                hierarchie1.setNom(utilisateur.getNom());
                hierarchie1.setPrenom(utilisateur.getPrenom());
                hierarchie1.setDatedecreation(new Date());  // Assuming setDatedecreation accepts a Date object
                hierarchieRepository.save(hierarchie1);
                hierarchieRepository.save(hierarchie);
                return true;
            }
        }
        return false;
    }


//    public HierarchieDTO createHierarchie(HierarchieDTO hierarchieDTO) {
//        Hierarchie hierarchie = hierarchieMapper.convertToEntity(hierarchieDTO);
//        hierarchie = hierarchieRepository.save(hierarchie);
//        return hierarchieMapper.convertToDto(hierarchie);
//    }

//    public HierarchieDTO updateHierarchie(UUID id, HierarchieDTO hierarchieDTO) {
//        Optional<Hierarchie> existingHierarchie = hierarchieRepository.findById(id);
//        if (existingHierarchie.isPresent()) {
//            Hierarchie hierarchie = existingHierarchie.get();
//            hierarchie.setMatricule(hierarchieDTO.getMatricule());
//            hierarchie.setNom(hierarchieDTO.getNom());
//            hierarchie.setPrenom(hierarchieDTO.getPrenom());
//            hierarchie.setDatedecreation(hierarchieDTO.getDatedecreation());
//            hierarchie.setCommentaire(hierarchieDTO.getCommentaire());
//            hierarchie = hierarchieRepository.save(hierarchie);
//            return hierarchieMapper.convertToDto(hierarchie);
//        } else {
//            return null;
//        }
//    }
    public List<HierarchieDTO> getHierarchieByDemandeId(UUID demandeId) {
        List<Hierarchie> hierarchies = hierarchieRepository.findByDemandeId(demandeId);
        return hierarchies.stream()
                .map(hierarchieMapper::convertToDto)
                .sorted(Comparator.comparing(HierarchieDTO::getDatedecreation))
                .collect(Collectors.toList());
    }



    public List<Collaborateur> getdemandes(String matricule) {
        List<Hierarchie> hierarchies = hierarchieRepository.findByMatricule(matricule);
        List<Collaborateur> collaborateurs = new ArrayList<>();
        ListRH listRH = listRHRepository.findByMatricule(matricule);
        if (listRH != null){
            hierarchies = hierarchieRepository.findByMatricule("RH");
            hierarchies.forEach(hierarchie -> {
                Optional<Collaborateur> collaborateur = collaborateurRepository.findById(hierarchie.getDemandeId());
                if (collaborateur.isPresent() && hierarchie.getStatut().equals("En cours")){
                    collaborateurs.add(collaborateur.get());
                }
            });
            hierarchies = hierarchieRepository.findByMatriculeAndStatut(matricule,"Valider");
            hierarchies.forEach(hierarchie -> {
                Optional<Collaborateur> collaborateur = collaborateurRepository.findById(hierarchie.getDemandeId());
                collaborateurs.add(collaborateur.get());
            });

            return collaborateurs;
        }else{
        hierarchies.forEach(hierarchie -> {
            Optional<Collaborateur> collaborateur = collaborateurRepository.findById(hierarchie.getDemandeId());
            if (collaborateur.isPresent() && hierarchie.getStatut().equals("En cours")){
                collaborateurs.add(collaborateur.get());
            }
        });}
        return collaborateurs;
    }

    public List<HierarchieDTO> getAllDemandes() {
        List<Hierarchie> hierarchies = hierarchieRepository.findAll();
        return hierarchies.stream()
                .map(hierarchieMapper::convertToDto)
                .sorted(Comparator.comparing(HierarchieDTO::getDatedecreation))
                .collect(Collectors.toList());
    }

    public boolean demandestvalider(String matricule, UUID demandeId) {
        List<Hierarchie> hierarchies = hierarchieRepository.findByDemandeIdAndMatricule(demandeId, matricule);
        for (Hierarchie hierarchie : hierarchies) {
            if (hierarchie.getMatricule().equals(matricule) && hierarchie.getStatut().equals("valider")) {
                return true;
            }
        }
        return false;

    }
}
