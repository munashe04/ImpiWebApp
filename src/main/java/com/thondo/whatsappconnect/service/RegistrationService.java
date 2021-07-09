package com.thondo.whatsappconnect.service;

import com.thondo.whatsappconnect.entity.MainProfile;
import com.thondo.whatsappconnect.enums.ApplicationStatus;
import com.thondo.whatsappconnect.enums.MenuEnum;
import com.thondo.whatsappconnect.repository.MainProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private MainProfileRepository mainProfileRepository;


    public String register(MainProfile mainProfile, String body,String imageUrl) {


        if (mainProfile.getMenuStage() == 0) {
            //0 -request full name
            if (body.equalsIgnoreCase("1")){
                mainProfile.setApprovalStatus(mainProfile.getApprovalStatus());
                mainProfile.setMobileNumber(mainProfile.getMobileNumber());
                mainProfile.setDateCreated(LocalDateTime.now());
                mainProfile.setMenuStage(1);
                mainProfile.setMenuSelected(mainProfile.getMenuSelected());
                mainProfileRepository.save(mainProfile);
                return "What is your full name (first name, surname)";
            }else{
                return "Please enter 1 to start registration";
            }

        } else if (mainProfile.getMenuStage() == 1) {
            //1 -request save fullname and request -referred by mobile number
            mainProfile.setApprovalStatus(mainProfile.getApprovalStatus());
            mainProfile.setMobileNumber(mainProfile.getMobileNumber());
            mainProfile.setDateCreated(LocalDateTime.now());
            mainProfile.setMenuStage(2);
            mainProfile.setMenuSelected(mainProfile.getMenuSelected());
            mainProfile.setFullName(body);
            mainProfileRepository.save(mainProfile);
            return "Who referred you [Phone Number]";
        }else if (mainProfile.getMenuStage() == 2) {
            //1 -request save ref mobile and request - DOB
            mainProfile.setApprovalStatus(mainProfile.getApprovalStatus());
            mainProfile.setMobileNumber(mainProfile.getMobileNumber());
            mainProfile.setDateCreated(LocalDateTime.now());
            mainProfile.setMenuStage(3);
            mainProfile.setMenuSelected(mainProfile.getMenuSelected());
            mainProfile.setFullName(mainProfile.getFullName());
            mainProfile.setRefMobileNumber(body);
            mainProfileRepository.save(mainProfile);
            return "What is your date of birth";
        }else if (mainProfile.getMenuStage() == 3) {
            //1 -request save DOB and request - Gender
            mainProfile.setApprovalStatus(mainProfile.getApprovalStatus());
            mainProfile.setMobileNumber(mainProfile.getMobileNumber());
            mainProfile.setDateCreated(LocalDateTime.now());
            mainProfile.setMenuStage(4);
            mainProfile.setMenuSelected(mainProfile.getMenuSelected());
            mainProfile.setFullName(mainProfile.getFullName());
            mainProfile.setRefMobileNumber(mainProfile.getRefMobileNumber());
            mainProfile.setDateOfBirth(body);
            mainProfileRepository.save(mainProfile);
            return "What is your gender";
        }else if (mainProfile.getMenuStage() == 4) {
            //1 -request save Gender and request - ID
            mainProfile.setApprovalStatus(mainProfile.getApprovalStatus());
            mainProfile.setMobileNumber(mainProfile.getMobileNumber());
            mainProfile.setDateCreated(LocalDateTime.now());
            mainProfile.setMenuStage(5);
            mainProfile.setMenuSelected(mainProfile.getMenuSelected());
            mainProfile.setFullName(mainProfile.getFullName());
            mainProfile.setRefMobileNumber(mainProfile.getRefMobileNumber());
            mainProfile.setDateOfBirth(mainProfile.getDateOfBirth());
            mainProfile.setGender(body);
            mainProfileRepository.save(mainProfile);
            return "What is your ID number";
        }else if (mainProfile.getMenuStage() == 5) {
            //1 -request save ID number and request - Address
            mainProfile.setApprovalStatus(mainProfile.getApprovalStatus());
            mainProfile.setMobileNumber(mainProfile.getMobileNumber());
            mainProfile.setDateCreated(LocalDateTime.now());
            mainProfile.setMenuStage(6);
            mainProfile.setMenuSelected(mainProfile.getMenuSelected());
            mainProfile.setFullName(mainProfile.getFullName());
            mainProfile.setDateOfBirth(mainProfile.getDateOfBirth());
            mainProfile.setGender(mainProfile.getGender());
            mainProfile.setRefMobileNumber(mainProfile.getRefMobileNumber());
            mainProfile.setIdNumber(body);
            mainProfileRepository.save(mainProfile);
            return "What is your address";
        }else if (mainProfile.getMenuStage() == 6) {
            //1 -request save address and request - ID image
            mainProfile.setApprovalStatus(mainProfile.getApprovalStatus());
            mainProfile.setMobileNumber(mainProfile.getMobileNumber());
            mainProfile.setDateCreated(LocalDateTime.now());
            mainProfile.setMenuStage(7);
            mainProfile.setMenuSelected(mainProfile.getMenuSelected());
            mainProfile.setFullName(mainProfile.getFullName());
            mainProfile.setDateOfBirth(mainProfile.getDateOfBirth());
            mainProfile.setGender(mainProfile.getGender());
            mainProfile.setRefMobileNumber(mainProfile.getRefMobileNumber());
            mainProfile.setIdNumber(mainProfile.getIdNumber());
            mainProfile.setFullAddress(body);
            mainProfileRepository.save(mainProfile);
            return "Send picture of your ID";
        }else if (mainProfile.getMenuStage() == 7) {
            if (imageUrl==null){
                return "Please upload a valid picture of your ID";
            }
            //1 -request save ID image and request - selfie image
            mainProfile.setApprovalStatus(mainProfile.getApprovalStatus());
            mainProfile.setMobileNumber(mainProfile.getMobileNumber());
            mainProfile.setDateCreated(LocalDateTime.now());
            mainProfile.setMenuStage(8);
            mainProfile.setMenuSelected(mainProfile.getMenuSelected());
            mainProfile.setFullName(mainProfile.getFullName());
            mainProfile.setDateOfBirth(mainProfile.getDateOfBirth());
            mainProfile.setGender(mainProfile.getGender());
            mainProfile.setRefMobileNumber(mainProfile.getRefMobileNumber());
            mainProfile.setIdNumber(mainProfile.getIdNumber());
            mainProfile.setFullAddress(body);
            mainProfile.setIdImageUrl(imageUrl);
            mainProfileRepository.save(mainProfile);
            return "Send us your picture (selfie)";
        }else if (mainProfile.getMenuStage() == 8) {
            if (imageUrl==null){
                return "Please upload a valid Selfie  picture";
            }
            //1 -request save ID image and request - selfie image
            mainProfile.setApprovalStatus("PENDING");
            mainProfile.setMobileNumber(mainProfile.getMobileNumber());
            mainProfile.setDateCreated(LocalDateTime.now());
            mainProfile.setMenuStage(0);
            mainProfile.setMenuSelected(MenuEnum.ORDER.getValue());
            mainProfile.setFullName(mainProfile.getFullName());
            mainProfile.setDateOfBirth(mainProfile.getDateOfBirth());
            mainProfile.setGender(mainProfile.getGender());
            mainProfile.setRefMobileNumber(mainProfile.getRefMobileNumber());
            mainProfile.setIdNumber(mainProfile.getIdNumber());
            mainProfile.setFullAddress(body);
            mainProfileRepository.save(mainProfile);
            System.out.println("Done with registration profile"+mainProfile);
            return "Thank you for submitting the information, your registration is under review.\n" +
                    "You will receive a one-time-password which you will change upon signing in";
        }
        else {
            return "Please contact our administrator for support";
        }

    }


}

