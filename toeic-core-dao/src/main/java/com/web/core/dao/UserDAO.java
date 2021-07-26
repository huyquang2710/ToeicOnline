package com.web.core.dao;

import com.web.core.persistence.entity.UserEntity;

public interface UserDAO extends GenericDao<Integer, UserEntity>{
/*
    //check Account co tont tai ko
    UserEntity isUserExist(String name, String password);
    //Get Role
    UserEntity findRoleByUser(String name, String password);
*/

    //Clean Code 2 ham tren
    UserEntity findUserByUserNameAndPassword(String name, String password);
}
