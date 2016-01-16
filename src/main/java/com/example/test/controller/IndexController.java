package com.example.test.controller;

import com.example.test.entity.User;
import com.example.test.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Anup on 8/3/15.
 */

@Controller
public class IndexController {

    @Inject
    UserRepository userRepository;

    @RequestMapping(value ="/",method = RequestMethod.GET)
    public String welcome(){
        return "new";
    }

    @RequestMapping(value ="/index",method = RequestMethod.GET)
    public String goBack(){
        return "indexNew";
    }

    @RequestMapping(value ="/jpa",method = RequestMethod.GET)
    public String db(){
        Boolean result;
        try{
            User user = userRepository.findOne(1l);
            result = Boolean.TRUE;
        }catch (Exception e){
            result = Boolean.FALSE;
        }
        if(result.equals(Boolean.TRUE)){
            return "db";
        }

        return "dbError";

    }

    @RequestMapping(value = "/loginUser",method = RequestMethod.GET)
    public String loginPage(){
        return "indexNew";
    }

    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public String loginAuthentication(){
        return "loginSucess";
    }

    @RequestMapping(value = "/logoutSuccess",method = RequestMethod.GET)
    public String logoutSucess(){
        return "logoutSuccess";
    }

    @RequestMapping(value = "/loginFailed",method = RequestMethod.GET)
    public String loginFailed(HttpServletRequest request,HttpServletResponse response){
        if(request != null){
            String error = request.toString();
        }

        return "loginFailed";
    }


}
