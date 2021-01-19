package com.example.practice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.practice.Interface.BankStatementParser;

@Controller
public class MainApplication {
	
	@RequestMapping("/main")
	public void main(final String[] args) throws IOException{
		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		final BankStatementParser bankStatementParser = new BankStatementCSVParser();
		
		bankStatementAnalyzer.analyze("bank-data-simple.csv", bankStatementParser);
	}
}
