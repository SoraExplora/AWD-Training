package org.esprit.notification;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationRestAPI {
    @GetMapping("/hello")
    public String hello() {
        return "Hello I am Mic4";
    }
}
