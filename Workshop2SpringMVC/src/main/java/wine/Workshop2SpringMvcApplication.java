package wine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
public class Workshop2SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Workshop2SpringMvcApplication.class, args);
	}
}