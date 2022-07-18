package intelitrader.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import intelitrader.resources.OrderResources;

public class Order extends Product implements OrderResources {

	private Long productId;
	private Integer soldAmount;
	private Integer status;
	private Integer channel;

	public Order() {
	}

	public Order(Long productId, Integer soldAmount, Integer status, Integer channel) {
		this.productId = productId;
		this.soldAmount = soldAmount;
		this.status = status;
		this.channel = channel;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getSoldAmount() {
		return soldAmount;
	}

	public void setSoldAmount(Integer soldAmount) {
		this.soldAmount = soldAmount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getChannel() {
		return channel;
	}

	public void setChannel(Integer channel) {
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

	@Override
	public void readOrders(String pathOrders, List<Order> orders) {

		try (BufferedReader br = new BufferedReader(new FileReader(pathOrders))) {
			String line = br.readLine();

			while (line != null) {
				String fields[] = line.split(";");
				Long productId = Long.parseLong(fields[0]);
				Integer soldAmount = Integer.parseInt(fields[1]);
				Integer status = Integer.parseInt(fields[2]);
				Integer channel = Integer.parseInt(fields[3]);

				orders.add(new Order(productId, soldAmount, status, channel));

				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println(pathOrders + " was read successfully!");
		}

	}

	@Override
	public String toString() {
		return "Order [productId=" + productId + ", soldAmount=" + soldAmount + ", status=" + status + ", channel="
				+ channel + "]";
	}

}
