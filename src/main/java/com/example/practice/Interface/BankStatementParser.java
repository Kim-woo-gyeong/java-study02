package com.example.practice.Interface;

import java.util.List;

import com.example.practice.controller.BankTransaction;

public interface BankStatementParser {
	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);
}
