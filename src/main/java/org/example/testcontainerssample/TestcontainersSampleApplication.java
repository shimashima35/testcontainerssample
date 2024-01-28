package org.example.testcontainerssample;

import org.example.testcontainerssample.entity.Greeting;
import org.example.testcontainerssample.repository.GreetingRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestcontainersSampleApplication {

  private static final Logger log = LoggerFactory.getLogger(TestcontainersSampleApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(TestcontainersSampleApplication.class, args);
  }

  @Autowired
  private GreetingRepository greetingRepository;

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
    Greeting greeting = new Greeting(name);
    var result = greetingRepository.save(greeting);
    log.info(result.toString());
    return String.format("Hello %s!", name);
  }
}
