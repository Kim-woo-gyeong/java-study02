package com.example.practice.Interface;

import com.example.practice.controller.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
	boolean test(BankTransaction bankTransaction);
}
