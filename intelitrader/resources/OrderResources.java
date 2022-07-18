package intelitrader.resources;

import java.util.List;

import intelitrader.entities.Order;

public interface OrderResources {
	
	public void readOrders(String path, List<Order> orders);

}
