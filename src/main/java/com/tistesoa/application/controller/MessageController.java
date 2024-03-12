package com.tistesoa.application.controller;

import com.tistesoa.application.controller.vo.Greeting;
import com.tistesoa.infrastructure.MessageProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessageController {

  MessageProducer mp;

  public MessageController(MessageProducer mp){
    this.mp = mp;
  }

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    String message = String.format("Hello, %s!", name);
    mp.sendMessage(message);
    return new Greeting(message);
  }
}

