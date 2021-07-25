package com.web.core.controller.admin;

import com.web.core.command.UserCommand;
import com.web.core.dto.UserDTO;
import com.web.core.service.UserService;
import com.web.core.service.impl.UserServiceImpl;
import com.web.core.web.common.WebConstant;
import com.web.core.web.utils.FormUtil;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //common bean utils trong servlet
        UserCommand command = FormUtil.populate((UserCommand.class), req);
        UserDTO pojo = command.getPojo();
        UserService userService = new UserServiceImpl();
        try {
            if (userService.isUserExist(pojo) != null) {
                if (userService.findRoleByUser(pojo) != null && userService.findRoleByUser(pojo).getRoleDTO() != null) {
                    if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_ADMIN)) {
                        req.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
                        req.setAttribute(WebConstant.MESSAGE_RESPONSE, "Ban la ADMIN");
            } else if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_USER)) {
                req.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
                req.setAttribute(WebConstant.MESSAGE_RESPONSE, "Ban la USER");
            }

        }
            }
        } catch (NullPointerException e) {
            log.error(e.getMessage(), e);
            req.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
            req.setAttribute(WebConstant.MESSAGE_RESPONSE, "Sai tai khoan hoac mat khau");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(req, resp);
    }
}
