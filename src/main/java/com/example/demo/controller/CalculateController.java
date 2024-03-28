package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CalculateController {

	private final CalculateService calculateService;

	
	public CalculateController(CalculateService calculateService) {
		this.calculateService = calculateService;
	}

	@GetMapping("/")
	public String showForm() {
		return "calculatorForm";
	}

	@PostMapping("/calculate")
	public String calculate(@RequestParam("num1") double num1, @RequestParam("num2") double num2,
			@RequestParam("operation") String operation, Model model) {

		double result = 0;
		switch (operation) {
        case "addition":
            result = calculateService.add(num1, num2);
            break;
        case "subtraction":
            result = calculateService.subtract(num1, num2);
            break;
        case "multiplication":
            result = calculateService.multiply(num1, num2);
            break;
        case "division":
            result = calculateService.divide(num1, num2);
            break;
    }
		model.addAttribute("result", result);
//		System.out.println(model);
//		System.out.println(model.hashCode());
//		System.out.println((Double) model.getAttribute("result"));
		return "result";
	}
}
