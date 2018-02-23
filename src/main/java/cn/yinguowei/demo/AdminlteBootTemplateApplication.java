package cn.yinguowei.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yinguowei 2018-2-22
 */
@SpringBootApplication
public class AdminlteBootTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminlteBootTemplateApplication.class, args);
    }
}

@Controller
class DynamicController {
    Logger logger = LoggerFactory.getLogger(DynamicController.class);

    @RequestMapping(value = {"/*.html", "/*/*.html", "/*/*/*.html"})
    public String route(HttpServletRequest request) {
        logger.info("request.getRequestURI() = {}", request.getRequestURI());
        return request.getRequestURI();
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index.html";
    }
}