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
		// Reading orders informations
		Order o = new Order();
		o.readOrders(pathSales, orders);

		// GERAR UM ARQUIVO COM
		// Produto | QntdCentroOperacional | QntdMinimaCo | QtndVendas |
		// EstoqueApósVendas | Necess.TransferenciaP/Co
		// transfere.txt

		// products.forEach(System.out::println);
		orders.forEach(System.out::println);

		read.close();
	}

}
