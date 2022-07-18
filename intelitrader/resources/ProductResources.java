package intelitrader.resources;

import java.util.List;

import intelitrader.entities.Product;

public interface ProductResources {
	
	public void readProducts(String path, List<Product> products);

}
