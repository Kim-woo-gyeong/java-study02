package com.example.practice.Interface;

import com.example.practice.controller.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {
	double summarize(double accumulator, BankTransaction bankTransaction);
}
