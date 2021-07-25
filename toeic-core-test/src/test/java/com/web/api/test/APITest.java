package com.web.api.test;

import com.web.core.dao.UserDAO;
import com.web.core.daoimpl.UserDAOImpl;
import com.web.core.persistence.entity.UserEntity;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class APITest {
    private final Logger log = Logger.getLogger(this.getClass());
    @Test
    public void checkUserExist() {
        UserDAO dao = new UserDAOImpl();
        String name = "quang";
        String password = "123456";
        UserEntity entity = dao.isUserExist(name, password);
        if (entity != null) {
            log.error("Success");
        } else {
            log.error("Fail");
        }
    }
    @Test
    public void checkFindRoleByUser() {
        UserDAO dao = new UserDAOImpl();
        String name = "quang";
        String password = "123456";
        UserEntity entity = dao.findRoleByUser(name, password);
        log.error(entity.getRoleEntity().getRoleId() + "-" + entity.getRoleEntity().getName());
    }
}
