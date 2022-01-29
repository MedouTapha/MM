package main.controllers;

import org.springframework.web.bind.annotation.*;

import main.model.Product;
import main.services.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
	
	
    private final ProductService productService;

    public ProductController(ProductService productService) {
    	
    	this.productService=productService;
		
	}
   

    @GetMapping("/{Id}")
    public Mono<Product> getProductById(@PathVariable Integer
                                                  Id) {
    	return productService.getProductById(Id);
    }
    
    @PostMapping
    public Mono<Product> save(@RequestBody Product product) {
        
        return productService.save(product);
        }

    @GetMapping("/all")
    public Flux<Product> getAllProducts() {
            return productService.getAllProducts();
        }

}


    

