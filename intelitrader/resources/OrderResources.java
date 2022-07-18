package intelitrader.resources;

import java.util.List;

import intelitrader.entities.Sale;

public interface OrderResources {
	
	public void readOrders(String path, List<Sale> orders);

}
