package com.hp.mian;

import com.hp.service.AdminService;
import com.hp.service.imlp.AdminServiceImpl;

public class Main {

    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        adminService.main();
    }

}
