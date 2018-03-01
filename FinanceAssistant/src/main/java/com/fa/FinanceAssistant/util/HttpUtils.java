package com.fa.FinanceAssistant.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpUtils {
    public static void writeValueToResponse(HttpServletResponse httpServletResponse, Object value){
        Logger logger = LoggerFactory.getLogger("writeValueToResponse");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setHeader("Content-type", "application/json;charset=utf-8");
        try {
            String message =new ObjectMapper().writeValueAsString(value);
            logger.info(message);
            httpServletResponse.getWriter().append(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpServletResponse.setStatus(200);
    }
}
