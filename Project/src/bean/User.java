package bean;

public class User {
	private String userName;
	private String passWord;
	private Coupon favorite;
	private int verification;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Coupon getFavorite() {
		return favorite;
	}

	public void setFavorite(Coupon favorite) {
		this.favorite = favorite;
	}

	public int getVerification() {
		return verification;
	}

	public void setVerification(int verification) {
		this.verification = verification;
	}

}
