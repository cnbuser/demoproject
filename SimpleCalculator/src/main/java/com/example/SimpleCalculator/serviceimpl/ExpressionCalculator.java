package com.example.SimpleCalculator.serviceimpl;

import java.util.Stack;

public class ExpressionCalculator {

	
	public static double calvalueofExpression(String s) {
		Stack<Double> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == '(') {
				operators.push(ch);

			} else if (Character.isDigit(ch)) {

				operands.push(Double.valueOf((ch - '0'))); // char to int

			} else if (ch == ')') {
				while (operators.peek() != '(') {
					char oprtor = operators.pop();
					Double v2 = operands.pop();
					Double v1 = operands.pop();
					Double operationvalue = operation(v1, v2, oprtor);
					operands.push(operationvalue);

				}
				operators.pop();
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (operators.size() > 0 && operators.peek() != '('
						&& precedence(ch) <= precedence(operators.peek())) {
					char oprtor = operators.pop();
					Double v2 = operands.pop();
					Double v1 = operands.pop();
					Double operationvalue = operation(v1, v2, oprtor);
					operands.push(operationvalue);

				}
				operators.push(ch);
			}

		}

		while (operators.size() != 0) {
			char oprtor = operators.pop();
			Double v2 = operands.pop();
			Double v1 = operands.pop();
			Double operationvalue = operation(v1, v2, oprtor);
			operands.push(operationvalue);

		}

		return operands.peek();

	}

	public static int precedence(char operator) {

		if (operator == '+') {
			return 1;
		} else if (operator == '-') {
			return 1;
		} else if (operator == '*') {
			return 2;
		} else {
			return 2;
		}

	}

	public static Double operation(Double v1, Double v2, char operator) {

		if (operator == '+') {
			return v1 + v2;
		} else if (operator == '-') {
			return v1 - v2;
		} else if (operator == '*') {
			return v1 * v2;
		} else {
			return v1 / v2;
		}

	}

}
