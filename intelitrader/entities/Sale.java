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
	public void readSales(String pathOrders, List<Sale> sales, List<Product> products) {

		try (BufferedReader br = new BufferedReader(new FileReader(pathOrders))) {

			String line = br.readLine();

			while (line != null) {
				String fields[] = line.split(";");
				Product productId = new Product(Long.parseLong(fields[0]), null, null);
				Integer soldAmount = Integer.parseInt(fields[1]);
				Integer status = Integer.parseInt(fields[2]);
				Integer channel = Integer.parseInt(fields[3]);

				sales.add(new Sale(productId.getId(), soldAmount, status, channel));

				line = br.readLine();
			}

			String pathProducts = "C:\\Users\\HP\\eclipse-workspace\\intelitrader\\produtos.txt";
			try (BufferedReader br2 = new BufferedReader(new FileReader(pathProducts))) {
				String line2 = br2.readLine();

				while (line2 != null) {
					String fields2[] = line2.split(";");
					Long id = Long.parseLong(fields2[0]);
					Integer quantityInventory = Integer.parseInt(fields2[1]);
					Integer quantityMinCo = Integer.parseInt(fields2[2]);

					products.add(new Product(id, quantityInventory, quantityMinCo));

					line2 = br2.readLine();

				}

			} catch (IOException e) {
				throw new SystemException("Error captured: could not read specified file.");
			}

		} catch (IOException e) {
			throw new SystemException("Error captured: could not read specified file.");
		} finally {
			System.out.println(pathOrders + " was read successfully!");
			/*for (Sale x : sales) {
				System.out.println(x + " ,");
			}
			for (Product x : products) {
				System.out.println(x);
			}*/
		}

	}

	@Override
	public String toString() {
		return "Order [productId=" + productId + ", soldAmount=" + soldAmount + ", status=" + status + ", channel="
				+ channel + "]";
	}

}
