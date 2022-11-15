package com.example.week6.controller;


import com.example.week6.pojo.Wizard;
import com.example.week6.pojo.Wizards;
import com.example.week6.repository.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WizardController {

    @Autowired
    private WizardService wizardService;

    @RequestMapping(value = "/wizards", method = RequestMethod.GET)
    public ResponseEntity<?> getWizards(){
        Wizards ws = new Wizards(wizardService.getWizards());
        return ResponseEntity.ok(ws);
    }

    @RequestMapping(value = "/addWizard", method = RequestMethod.POST)
    public ResponseEntity<?> addWizards(@RequestBody Wizard w){
        Wizard newWi = wizardService.insertWizard(w);
        return ResponseEntity.ok(newWi);
    }

    @RequestMapping(value = "/updateWizard", method = RequestMethod.POST)
    public ResponseEntity<?> updateWizards(@RequestBody Wizard w){
        Wizard upWi = wizardService.updateWizard(w);
        return ResponseEntity.ok(upWi);
    }

    @RequestMapping(value = "/deleteWizard", method = RequestMethod.POST)
    public ResponseEntity<?> deleteWizards(@RequestBody String id){
        Wizard w = wizardService.getById(id);
        boolean check = wizardService.deleteWizard(w);
        return ResponseEntity.ok(check);
    }

}
