package com.seavus.example.webcalculator.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class WebCalculatorController {


    @RequestMapping(path = "/calculate", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String calculate(@RequestParam String numOne, @RequestParam String operator, @RequestParam String numTwo) {


        return operator.equals("-") ? String.valueOf(Integer.parseInt(numOne) - Integer.parseInt(numTwo)) : String.valueOf(Integer.parseInt(numOne) + Integer.parseInt(numTwo));
    }
}
