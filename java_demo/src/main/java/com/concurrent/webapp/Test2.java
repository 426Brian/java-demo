package com.concurrent.webapp;

import com.designPattern.adaptor.service.ThreeHole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Brian in 23:51 2018/3/23
 */
@Controller
@RequestMapping("/tests")
public class Test2 {

    private String name;

    @RequestMapping(params = "m=test")
    public String test(HttpServletRequest req){

        name = req.getParameter("name");
        System.out.println("== nameBef ="+name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("== nameAft ="+name);
        req.setAttribute("nameAft", name);
        return "concurrent/test";
    }

    @RequestMapping(params = "m=jax")
    @ResponseBody
    public void jax(){

    }
}
