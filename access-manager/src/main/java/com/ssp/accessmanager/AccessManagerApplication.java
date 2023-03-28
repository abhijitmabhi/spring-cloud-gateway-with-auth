package com.ssp.accessmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RequestMapping("/access-manager")
public class AccessManagerApplication {

    @GetMapping("/access-managers")
    public List<accessManager> getAccessManagers() {
        return Stream.of(new accessManager(1, "App 101"),
                new accessManager(2, "App 102"))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication.run(AccessManagerApplication.class, args);
    }

}
