package com.web.core.web.utils;

import com.web.core.web.command.AbstractCommand;
import org.apache.commons.lang.StringUtils;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.testng.log4testng.Logger;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    //get Oarameter truyen tu clent ve
    public static void initSearchBean(HttpServletRequest request, AbstractCommand bean) {
        //tat ca gia tri nhan tu client ve controll deu la String
        // can phai chuyen ve value mong muon de dua ve DB
        if (bean != null) {
            // xac dinh truong ma ban muon sort
            String sortExpresstion = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_SORT)); //get thma so truyen tu clieant ve. Servelet phai dung Parame tdelay gia tri
            String sortDirectin = request.getParameter(new ParamEncoder((bean.getTableId())).encodeParameterName(TableTagParameters.PARAMETER_ORDER));
            String pageStr = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_PAGE));

            Integer page = 1;
            if (StringUtils.isNotBlank(pageStr)) {
                try {
                    page = Integer.valueOf(pageStr);
                } catch (Exception e) {
                    throw e;
                }
            }
            bean.setPage(page);
            bean.setSortDirection(sortDirectin);
            bean.setSortExpression(sortExpresstion);
            bean.setFirstItem((bean.getPage() - 1) * bean.getMaxPageItems());
        }
     }
}
