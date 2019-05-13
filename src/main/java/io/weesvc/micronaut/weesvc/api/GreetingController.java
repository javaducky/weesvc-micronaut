package io.weesvc.micronaut.weesvc.api;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;
import io.weesvc.micronaut.weesvc.domain.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@Controller("/greeting")
public class GreetingController {

    private static final String GREETING_TEMPLATE = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting greeting(@QueryValue(value="name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(GREETING_TEMPLATE, name));
    }

}
