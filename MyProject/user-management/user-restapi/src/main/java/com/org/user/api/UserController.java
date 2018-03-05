package com.org.user.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.user.bean.User;

@RestController
public class UserController {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public User greeting(@RequestParam(required=false, value="name", defaultValue="World") String name) {
        return new User(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
