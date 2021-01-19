package com.example.practice.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.practice.Interface.BankStatementParser;

@Controller
public class BankStatementAnalyzer {
	private static final String RESOURCES = "src/main/resources/";
	private static final String RESOURCES2 = "C:\\Users\\woogyeong\\eclipse-workspace\\com-example-practice\\src\\main\\resources\\";
//	private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
	
//	public void main(final String[] args) throws IOException{
//		final String fileName = "bank-data-simple.csv";
//		final Path path = Paths.get(RESOURCES2 + fileName);
//		final List<String> lines = Files.readAllLines(path);
//		
//		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines); // 엑셀파일 읽기
//		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions); // 읽은 데이터 담기
//		
//		collectSummary(bankStatementProcessor);
//	}
	
	public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException{
		final Path path = Paths.get(RESOURCES2 + fileName);
		final List<String> lines = Files.readAllLines(path);
		
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines); // 엑셀파일 읽기
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions); // 읽은 데이터 담기
		
		collectSummary(bankStatementProcessor);

	}
	
    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {

        System.out.println("The total for all transactions is "
                + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is "
                + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is "
                + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
