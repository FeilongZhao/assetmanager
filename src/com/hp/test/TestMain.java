package com.hp.test;

import org.junit.Test;

import com.hp.service.AdminService;
import com.hp.service.imlp.AdminServiceImpl;

public class TestMain {

    @Test
    public void testMain() {
        AdminService adminService = new AdminServiceImpl();
        adminService.main();
        
    }
}
