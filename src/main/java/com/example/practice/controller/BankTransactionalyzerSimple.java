package com.example.practice.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankTransactionalyzerSimple {
	private static final String RESOURCES = "src/main/resources/";
	private static final String RESOURCES2 = "C:\\Users\\woogyeong\\eclipse-workspace\\com-example-practice\\src\\main\\resources\\";
	
	@RequestMapping("/total")
	public static String main(String[] args, Model model) throws IOException{
		
		final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
		double total = 0d;
//		final String fileName = args[0];
		final Path path = Paths.get(RESOURCES2 + "bank-data-simple.csv");
		final List<String> lines = Files.readAllLines(path);
		
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
		double totalAmount = calculateTotalAmount(bankTransactions);
		List<BankTransaction> selectMonth = selectMonth(bankTransactions, Month.JANUARY);
		
		model.addAttribute("total", totalAmount);
		System.err.println(selectMonth);
		model.addAttribute("month", selectMonth);
		
		return "index";
	}
	
	public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		double total = 0d;
		
		for(final BankTransaction bankTranscation: bankTransactions) {
			total += bankTranscation.getAmount();
		}
		
		return total;
	}
	
	public static List<BankTransaction> selectMonth(final List<BankTransaction> bankTransactions, final Month month){
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
		
		for(final BankTransaction bankTransaction:bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}			
		}
		return bankTransactionsInMonth;
	}
}
