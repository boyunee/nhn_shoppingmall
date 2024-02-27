package com.nhnacademy.shoppingmall.controller.auth;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.exception.UserNotFoundException;
import com.nhnacademy.shoppingmall.user.repository.impl.UserRepositoryImpl;
import com.nhnacademy.shoppingmall.user.service.UserService;
import com.nhnacademy.shoppingmall.user.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;
@Slf4j
@RequestMapping(method = RequestMapping.Method.POST,value = "/loginAction.do")
public class LoginPostController implements BaseController {

    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        //todo#13-2 로그인 구현, session은 60분동안 유지됩니다.

        String id = req.getParameter("user_id");
        String pw = req.getParameter("user_password");

        try {
            userService.doLogin(id, pw);
        } catch (UserNotFoundException e) {
            return "redirect:/login.do";
        }

        User user = userService.getUser(id);
        HttpSession session = req.getSession();
        if (Objects.nonNull(user)) {
            session.setAttribute("user", user);
            session.setAttribute("role", user.getUserAuth().toString());
            session.setMaxInactiveInterval(60 * 60);
            log.info("user login completed");
            return "redirect:/index.do";



        }


//        return "shop/main/index";
        log.error("user login failed");
        return "redirect:/login.do";

    }
}
