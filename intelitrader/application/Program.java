package intelitrader.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import intelitrader.entities.Order;
import intelitrader.entities.Product;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);

		// Products informations
		List<Product> products = new ArrayList<>();
		String pathProducts = "C:\\Users\\HP\\eclipse-workspace\\intelitrader\\produtos.txt";
		// Sales informations
		List<Order> orders = new ArrayList<>();
		String pathSales = "C:\\Users\\HP\\eclipse-workspace\\intelitrader\\vendas.txt";

		// Reading products informations
		Product p = new Product();
		p.readProducts(pathProducts, products);

		Order o = new Order();
		o.readOrders(pathSales, orders);

		System.out.println("TESTE");
		for (Order x : orders) {
			System.out.println(x);
		}
		
		for (Product x : products) {
			System.out.println(x);
		}

		read.close();
	}

}
