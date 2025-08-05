package com.bitsnbytes.product;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@OpenAPIDefinition(
		info = @Info(
				title = "Product Service REST API Documentation",
				description = "Product Service REST API",
				version = "v1",
				contact = @Contact(
						name = "devendra kumar",
						email = "2022csdevendra12695@poornima.edu.in"
				)
		)
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ProductApplication.class, args);

	}

}
