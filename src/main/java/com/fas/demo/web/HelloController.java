package com.fas.demo.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Api
@Controller
public class HelloController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping({"/hello", "/hi"})
    public String hello(Model model,
                        @ApiParam("name")
                        @RequestParam(value = "name", required = false, defaultValue = "World") String name)
            throws UnknownHostException {

        String hostname = "@" + InetAddress.getLocalHost().getHostAddress();
        rabbitTemplate.convertAndSend("hello", "hello " + name + hostname);

        model.addAttribute("name", name);
        return "hello";
    }
}
