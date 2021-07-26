package com.web.core.service.impl;

import com.web.core.dao.ListenGuidelineDAO;
import com.web.core.daoimpl.ListenGuidelineDAOImpl;
import com.web.core.dto.ListenGuidelineDTO;
import com.web.core.persistence.entity.ListenGuidelineEntity;
import com.web.core.service.ListenGuidelineService;
import com.web.core.utils.ListenGuidelineBeanUtil;

import java.util.ArrayList;
import java.util.List;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {
    ListenGuidelineDAO dao = new ListenGuidelineDAOImpl();
    @Override
    public List<ListenGuidelineDTO> findListenGuidelineByProperti(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        List<ListenGuidelineDTO> result = new ArrayList<>();
        Object[] object = dao.findyProperty(property, value, sortExpression, sortDirection, offset, limit);
        for(ListenGuidelineEntity item: (List<ListenGuidelineEntity>)object[1]) {
            ListenGuidelineDTO dto = ListenGuidelineBeanUtil.entityToDTO(item);
            result.add(dto);
        }
        object[1] = result;
        return result;
    }
}
