package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int count;
    private Map<String, Integer> counters;

    public CounterController() {
        this.count = 0;
        this.counters = new HashMap<>();
    }

    @GetMapping
    public int getCount() {
        return this.count;
    }

    @GetMapping("/increment")
    public int increment() {
        this.count++;
        return this.count;
    }

    @GetMapping("/decrement")
    public int decrement() {
        this.count--;
        return this.count;
    }

    @GetMapping("/{name}")
    public int getNamedCounter(@PathVariable String name) {
        if (!this.counters.containsKey(name)) {
            this.counters.put(name, 0);
        }
        return this.counters.get(name);
    }

    @GetMapping("/{name}/increment")
    public int incrementNamedCounter(@PathVariable String name) {
        if(!this.counters.containsKey(name)) {
            this.counters.put(name, 1);
        } else {
            this.counters.put(name, this.counters.get(name) + 1);
        }
        return this.counters.get(name);
    }

    @GetMapping("/{name}/decrement")
    public int decrementNamedCounter(@PathVariable String name) {
        if(!this.counters.containsKey(name)) {
            this.counters.put(name, -1);
        } else {
            this.counters.put(name, this.counters.get(name) - 1);
        }
        return this.counters.get(name);
    }
}
