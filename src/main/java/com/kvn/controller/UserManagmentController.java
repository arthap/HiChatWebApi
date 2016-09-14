package com.kvn.controller;


import com.kvn.dao.UserDao;
import com.kvn.entity.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by art on 9/8/16.
 */
@Controller
@RequestMapping("/user")
public class UserManagmentController {

@Autowired
UserDao user;
    @RequestMapping(value = { "/registration"}, method = RequestMethod.GET)
    public @ResponseBody User2 getUserData() {



        return getData();
    }


private User2 getData(){
//       user.findById(1);
    User2 user =new User2();
    user.setEmail("Art@jdfhsdkj");
    user.setFirstName("lasdjkf");
    user.setId(1);
    user.setLastName("dghsgd");
    user.setPassword("hsdfcaHSDF");
    user.setSsoId("1");
    user.setState("1");

    return user;
    }

    @RequestMapping(value = { "/registration/{userId}"}, method = RequestMethod.GET)
    public String homePage2(  @PathVariable("userId") int user ){

        return "index";
    }

}
