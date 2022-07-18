package intelitrader.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import intelitrader.resources.ProductResources;

public class Product implements ProductResources {

	// Primary key.
	private Long id;
	private Integer quantityInventory;
	private Integer quantityMinCo;

	public Product() {
	}

	public Product(Long id, Integer quantityInventory, Integer quantityMinCo) {
		this.id = id;
		this.quantityInventory = quantityInventory;
		this.quantityMinCo = quantityMinCo;
	}

	public Integer getQuantityInventory() {
		return quantityInventory;
	}

	public void setQuantityInventory(Integer quantityInventory) {
		this.quantityInventory = quantityInventory;
	}

	public Integer getQuantityMinCo() {
		return quantityMinCo;
	}

	public void setQuantityMinCo(Integer quantityMinCo) {
		this.quantityMinCo = quantityMinCo;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", quantityInventory=" + quantityInventory + ", quantityMinCo=" + quantityMinCo
				+ "]";
	}

	@Override
	public void readProducts(String pathProducts, List<Product> products) {
		try (BufferedReader br = new BufferedReader(new FileReader(pathProducts))) {
			String line = br.readLine();
			while (line != null) {
				String fields[] = line.split(";");
				Long id = Long.parseLong(fields[0]);
				Integer quantityInventory = Integer.parseInt(fields[1]);
				Integer quantityMinCo = Integer.parseInt(fields[2]);

				products.add(new Product(id, quantityInventory, quantityMinCo));
				line = br.readLine();

			}
		} catch (IOException e) {
			System.out.println("Error captured: " + e.getMessage());
		} finally {
			System.out.println(pathProducts + " was read successfuly!");
		}

	}
}
