package intelitrader.entities;

import java.util.Objects;

import intelitrader.enums.SalesChannel;
import intelitrader.enums.Status;

public class Order extends Product {

	private Product productId;
	private Integer soldAmount;
	private Status status;
	private SalesChannel channel;

	public Order() {
	}

	public Order(Product productId, Integer soldAmount, Status status, SalesChannel channel) {
		this.productId = productId;
		this.soldAmount = soldAmount;
		this.status = status;
		this.channel = channel;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Integer getSoldAmount() {
		return soldAmount;
	}

	public void setSoldAmount(Integer soldAmount) {
		this.soldAmount = soldAmount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public SalesChannel getChannel() {
		return channel;
	}

	public void setChannel(SalesChannel channel) {
		this.channel = channel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(productId, other.productId);
	}

}
