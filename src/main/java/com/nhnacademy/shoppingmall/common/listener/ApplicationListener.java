package com.nhnacademy.shoppingmall.common.listener;

import com.nhnacademy.shoppingmall.common.mvc.transaction.DbConnectionThreadLocal;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.repository.impl.UserRepositoryImpl;
import com.nhnacademy.shoppingmall.user.service.UserService;
import com.nhnacademy.shoppingmall.user.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@WebListener
public class ApplicationListener implements ServletContextListener {
    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //todo#12 application 시작시 테스트 계정인 admin,user 등록합니다. 만약 존재하면 등록하지 않습니다.
        DbConnectionThreadLocal.initialize();
        ServletContext context = sce.getServletContext();
        if (Objects.isNull(userService.getUser("admin"))) {

            User adminUser = new User("admin", "어드민", "12345", "012345", User.Auth.ROLE_ADMIN, 100_0000, LocalDateTime.now(), LocalDateTime.now());
            userService.saveUser(adminUser);

        }
        if (Objects.isNull(userService.getUser("user"))) {

            User user = new User("user", "유저", "12345", "012345", User.Auth.ROLE_USER, 100_0000, LocalDateTime.now(), LocalDateTime.now());
            userService.saveUser(user);

        }
        context.setAttribute("userService", userService);

        log.info("user saved");
        DbConnectionThreadLocal.reset();
    }
}
