package sk.stuba.fei.uim.oop.assignment3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tomas")
public class FirstController {
    
    @GetMapping("/introduction")
    public String introduceString(){
        return "ahoj svet";
    }

    @GetMapping("/ager")
    public int showAge(){
        return 20;
    }
}
