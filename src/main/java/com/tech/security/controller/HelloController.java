package com.tech.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
  @GetMapping("/test")
  public String test() {
    return "Hello controller with spring security";
  }

  @GetMapping("/save")
  public String save() {
    return "Hello Save controller with spring security";
  }
}
