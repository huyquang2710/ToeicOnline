package com.web.core.controller.admin;

import com.web.core.command.ListenguidelineCommand;
import com.web.core.dto.ListenGuidelineDTO;
import com.web.core.service.ListenGuidelineService;
import com.web.core.service.impl.ListenGuidelineServiceImpl;
import com.web.core.web.common.WebConstant;
import com.web.core.web.utils.RequestUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin-guideline-listen-list.html")
public class ListenGuidelineController extends HttpServlet {
    private ListenGuidelineService listenGuidelineService = new ListenGuidelineServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       ListenguidelineCommand command = new ListenguidelineCommand();
        command.setMaxPageItems(1);
        RequestUtil.initSearchBean(req, command);

        Object[] objects = listenGuidelineService.findListenGuidelineByProperti(null, null, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems()).toArray();
        command.setListResult((List<ListenGuidelineDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
        req.setAttribute(WebConstant.LIST_ITEMS,command);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
