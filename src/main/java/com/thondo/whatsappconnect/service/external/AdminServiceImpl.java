package com.thondo.whatsappconnect.service.external;

import com.thondo.whatsappconnect.entity.Admin;
import com.thondo.whatsappconnect.repository.AdminRepository;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@ToString
public class AdminServiceImpl implements AdminService  {
    /*@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

     */

    @Autowired
    AdminRepository adminRepository;

    public Admin register(Admin admin) throws Exception {
        String email = admin.getEmail();
        String userName = admin.getUserName();
        String fullName = admin.getFullName();
        //String encodedPassword = bCryptPasswordEncoder.encode(admin.getPassword());
       // admin.setPassword(encodedPassword);

        if (email != null) {
            Admin newAdminEmail = adminRepository.findAdminByEmail(email);
            if (newAdminEmail != null) {
                throw new Exception("User with email : " + email + " already exists");
            }

        }
        if (userName != null) {
            Admin newAdminUserName = adminRepository.findAdminByUserName(userName);
            if (newAdminUserName != null) {
                throw new Exception("User with User Name : " + userName + " already exists");
            }
        }
        if (fullName != null) {
            Admin newAdminName = adminRepository.findAdminByFullName(fullName);
            if (newAdminName != null) {
                throw new Exception("User with name : " + fullName + " already exists");
            }

        }
        return adminRepository.save(admin);
    }
    public Admin logIn(Admin admin) throws Exception {
        String email = admin.getEmail();
        String password = admin.getPassword();

        if (email != null && password != null) {
            Admin existingAdmin = adminRepository.findAdminByEmailAndPassword(email, password);
            System.out.println(existingAdmin + " >>>>>>>>>>>>>>>>>");

            if (existingAdmin == null) {
                throw new Exception("User already exist");
            }
        }

        return admin ;
    }

}
