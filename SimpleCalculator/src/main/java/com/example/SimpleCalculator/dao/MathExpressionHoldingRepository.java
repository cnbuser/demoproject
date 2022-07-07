package com.example.SimpleCalculator.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleCalculator.bean.MathExpressionRequest;

public interface MathExpressionHoldingRepository extends JpaRepository<MathExpressionRequest, Integer> {

}
