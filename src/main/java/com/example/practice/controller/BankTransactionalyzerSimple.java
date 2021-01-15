package com.example.practice.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		final Path path = Paths.get(RESOURCES2 + "bank-data-simple.csv");
		System.out.println(path);
		final List<String> lines = Files.readAllLines(path);
		
		double total = 0d;
		
		for(final String line: lines) {
			final String[] colomns = line.split(",");
			final double amount = Double.parseDouble(colomns[1]);
			
			total += amount;
		}
		
		model.addAttribute("total", total);
		System.out.println(total);
		
		return "index";
	}
}
