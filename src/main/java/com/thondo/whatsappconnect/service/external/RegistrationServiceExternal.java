package com.thondo.whatsappconnect.service.external;

import com.thondo.whatsappconnect.entity.MainProfile;
import com.thondo.whatsappconnect.model.MainProfileDto;
import com.thondo.whatsappconnect.model.convertors.MainProfileDtoConverter;
import com.thondo.whatsappconnect.repository.MainProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceExternal {
    @Autowired
    private MainProfileRepository mainProfileRepository;
    @Autowired
    private MainProfileDtoConverter mainProfileDtoConverter;

    public List<MainProfileDto> getAgents(){
        List<MainProfile> agent = mainProfileRepository.findAll();
        return mainProfileDtoConverter.agentToDto(agent);

    }
    public List<MainProfileDto> getAgentPending(){
        List<MainProfile>agent = mainProfileRepository.findAll();
       List<MainProfile> agentsPending = agent.stream()
                .filter(agents -> agents.getApprovalStatus().equalsIgnoreCase("pending"))
                .collect(Collectors.toList());

       return mainProfileDtoConverter.agentToDto(agentsPending);

       }
       public void approveAgent(MainProfileDto mainProfileDto){
        mainProfileDto.setApprovalStatus("APPROVED");

        mainProfileRepository.save(mainProfileDtoConverter.agentDtoToEntity(mainProfileDto));
       }
    public void declineAgent(MainProfileDto mainProfileDto){

        mainProfileRepository.delete(mainProfileDtoConverter.agentDtoToEntity(mainProfileDto));
    }



}
