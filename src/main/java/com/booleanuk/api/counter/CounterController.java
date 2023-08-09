package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {
    private int count;

    public CounterController() {
        this.count = 0;
    }

    @GetMapping("/counter")
    public int getCount() {
        return this.count;
    }
}
