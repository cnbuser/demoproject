package com.example.SimpleCalculator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SimpleCalculator.bean.MathExpressionRequest;
import com.example.SimpleCalculator.dao.MathExpressionHoldingRepository;
import com.fathzer.soft.javaluator.DoubleEvaluator;

@RestController
public class MathController {

	//// main controller

	@Autowired
	private MathExpressionHoldingRepository repo;

	@GetMapping("/checkapplication")
	public String checkApplication() {

		return "application is up!!";
	}

	@GetMapping("/evalutionhistory")
	public List<String> getEvaluationhistory() {

		List<String> expressions = new ArrayList<String>();
		List<MathExpressionRequest> returnexpression = repo.findAll();
		for (MathExpressionRequest eachrequest : returnexpression) {
			expressions.add(eachrequest.getEvaluated_expression());
		}
		return expressions;
	}

	@GetMapping("/calculate")
	public String doCalculateMathexpression(@RequestParam(value = "formula", defaultValue = "") String formula) {
		String exp = String.valueOf(formula);
		DoubleEvaluator eval = new DoubleEvaluator();
		Double result = eval.evaluate(exp);
		MathExpressionRequest request = new MathExpressionRequest();
		request.setEvaluated_expression(exp + " = " + result);
		repo.save(request);
		return "result of the calculation :" + result;
	}

	@GetMapping("/clearexpression")
	public String doClearexpression() {

		repo.deleteAll();
		return "All previous expression deleted";
	}

	@GetMapping("/addition")
	public String doAddition(@RequestParam(required = true) Double number1,
			@RequestParam(required = true) Double number2) {
		double a = Double.valueOf(number1);
		double b = Double.valueOf(number2);
		MathExpressionRequest request = new MathExpressionRequest();
		request.setEvaluated_expression(a + " + " + b + "=" + (a + b));
		repo.save(request);
		return "result of addition :" + (a + b);
	}

	@GetMapping("/subtraction")
	public String doSubtraction(@RequestParam(required = true) Double number1,
			@RequestParam(required = true) Double number2) {
		double a = Double.valueOf(number1);
		double b = Double.valueOf(number2);
		double c = 0.0;
		boolean f = false;
		if (a >= b) {
			c = a - b;
			f = true;
		} else {
			c = b - a;
		}
		MathExpressionRequest request = new MathExpressionRequest();
		if (f)
			request.setEvaluated_expression(a + " - " + b + "=" + (a - b));
		else
			request.setEvaluated_expression(b + " - " + a + "=" + (b - a));

		repo.save(request);
		return "result of subtraction :" + c;
	}

	@GetMapping("/division")
	public String doDivision(@RequestParam(required = true) Double number1,
			@RequestParam(required = true) Double number2) {
		double a = Double.valueOf(number1);
		double b = Double.valueOf(number2);
		String resultstatus = null;

		MathExpressionRequest request = new MathExpressionRequest();
		double c = 0.0;
		if (a == 0 && b != 0 && b > 0) {
			c = a / b;
			request.setEvaluated_expression(a + "/" + b + "=" + a / b);
			resultstatus = "done";
		} else if (b == 0 && a != 0 && a > 0) {
			c = b / a;
			request.setEvaluated_expression(b + "/" + a + "=" + b / a);
			resultstatus = "done";
		} else if (a != 0 && a > 0 && b != 0 && b > 0) {
			c = a / b;
			request.setEvaluated_expression(a + "/" + b + "=" + a / b);
			resultstatus = "done";
		} else {
			if(a==0 && b==0) {
			resultstatus = "failed";
			request.setEvaluated_expression(0 + "/" + 0 + "=" + "ERROR");
			}
			else {
				resultstatus = "done";
				request.setEvaluated_expression(a + "/" + b + "=" + a/b);
				c = a / b;
				
			}
		}
		repo.save(request);
		return "result of division :" + resultstatus + c;

	}

	@GetMapping("/multiplication")
	public String doMultiplication(@RequestParam(required = true) Double number1,
			@RequestParam(required = true) Double number2) {
		double a = Double.valueOf(number1);
		double b = Double.valueOf(number2);
		double c = 0.0;

		if (a == 0)
			c = 0;
		else if (b == 0)
			c = 0;
		else
			c = a * b;

		MathExpressionRequest request = new MathExpressionRequest();

		request.setEvaluated_expression(a + " * " + b + "=" + (a * b));

		repo.save(request);

		return "result of multiplication :" + c;
	}

}
