package bean;

public class Coupon {
	private String provider;
	private String nameOfProduct;
	private int priceOfProduct;
	private int rateOfDiscount;
	private int expirationPeriod;
	private boolean isUsed;

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getNameOfProduct() {
		return nameOfProduct;
	}

	public void setNameOfProduct(String nameOfProduct) {
		this.nameOfProduct = nameOfProduct;
	}

	public int getPriceOfProduct() {
		return priceOfProduct;
	}

	public void setPriceOfProduct(int priceOfProduct) {
		this.priceOfProduct = priceOfProduct;
	}

	public int getRateOfDiscount() {
		return rateOfDiscount;
	}

	public void setRateOfDiscount(int rateOfDiscount) {
		this.rateOfDiscount = rateOfDiscount;
	}

	public int getExpirationPeriod() {
		return expirationPeriod;
	}

	public void setExpirationPeriod(int expirationPeriod) {
		this.expirationPeriod = expirationPeriod;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

}
