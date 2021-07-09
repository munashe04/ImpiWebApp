package com.thondo.whatsappconnect.repository;

import com.thondo.whatsappconnect.entity.MainProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MainProfileRepository extends JpaRepository<MainProfile, String> {
    Optional<MainProfile> findByMobileNumber(String mobileNumber);
    Optional<MainProfile> findByApprovalStatus(String status);
}
