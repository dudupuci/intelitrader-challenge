package intelitrader.entities;

import java.util.Objects;

public class Product {

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

}
