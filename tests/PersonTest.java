import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;

public class PersonTest {
	Mufasa mufasa;
	Person customer;
	
	@Before
	public void setup(){
		mufasa = new Mufasa();
		customer = EasyMock.createMock(Person.class);
		
	}
	
	@Test
	public void testPerson() throws IllegalArgumentException{
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
		
		String listStr = mufasa.getCustomer().toString();
		assertEquals(listStr, "[Tapio Anttila, tap_ant, salasana, Latvia, 06/05/1995, 1234567890, email@website]");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPersonThrows() throws IllegalArgumentException{
		EasyMock.expect(customer.getName()).andReturn("Tapio Anttila");
														// "tap_ant_" or "tap_ant123456789"
		EasyMock.expect(customer.getUsername()).andReturn("tap_ant_");
		EasyMock.expect(customer.getPassword()).andReturn("salasana");
															  // something different
		EasyMock.expect(customer.getPasswordAgain()).andReturn("salasana");
		EasyMock.expect(customer.getCountry()).andReturn("Latvia");
													// "ok/05/1995" or "06/05/2006" or "06-05-1995"
		EasyMock.expect(customer.getBd()).andReturn("06/05/1995");
		EasyMock.expect(customer.getPhone()).andReturn(1234567890);
		EasyMock.expect(customer.getEmail()).andReturn("email@website");
		EasyMock.expect(customer.getEmailAgain()).andReturn("email@website");
		EasyMock.replay(customer);
		
		mufasa.setCustomer(customer);
	}
	
}
