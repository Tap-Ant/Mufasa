import java.util.ArrayList;

/* https://github.com/Iflaah02/StockPortfolio */
public class Mufasa {
	private Person customer;
	private ArrayList<String> pInfo;
	private BankAccount account;
	private ArrayList<String> aInfo;
	
	public Mufasa() throws IllegalArgumentException{
		this.pInfo = new ArrayList<>();
		this.aInfo = new ArrayList<>();
	}
	
	public void setCustomer(Person customer) {
		this.customer = customer;
		this.pInfo = this.checkiInfo(customer);
	}
	
	public ArrayList<String> getCustomer(){
		return this.pInfo;
	}
	
	public void setAccount(BankAccount account) {
		this.account = account;
		this.aInfo = this.checkaInfo(account);
	}
	
	public ArrayList<String> getAccount(){
		return this.aInfo;
	}
	
	public ArrayList<String> checkiInfo(Person customer){
		ArrayList<String> info = new ArrayList<>();
		
		String name = customer.getName();
		if (name.contains("(?!.*[a-zA-Z]).*")) throw new IllegalArgumentException();
		info.add(name);
		
		String username = customer.getUsername();
		if (username.contains("(?!.*[a-zA-Z0-9_]).*") || username.length()>15 || username.matches(".*_.*_.*")) 
			throw new IllegalArgumentException();
		info.add(username);
		
		String password = customer.getPassword();
		if (password.length()<8) throw new IllegalArgumentException();
		String password2 = customer.getPasswordAgain();
		if(!password.matches(password2)) throw new IllegalArgumentException();
		info.add(password);
		
		String country = customer.getCountry();
		if (!country.equals("Estonia") && !country.equals("Latvia") && !country.equals("Lithuania"))
			throw new IllegalArgumentException();
		info.add(country);
		
		String birth = customer.getBd();
		if (!birth.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")) throw new IllegalArgumentException();
		String substr = birth.substring(birth.length() - 4);
		int year = Integer.parseInt(substr);
		if ((2018-year)<18) throw new IllegalArgumentException();
		info.add(birth);
		
		int phone = customer.getPhone();
		String phoneStr = Integer.toString(phone);
		info.add(phoneStr);
		
		String email = customer.getEmail();
		String email2 = customer.getEmailAgain();
		if(!email.matches(email2)) throw new IllegalArgumentException();
		info.add(email);
		
		return info;
	}
	
	public ArrayList<String> checkaInfo(BankAccount account){
		ArrayList<String> info = new ArrayList<>();
		
		/*Street Address (digits and alphabets only), City (only alphabetical characters), 
		 * Postal code (only digits and ‘-‘), Country – alphabetical characters only.*/
		String street = account.getStreet();
		if (street.contains("(?!.*[a-zA-Z0-9]).*")) throw new IllegalArgumentException();
		info.add(street);
		
		String city = account.getCity();
		if (city.contains("(?!.*[a-zA-Z]).*")) throw new IllegalArgumentException();
		info.add(city);
		
		String postcode = account.getPostalCode();
		if (postcode.contains("(?!.*[0-9-]).*")) throw new IllegalArgumentException();
		info.add(postcode);
		
		String country = account.getCountry();
		if (country.contains("(?!.*[a-zA-Z]).*")) throw new IllegalArgumentException();
		info.add(country);
		
		String newPassword = account.getPassword();
		if (newPassword.length()<8) throw new IllegalArgumentException();
		String prevPassword = pInfo.get(2);
		if (newPassword == prevPassword) throw new IllegalArgumentException();
		info.add(newPassword);
		
		String card = account.getCardDetails();
		info.add(card);
		
		return info;
	}
	
	public String testTransaction(BankAccount account) {
		if (account.handleCVC()) {
			String cardDetails = aInfo.get(5);
			String ded = account.deduction(cardDetails);
			if (ded=="Pass") {
				String refStatus = account.refund(cardDetails);
				return ded + ", " + refStatus;
			}else return ded;
		}
		else return"Invalid CVC";
	}
	
}