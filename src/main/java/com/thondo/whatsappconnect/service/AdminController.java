package com.thondo.whatsappconnect.service;

import com.thondo.whatsappconnect.entity.Admin;
import com.thondo.whatsappconnect.service.external.AdminService;
import com.thondo.whatsappconnect.service.external.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@CrossOrigin(origins ="http://localhost:4200" )
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/signUp")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins ="http://localhost:4200" )
    @ResponseStatus(HttpStatus.OK)
    public Admin signUp(@RequestBody Admin admin) throws Exception {
        System.out.print("SignUp-------->>>>>>>>>>>>");
        return adminService.register(admin);
    }
    @RequestMapping("/logIn")
    @CrossOrigin(origins ="http://localhost:4200" )
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Admin logIn(@RequestBody Admin admin) throws Exception {
        return adminService.logIn(admin);
    }
}
