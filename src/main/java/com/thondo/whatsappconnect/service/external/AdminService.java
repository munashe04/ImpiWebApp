package com.thondo.whatsappconnect.service.external;

import com.thondo.whatsappconnect.entity.Admin;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    public Admin register(Admin admin) throws Exception;
    public Admin logIn(Admin admin) throws Exception;
}
