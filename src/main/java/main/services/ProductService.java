package main.services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.model.Product;
import main.repo.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional(readOnly = true)
public class ProductService {
    
	private ProductRepository productRepository;
    
    
    
    public ProductService(ProductRepository productRepository) {
    	this.productRepository = productRepository;
		
    	
	} 
    
    
    @Transactional(rollbackFor = Exception.class)
    public Mono<Product> save(Product product) {
        return Mono.fromCallable(() -> productRepository.save(product));
    }
    
    public Flux<Product> getAllProducts() {
        return Flux.fromIterable(productRepository.findAll());
    }
    public Mono<Product> getProductById(Integer Id) {
        return Mono.fromCallable(() -> productRepository.findByid(Id));
    }
}