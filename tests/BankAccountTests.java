import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;

public class BankAccountTests {
	Mufasa mufasa;
	Person customer;
	BankAccount account;
	
	@Before
	public void setup(){
		mufasa = new Mufasa();
		customer = EasyMock.createMock(Person.class);
		account = new BankAccount();
	}
	
	@Test
	public void testBankAccount() {
		EasyMock.expect(customer.getName()).andReturn("Tapio Anttila");
		EasyMock.expect(customer.getUsername()).andReturn("tap_ant");
		EasyMock.expect(customer.getPassword()).andReturn("salasana");
		EasyMock.expect(customer.getPasswordAgain()).andReturn("salasana");
		EasyMock.expect(customer.getCountry()).andReturn("Latvia");
		EasyMock.expect(customer.getBd()).andReturn("06/05/1995");
		EasyMock.expect(customer.getPhone()).andReturn(1234567890);
		EasyMock.expect(customer.getEmail()).andReturn("email@website");
		EasyMock.expect(customer.getEmailAgain()).andReturn("email@website");
		EasyMock.replay(customer);
		mufasa.setCustomer(customer);
		
		mufasa.setAccount(account);
		
		String listStr = mufasa.getAccount().toString();
		assertEquals(listStr, "[221B Baker Street, New York, 105-005, Finland, secretword, "
								+ "(Tapio Anttila; Mastercard; 20012077; 10/20)]");
	}
	
	public void testTransactionTest() {
		EasyMock.expect(customer.getName()).andReturn("Tapio Anttila");
		EasyMock.expect(customer.getUsername()).andReturn("tap_ant");
		EasyMock.expect(customer.getPassword()).andReturn("salasana");
		EasyMock.expect(customer.getPasswordAgain()).andReturn("salasana");
		EasyMock.expect(customer.getCountry()).andReturn("Latvia");
		EasyMock.expect(customer.getBd()).andReturn("06/05/1995");
		EasyMock.expect(customer.getPhone()).andReturn(1234567890);
		EasyMock.expect(customer.getEmail()).andReturn("email@website");
		EasyMock.expect(customer.getEmailAgain()).andReturn("email@website");
		EasyMock.replay(customer);
		mufasa.setCustomer(customer);
		mufasa.setAccount(account);
		
		String result = mufasa.testTransaction(account);
		assertEquals(result, "Pass, Refund Success");
	}
}
