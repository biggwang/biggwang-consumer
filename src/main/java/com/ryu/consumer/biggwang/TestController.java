package com.ryu.consumer.biggwang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        LocalDateTime now = LocalDateTime.now();
        log.warn("######################## gogo1:" + now);
        return "test:" + now;
    }

}
