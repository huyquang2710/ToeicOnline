package com.web.core.utils;

import com.web.core.dto.RoleDTO;
import com.web.core.persistence.entity.RoleEntity;

public class RoleBeanUtil {
    public static RoleDTO entityToDTO(RoleEntity entity) {
        RoleDTO dto = new RoleDTO();
        dto.setRoleId(entity.getRoleId());
        dto.setName((entity.getName()));
        return dto;
    }
    public static RoleEntity dtoToEntity(RoleDTO dto) {
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(dto.getRoleId());
        entity.setName((dto.getName()));
        return entity;
    }
}
