package com.example.SimpleCalculator.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MathExpressionRequest {
	public MathExpressionRequest() {

	}

	public MathExpressionRequest(int id, String evaluated_expression) {
		super();
		this.id = id;
		this.evaluated_expression = evaluated_expression;
	}

	@Id
	@GeneratedValue
	private int id;
	private String evaluated_expression;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvaluated_expression() {
		return evaluated_expression;
	}

	public void setEvaluated_expression(String evaluated_expression) {
		this.evaluated_expression = evaluated_expression;
	}

	@Override
	public String toString() {
		return "MathExpressionRequest [id=" + id + ", evaluated_expression=" + evaluated_expression + "]";
	}

}
