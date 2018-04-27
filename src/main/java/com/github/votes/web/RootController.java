package com.github.votes.web;

import com.github.votes.AuthorizedUser;
import com.github.votes.model.User;
import com.github.votes.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {
    private final Logger log = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private UserService service;

    @PostMapping("/users")
    public String changeUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = service.get(userId);
        AuthorizedUser.setId(userId);
        AuthorizedUser.setRole(user.getRole());
        log.info("set new user with id {} and role {}", userId, user.getRole());
        return "index.jsp";
    }
}
