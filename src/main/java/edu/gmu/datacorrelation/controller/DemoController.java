package edu.gmu.datacorrelation.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DemoController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public DemoResponse demo(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new DemoResponse(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class DemoResponse {
        private long timesCalled;
        private String content;
    }
}
