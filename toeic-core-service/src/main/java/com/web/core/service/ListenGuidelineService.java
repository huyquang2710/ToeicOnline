package com.web.core.service;

import com.web.core.dto.ListenGuidelineDTO;

import java.util.List;

public interface ListenGuidelineService {
    List<ListenGuidelineDTO> findListenGuidelineByProperti(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit);
}
