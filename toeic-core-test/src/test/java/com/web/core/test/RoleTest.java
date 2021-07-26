package com.web.core.test;

import com.web.core.dao.RoleDao;
import com.web.core.daoimpl.RoleDaoImpl;
import com.web.core.persistence.entity.RoleEntity;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RoleTest {
   /* @Test
    public void checkFindAll() {
        RoleDao roleDao = new RoleDaoImpl();
        List<RoleEntity> list = roleDao.findAll();
    }
    @Test
    public void checkUpdateRole() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(2);
        roleEntity.setName("USER");
        roleDao.update(roleEntity);
    }
    @Test
    public void checkSaveRole() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(3);
        roleEntity.setName("MANAGER");
        roleDao.save(roleEntity);
    }
    @Test
    public void checkFindById() {

        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity = roleDao.findById(1);
    }
    @Test
    public void checkFindByProperty() {
        RoleDao roleDao = new RoleDaoImpl();
        String property = null;
        Object value = null;
        String sortExpression = null;
        String sortDirection = null;
        Object[] object = roleDao.findyProperty(property,value,sortExpression,sortDirection);
    }
    @Test
    public void checkDelete() {
        List<Integer> listId = new ArrayList<>();
        listId.add(3);
        RoleDao roleDao = new RoleDaoImpl();
        Integer count = roleDao.delete(listId);
    }*/
}
