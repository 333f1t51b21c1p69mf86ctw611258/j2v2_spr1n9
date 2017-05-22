package de.jonashackt.tutorial;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.dzs.seawind.web.SeawindWebApplication;

@Configuration
@Import({
        SimpleBootCxfSystemTestConfiguration.class,
        SeawindWebApplication.class
})
public class SimpleBootCxfSystemTestApplication {

}
