package com.heiha.sinfonia.example.controller;

import com.heiha.sinfonia.example.util.MailUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <br>
 * <b>Project:</b> example<br>
 * <b>Date:</b> 2017/8/22 10:25<br>
 * <b>Author:</b> heiha<br>
 */
@RestController
@RequestMapping("/v1/example")
public class ExampleController {
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public void info() {
        MailUtil.send("example info has been called");
    }
}
