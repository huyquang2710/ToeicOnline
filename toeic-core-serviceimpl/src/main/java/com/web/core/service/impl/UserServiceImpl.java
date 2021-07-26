package com.web.core.service.impl;

import com.web.core.dao.UserDAO;
import com.web.core.daoimpl.UserDAOImpl;
import com.web.core.dto.UserDTO;
import com.web.core.persistence.entity.UserEntity;
import com.web.core.service.UserService;
import com.web.core.utils.UserBeanUtil;

public class UserServiceImpl implements UserService {

    @Override
    public UserDTO isUserExist(UserDTO dto) {
        UserDAO userDAO = new UserDAOImpl(); // khoi tao rieng boi co Session va Transaction rieng
        UserEntity entity = userDAO.findUserByUserNameAndPassword(dto.getName(), dto.getPassword());
        return UserBeanUtil.entityToDTO(entity);
    }

    @Override
    public UserDTO findRoleByUser(UserDTO dto) {
        UserDAO userDAO = new UserDAOImpl();
        UserEntity entity = userDAO.findUserByUserNameAndPassword(dto.getName(), dto.getPassword());
        return UserBeanUtil.entityToDTO(entity);
    }
}
