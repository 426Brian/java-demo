package com.concurrent.webapp;

import com.cmd.Shutdown;
import com.concurrent.service.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Brian in 22:57 2018/3/23
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private Test test;

    // 此全局变量会出现并发线程不安全问题
    private String name;

    @RequestMapping(params = "m=cur")
    public String current(HttpServletRequest req){
        System.out.println("=test = "+test.hashCode());
        String name = test.getName(req.getParameter("name"));
        System.out.println("=== nameBef = "+name);
        req.setAttribute("nameBef", name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("=== nameAft = "+name);
        req.setAttribute("nameAft", name);
        return "concurrent/test";
    }

    @RequestMapping(params = "m=shut")
    public void shutdown(){
        System.out.println(" == come in ");
        Shutdown.main(null);
    }
}
