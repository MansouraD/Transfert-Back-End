package com.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Emetteur;
import com.rest.model.Operation;
import com.rest.model.Recepteur;
import com.rest.repository.EmetteurRepository;
import com.rest.repository.OperationRepository;
import com.rest.repository.RecepteurRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/transfert")
public class OperationController {
	
	@Autowired
	private EmetteurRepository emetteurRepository;
	@Autowired
	private RecepteurRepository recepteurRepository;
	@Autowired
	private OperationRepository operationRepository;
	
	
		
		public void valider(Emetteur  emetteur, Recepteur  recepteur, Operation operation) {
			
			operation.setEmetteur(emetteurRepository.save(emetteur));
			operation.setRecepteur(recepteurRepository.save(recepteur));
			operationRepository.save(operation);
}
		@PostMapping("/valider")
		public void encapsulation( String nom_emetteur, String prenom_emetteur, Integer  tel_emetteur, Integer cin, 
				String nom_recepteur, String prenom_recepteur, Integer tel_recepteur, String date, Integer montant) {
			
			Emetteur emetteur=new Emetteur(); 
			emetteur.setNom_emetteur(nom_emetteur);
			emetteur.setPrenom_emetteur(prenom_emetteur);
			emetteur.setTel_emetteur(tel_emetteur.intValue());
			emetteur.setCin(cin.intValue());
			
			
			
			Recepteur recepteur=new Recepteur();
			recepteur.setNom_recepteur(nom_recepteur);
			recepteur.setPrenom_recepteur(prenom_recepteur);
			recepteur.setTel_recepteur(tel_recepteur.intValue());
			
			Operation transaction=new Operation();
			transaction.setDate(date);
			transaction.setMontant(montant.intValue());
			valider(emetteur, recepteur, transaction);
			
			}
}
