package se.systementor.springrestapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.systementor.springrestapi.model.Product;
import se.systementor.springrestapi.services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductApiController {
    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> GetAll(){
        return new ResponseEntity<>(productService.GetAll(), HttpStatus.OK);
    }
    @GetMapping("/api/products/{id}")
    public ResponseEntity<Product> Get(@PathVariable UUID id){
        Optional<Product> product = productService.getById(id);
        if(product.isPresent()) return ResponseEntity.ok(product.get());
        return  ResponseEntity.notFound().build();
    }

    @PutMapping("/api/products/{id}")
    public ResponseEntity<Product> Update(@PathVariable UUID id, @RequestBody Product product){
        boolean status = productService.update(product);
        if(status == true)
            return ResponseEntity.ok(product);
        else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> New(@RequestBody Product product){
        var newCreated = productService.add(product);
        return ResponseEntity.ok(newCreated); // mer REST ful = created (204) samt url till produkten
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<String> Delete(@PathVariable UUID id){
        boolean status = productService.deleteById(id);
        if(status == true)
            return ResponseEntity.ok("Deleted");
        else
            return ResponseEntity.badRequest().build();
    }



}
