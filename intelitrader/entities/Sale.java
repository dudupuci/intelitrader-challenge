package intelitrader.entities;

import java.io.BufferedReader;
import java.io.File;
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
	public void readSales(String pathSales, List<Sale> sales, List<Product> products) {
		int sum16320 = 0;
		int sum23400 = 0;
		int sum26440 = 0;
		int sum28790 = 0;
		int sum36540 = 0;
		int stock16320 = 0;
		int stock23400 = 0;
		int stock26440 = 0;
		int stock28790 = 0;
		int stock36540 = 0;
		int rest16320 = 0;
		int rest23400 = 0;
		int rest26440 = 0;
		int rest28790 = 0;
		int rest36540 = 0;
		int transfer16320 = 0;
		int transfer23400 = 0;
		int transfer26440 = 0;
		int transfer28790 = 0;
		int transfer36540 = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(pathSales))) {

			String line = br.readLine();

			while (line != null) {
				String fields[] = line.split(";");
				Product productId = new Product(Long.parseLong(fields[0]), null, null);
				Integer soldAmount = Integer.parseInt(fields[1]);
				Integer status = Integer.parseInt(fields[2]);
				Integer channel = Integer.parseInt(fields[3]);

				sales.add(new Sale(productId.getId(), soldAmount, status, channel));

				if (productId.getId() == 16320 && status == 100 || productId.getId() == 16320 && status == 102) {
					sum16320 = sum16320 + soldAmount;

				} else if (productId.getId() == 23400 && status == 100 || productId.getId() == 23400 && status == 102) {
					sum23400 = sum23400 + soldAmount;
				} else if (productId.getId() == 26440 && status == 100 || productId.getId() == 26440 && status == 102) {
					sum26440 = sum26440 + soldAmount;
				} else if (productId.getId() == 28790 && status == 100 || productId.getId() == 28790 && status == 102) {
					sum28790 = sum28790 + soldAmount;
				} else if (productId.getId() == 36540 && status == 100 || productId.getId() == 36540 && status == 102) {
					sum36540 = sum36540 + soldAmount;
				}

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

					if (id == 16320 && quantityInventory == 344) {
						stock16320 = quantityInventory - sum16320;
						rest16320 = quantityMinCo - stock16320;
						transfer16320 = rest16320;
						if (rest16320 < 0) {
							rest16320 = 0;
							transfer16320 = 0;

						} else if (rest16320 > 1 && rest16320 < 10) {
							transfer16320 = 10;
						}

					} else if (id == 23400 && quantityInventory == 1435) {
						stock23400 = quantityInventory - sum23400;
						rest23400 = quantityMinCo - stock23400;
						transfer23400 = rest23400;
						if (rest23400 < 0) {
							rest23400 = 0;
						} else if (rest23400 > 1 && rest23400 < 10) {
							transfer23400 = 10;
						}

					} else if (id == 26440 && quantityInventory == 2899) {
						stock26440 = quantityInventory - sum26440;
						rest26440 = quantityMinCo - stock26440;
						transfer26440 = rest26440;
						if (rest26440 < 0) {
							rest26440 = 0;
							transfer26440 = 0;
						} else if (rest26440 > 1 && rest26440 < 10) {
							transfer26440 = 10;
						}

					} else if (id == 28790 && quantityInventory == 310) {
						stock28790 = quantityInventory - sum28790;
						rest28790 = quantityMinCo - stock28790;
						transfer28790 = rest28790;
						if (rest28790 < 0) {
							rest28790 = 0;
						} else if (rest28790 > 1 && rest28790 < 10) {
							transfer28790 = 10;
						}

					} else if (id == 36540 && quantityInventory == 431) {
						stock36540 = quantityInventory - sum36540;
						rest36540 = quantityMinCo - stock36540;
						transfer36540 = rest36540;
						if (rest36540 < 0) {
							rest36540 = 0;
						} else if (rest36540 > 1 && rest36540 < 10) {
							transfer36540 = 10;
						}
					}

					line2 = br2.readLine();

				}

			} catch (IOException e) {
				throw new SystemException("Error captured: could not read specified file.");
			}

		} catch (IOException e) {
			throw new SystemException("Error captured: could not read specified file.");
		} finally {
			System.out.println(pathSales + " was read successfully!");
		    // Create new file
			
            
			
		}

	}

	@Override
	public String toString() {
		return "Order [productId=" + productId + ", soldAmount=" + soldAmount + ", status=" + status + ", channel="
				+ channel + "]";
	}

}
