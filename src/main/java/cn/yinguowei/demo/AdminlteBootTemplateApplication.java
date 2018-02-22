package cn.yinguowei.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class AdminlteBootTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminlteBootTemplateApplication.class, args);
    }
}

@Controller
class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = {"/*.html", "/*/*.html", "/*/*/*.html"})
    public String hello(HttpServletRequest request) {
        logger.info("path = {}", request);
        logger.info("request.getRequestURI() = {}", request.getRequestURI());
        return request.getRequestURI();
    }
}