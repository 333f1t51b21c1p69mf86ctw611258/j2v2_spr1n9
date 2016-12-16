package org.springframework.samples.petclinic.web;

import org.springframework.samples.petclinic.model.Greeting;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = {"/greeting"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        long id = counter.incrementAndGet();

        return new Greeting(id, String.format(template, name));
    }

}
