package com.example.SimpleCalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	@GetMapping("/checkapplication")
	public String saveBook() {

		return "application is up!!";
	}

	@GetMapping("/addition")
	public String doAddition(@RequestParam(required = true) Double number1, @RequestParam(required = true) Double number2) {
		double a = Double.valueOf(number1);
		double b = Double.valueOf(number2);
		return "result of addition :" + (a + b);
	}

	@GetMapping("/subtraction")
	public String doSubtraction(@RequestParam(required = true) Double number1, @RequestParam(required = true) Double number2) {
		double a = Double.valueOf(number1);
		double b = Double.valueOf(number2);
		double c = 0.0;
		if (a >= b) {
			c = a - b;
		} else {
			c = b - a;
		}
		return "result of subtraction :" + c;
	}

	@GetMapping("/division")
	public String doDivision(@RequestParam(required = true) Double number1, @RequestParam(required = true) Double number2) {
		double a = Double.valueOf(number1);
		double b = Double.valueOf(number2);
		String resultstatus = null;
		double c = 0.0;
		if (a == 0 && b != 0 && b > 0) {
			c = a / b;
			resultstatus = "done";
		} else if (b == 0 && a != 0 && a > 0) {
			c = b / a;
			resultstatus = "done";
		} else if (a != 0 && a > 0 && b != 0 && b > 0) {
			c = a / b;
			resultstatus = "done";
		} else {
			resultstatus = "failed";
		}
		return "result of division :" + resultstatus + c;

	}

	@GetMapping("/multiplication")
	public String doMultiplication(@RequestParam(required = true) Double number1, @RequestParam(required = true) Double number2) {
		double a = Double.valueOf(number1);
		double b = Double.valueOf(number2);
		double c = 0.0;

		if (a == 0)
			c = 0;
		else if (b == 0)
			c = 0;
		else
			c = a * b;

		return "result of multiplication :" + c;
	}

}
