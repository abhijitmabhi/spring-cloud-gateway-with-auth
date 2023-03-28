package com.ssp.usermanagement;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user-management/home")
public class HomeController {
    @GetMapping(value = "/welcome", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcomeAsHTML() {
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
    }
//    @RequestMapping("/login")
//    public ModelAndView welcome() throws Exception {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }
}
