package com.web.core.test;

import com.web.core.dao.ListenGuidelineDAO;
import com.web.core.daoimpl.ListenGuidelineDAOImpl;
import org.testng.annotations.Test;

public class ListenGuidelineTest {
    @Test
    public void checkFindByFroperty() {
        ListenGuidelineDAO dao = new ListenGuidelineDAOImpl();
        Object[] object = dao.findyProperty(null,null,null,null,2,2);
    }
}
