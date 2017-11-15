package bean;

public class Coupon implements Comparable<Coupon> {
    private String provider;//the name of the coupon provider
    private String nameOfProduct;// the name of the product
    private int priceOfProduct;//the price of the product
    private double rateOfDiscount;//the discount of the product
    private int expirationPeriod;//the expiration period for the coupon
    private boolean isUsed;//the status of the coupon


    public Coupon() {
    }

    public Coupon(String provider, String nameOfProduct, int priceOfProduct, double rateOfDiscount, int expirationPeriod, boolean isUsed) {
        this.provider = provider;
        this.nameOfProduct = nameOfProduct;
        this.priceOfProduct = priceOfProduct;
        this.rateOfDiscount = rateOfDiscount;
        this.expirationPeriod = expirationPeriod;
        this.isUsed = isUsed;
    }

    //the setters and getters for the above attributes
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

    public double getRateOfDiscount() {
        return rateOfDiscount;
    }

    public void setRateOfDiscount(double rateOfDiscount) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coupon coupon = (Coupon) o;

        if (priceOfProduct != coupon.priceOfProduct) return false;
        if (Double.compare(coupon.rateOfDiscount, rateOfDiscount) != 0) return false;
        if (expirationPeriod != coupon.expirationPeriod) return false;
        if (isUsed != coupon.isUsed) return false;
        if (provider != null ? !provider.equals(coupon.provider) : coupon.provider != null) return false;
        return nameOfProduct != null ? nameOfProduct.equals(coupon.nameOfProduct) : coupon.nameOfProduct == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = provider != null ? provider.hashCode() : 0;
        result = 31 * result + (nameOfProduct != null ? nameOfProduct.hashCode() : 0);
        result = 31 * result + priceOfProduct;
        temp = Double.doubleToLongBits(rateOfDiscount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + expirationPeriod;
        result = 31 * result + (isUsed ? 1 : 0);
        return result;
    }

    //the default compare method based on provider
    @Override
    public int compareTo(Coupon o) {
        return this.provider.compareTo(o.provider);
    }

    @Override
    public String toString() {
        return
                provider + " " + nameOfProduct + " " + priceOfProduct + " " + rateOfDiscount + " " + expirationPeriod + " " + isUsed;
    }
}
