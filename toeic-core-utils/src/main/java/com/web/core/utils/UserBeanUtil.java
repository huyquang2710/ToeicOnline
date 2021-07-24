package com.web.core.utils;

import com.web.core.dto.UserDTO;
import com.web.core.persistence.entity.UserEntity;

public class UserBeanUtil {
    public static UserDTO entityToDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setUserId(entity.getUserId());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setFullName(entity.getFullName());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setRoleDTO(RoleBeanUtil.entityToDTO(entity.getRoleEntity()));
        return dto;
    }
    public static UserEntity dtoToEntity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        dto.setUserId(dto.getUserId());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setFullName(dto.getFullName());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setRoleEntity(RoleBeanUtil.dtoToEntity(dto.getRoleDTO()));
        return entity;
    }
}
