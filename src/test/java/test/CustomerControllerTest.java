package test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import project.domain.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {
	@LocalServerPort
	private int port;
	private URL base;
	
	@Before
	public void setUp() throws MalformedURLException{
		this.base = new URL("http://localhost:"+ port +"/");
	}
	@Test
	public void getCustomer() throws Exception{
		/*ResponseEntity<Customer> responseEntity = template.getForEntity(base.toString()+"/customers", Customer.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);*/
	}
	
}
