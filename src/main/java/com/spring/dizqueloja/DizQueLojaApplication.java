package com.spring.dizqueloja;

import com.spring.dizqueloja.entities.Category;
import com.spring.dizqueloja.entities.Product;
import com.spring.dizqueloja.repositories.CategoryRepository;
import com.spring.dizqueloja.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DizQueLojaApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(DizQueLojaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(1L,"Eletronics");
		Category cat2 = new Category(2L,"Books");

		Product p1 = new Product(1L,"TV",2200.00, cat1);
		Product p2 = new Product(2L,"Domain Driven Design",120.00, cat2);
		Product p3 = new Product(3L,"PS5",2800.00, cat1);
		Product p4 = new Product(4L,"Docker",100.00, cat2);

		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p3));

		categoryRepository.save(cat1);
		categoryRepository.save(cat2);

		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);

	}
}
