package intelitrader.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import intelitrader.exception.SystemException;
import intelitrader.resources.OrderResources;

public class Sale extends Product implements OrderResources {

	private Long productId;
	private Integer soldAmount;
	private Integer status;
	private Integer channel;

	public Sale() {
	}

	public Sale(Long productId, Integer soldAmount, Integer status, Integer channel) {
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
		Sale other = (Sale) obj;
		return Objects.equals(productId, other.productId);
	}

	@Override
	public void readOrders(String pathOrders, List<Sale> orders) {
		double sum16320 = 0.0;
		double sum23400 = 0.0;
		double sum26440 = 0.0;
		double sum28790 = 0.0;
		double sum36540 = 0.0;
		try (BufferedReader br = new BufferedReader(new FileReader(pathOrders))) {
			String line = br.readLine();

			while (line != null) {
				String fields[] = line.split(";");
				Long productId = Long.parseLong(fields[0]);
				Integer soldAmount = Integer.parseInt(fields[1]);
				Integer status = Integer.parseInt(fields[2]);
				Integer channel = Integer.parseInt(fields[3]);

				orders.add(new Sale(productId, soldAmount, status, channel));

				if (productId == 16320 && status == 100 || productId == 16320 && status == 102) {
					sum16320 = sum16320 + soldAmount;
				} else if (productId == 23400 && status == 100 || productId == 23400 && status == 102) {
					sum23400 = sum23400 + soldAmount;
				} else if (productId == 26440 && status == 100 || productId == 26440 && status == 102) {
					sum26440 = sum26440 + soldAmount;
				} else if (productId == 28790 && status == 100 || productId == 28790 && status == 102) {
					sum28790 = sum28790 + soldAmount;
				} else if (productId == 36540 && status == 100 || productId == 36540 && status == 102) {
					sum36540 = sum36540 + soldAmount;
				}

				line = br.readLine();
			}
		} catch (IOException e) {
			throw new SystemException("Error captured: could not read specified file.");
		} finally {
			System.out.println(pathOrders + " was read successfully!");
			// QUANTIDADE DE VENDAS (TEST);
			System.out.println("Code 16320 sum : " + sum16320);
			System.out.println("Code 23400 sum : " + sum23400);
			System.out.println("Code 26440 sum :" + sum26440);
			System.out.println("Code 28790 sum :" + sum28790);
			System.out.println("Code 36540 sum : " + sum36540);
		}

	}

	@Override
	public String toString() {
		return "Order [productId=" + productId + ", soldAmount=" + soldAmount + ", status=" + status + ", channel="
				+ channel + "]";
	}

}
