package s_lab.sichniy_andriy.portier_digital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/blog" )
public class BlogController {

    @GetMapping( { "", "/" } )
    public String blog() {
        return "blog";
    }

}
