package com.kvn.controller;


import com.kvn.dao.UserDao;
import com.kvn.entity.ChatSession;
import com.kvn.entity.User;
import com.kvn.entity.User2;
import com.kvn.entity.UserProfile;
import com.kvn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by art on 9/8/16.
 */
@Controller
@RequestMapping("/user")
public class UserManagmentController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public void getUserData(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = {"/reg"}, method = RequestMethod.GET)
    public void getUserData() {
        userService.addUser(getData());
    }

    private User getData() {
//      User u= user.findById(1);
        User user = new User();
        user.setEmail("Art@jdfhsdkj");
        user.setFirstName("lasdjkf");
  //  user.setId(1);
        user.setLastName("dghsgd");
        user.setPassword("hsdfcaHSDF");
        user.setSsoId("1");
        user.setState("1");
       /* UserProfile up = new UserProfile();
        up.setId(1);
        up.setType("ACTIVE");
        Set<UserProfile> listup = new HashSet<UserProfile>();
        listup.add(up);
        user.setUserProfiles(listup);
        listup.add(up);
        user.setUserProfiles(listup);
        ChatSession cs = new ChatSession();
        cs.setChat_id(1);
        cs.setInitiator("user");
        cs.setPartner("user");
        cs.setTopic_id(1);
        cs.setUser(user);

        Set<ChatSession> chatSessions = new HashSet<ChatSession>();
        chatSessions.add(cs);
        user.setChatSessions(chatSessions);*/
        return user;
    }

    @RequestMapping(value = {"/registration/{userId}"}, method = RequestMethod.GET)
    public String homePage2(@PathVariable("userId") int user) {

        return "index";
    }

}
