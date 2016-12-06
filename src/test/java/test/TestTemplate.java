package test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestTemplate {
	@LocalServerPort
	private int port;
	private URL base;
	
	@Autowired
	private RestTemplate template;

	@Before
	public void setUp() throws MalformedURLException{
		this.base = new URL("http://localhost:"+ port +"/");
	}
	@Test
	public void getHello() throws Exception{
		ResponseEntity<String> responseEntity = template.getForEntity(base.toString(), String.class);
		assertThat(responseEntity.getBody(), equalTo("Hello world"));
	}
}
