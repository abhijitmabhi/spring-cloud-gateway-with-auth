package com.ssp.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RequestMapping("/user-management")
public class UserManagementApplication {

    @GetMapping("/users")
    public List<User> getUsers() {
        return Stream.of(
                new User(101, "Abhijit M", "Abhi", "abhijit.abhi@cgi.com"),
                new User(101, "Alex R.", "XYZ", "alex.xyz@cgi.com"))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dummy")
    public String renderDummyWebPage(){
       return "login.html";
    }
    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }

}
