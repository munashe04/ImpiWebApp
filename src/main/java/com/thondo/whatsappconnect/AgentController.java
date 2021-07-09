package com.thondo.whatsappconnect;


import com.thondo.whatsappconnect.entity.MainProfile;
import com.thondo.whatsappconnect.model.MainProfileDto;
import com.thondo.whatsappconnect.model.convertors.MainProfileDtoConverter;
import com.thondo.whatsappconnect.service.external.RegistrationServiceExternal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/agents")
public class AgentController {
    @Autowired
    private RegistrationServiceExternal registrationService;

    @Autowired
    MainProfileDtoConverter mainProfileDtoConverter;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<MainProfileDto> getAllAgents() {
        System.out.println(" getting all agents >>>>>>>>>>>>>>>>>");
        return registrationService.getAgents();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/pending")
    @ResponseStatus(HttpStatus.OK)
    public List<MainProfileDto> getAgentPending() {
        System.out.println(" getting pending agents >>>>>>>>>>>>>>>>>");
        return registrationService.getAgentPending();
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/approve")
    @CrossOrigin(origins ="http://localhost:4200" )
    @ResponseStatus(HttpStatus.OK)
    public void approveAgent(@RequestBody MainProfileDto mainProfileDto) {
        System.out.println(" approving an agents >>>>>>>>>>>>>>>>>");
      registrationService.approveAgent((mainProfileDto));
    }
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/delete")
    @CrossOrigin(origins ="http://localhost:4200" )
    @ResponseStatus(HttpStatus.OK)
    public void deleteAgent(@RequestBody MainProfileDto mainProfileDto) {
        System.out.println(" deleting an agents >>>>>>>>>>>>>>>>>");
         registrationService.declineAgent(mainProfileDto);
    }



}
