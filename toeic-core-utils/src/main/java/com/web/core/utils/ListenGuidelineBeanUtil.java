package com.web.core.utils;

import com.web.core.dto.ListenGuidelineDTO;
import com.web.core.dto.UserDTO;
import com.web.core.persistence.entity.ListenGuidelineEntity;
import com.web.core.persistence.entity.UserEntity;

public class ListenGuidelineBeanUtil {
    public static ListenGuidelineDTO entityToDTO(ListenGuidelineEntity entity) {
        ListenGuidelineDTO dto = new ListenGuidelineDTO();
        dto.setListenguidelineId(entity.getListenguidelineId());
        dto.setContent(entity.getContent());
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }
    public static ListenGuidelineEntity dtoToEntity(ListenGuidelineDTO dto) {
        ListenGuidelineEntity entity = new ListenGuidelineEntity();
        entity.setListenguidelineId(dto.getListenguidelineId());
        entity.setContent(dto.getContent());
        entity.setImage(dto.getImage());
        entity.setTitle(dto.getTitle());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setModifiedDate(dto.getModifiedDate());
        return entity;
    }
}
