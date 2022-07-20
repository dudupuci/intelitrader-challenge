package intelitrader.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import intelitrader.entities.Sale;
import intelitrader.entities.Product;
// GERAR UM ARQUIVO COM
// Produto | QntdCentroOperacional | QntdMinimaCo | QtndVendas | EstoqueApósVendas | Necess.TransferenciaP/Co 
// transfere.txt

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);

		// Products informations
		List<Product> products = new ArrayList<>();
		String pathProducts = "C:\\Users\\HP\\eclipse-workspace\\intelitrader\\produtos.txt";

		// Sales informations
		List<Sale> sales = new ArrayList<>();
		String pathSales = "C:\\Users\\HP\\eclipse-workspace\\intelitrader\\vendas.txt";

		// Reading products informations
		Product p = new Product();
		p.readProducts(pathProducts, products);

		// Reading orders informations
		Sale s = new Sale();
		s.readSales(pathSales, sales, products);



		read.close();
	}

}
