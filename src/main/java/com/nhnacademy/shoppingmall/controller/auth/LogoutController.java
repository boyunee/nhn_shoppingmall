package com.nhnacademy.shoppingmall.controller.auth;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;
@Slf4j
@RequestMapping(method = RequestMapping.Method.GET,value = "/loginout.do")
public class LogoutController implements BaseController {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        if (Objects.nonNull(session)) {
            session.invalidate();
            log.info("user logout completed");


        }
        return "redirect:/index.do";
    }
    //todo#13-3 로그아웃 구현

}
