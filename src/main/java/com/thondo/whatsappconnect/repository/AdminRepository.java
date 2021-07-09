package com.thondo.whatsappconnect.repository;

import com.thondo.whatsappconnect.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {
    public Admin findAdminByEmail(String email);
    public Admin findAdminByUserName(String userName);
    public Admin findAdminByEmailAndPassword(String email,String password);
    public Admin findAdminByFullName(String fullName);
}
