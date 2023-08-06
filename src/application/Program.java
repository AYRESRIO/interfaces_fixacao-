package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		;
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter contract data: ");
		System.out.print("Number:");
		int contractNumber = sc.nextInt();
		System.out.print("Date: (dd/MM/yyyy) ");
		LocalDate dueDate = LocalDate.parse(sc.next(), fmt);
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();

		Contract contract = new Contract(contractNumber, dueDate, totalValue);

		System.out.print("Enter the number of installments: ");
		int n = sc.nextInt();

		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, n);

		System.out.println(("Installments: "));

		for (Installment installment : contract.getInsttallments()) {
			System.out.println(installment);

		}

		sc.close();

	}

}
