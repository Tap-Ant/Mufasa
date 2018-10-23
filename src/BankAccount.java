/*Stub*/
public class BankAccount {
	public String getStreet() {
		return "221B Baker Street";
	}
	
	public String getCity() {
		return "New York";
	}
	
	public String getPostalCode() {
		return "105-005";
	}
	 public String getCountry() {
		 return "Finland";
	 }
	 
	 public String getPassword() {
		 return "secretword";
	 }
	 
	 public String getCardDetails() {
		 return "(Tapio Anttila; Mastercard; 20012077; 10/20)";
	 }
	 
	 public Boolean handleCVC() {
		 /*This would get and process user input of the cvc code*/
		 return true;
	 }
	 
	 public String deduction(String cardDetails) {
		 return "Pass";
	 }
	 
	 public String refund(String cardDetails) {
		 // *User clicks 'Refund'*
		 return "Refund Success";
	 }
}
