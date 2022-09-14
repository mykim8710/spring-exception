package com.example.exception.resolver;

import com.example.exception.exception.UserException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class UserHandlerExceptionResolver implements HandlerExceptionResolver {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try {
            if(ex instanceof UserException) {
                log.info("UserException resolver to 400");
                String acceptHeader = request.getHeader("accept");
                System.out.println("acceptHeader = " + acceptHeader);

                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

                if(acceptHeader.equals("application/json")) {
                    Map<String, Object> errResult = new HashMap<>();

                    errResult.put("ex", ex.getClass());
                    errResult.put("message", ex.getMessage());

                    response.setContentType("application/json");
                    response.setCharacterEncoding("utf-8");
                    response.getWriter().write(objectMapper.writeValueAsString(errResult));
                    return new ModelAndView();
                } else {
                    // text/html
                    return new ModelAndView("error/500");
                }
            }
        } catch (IOException e) {
            log.error("resolver error", e);
        }

        return null;
    }
}
