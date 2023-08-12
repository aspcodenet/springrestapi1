package se.systementor.springrestapi.services;

import org.springframework.stereotype.Service;
import se.systementor.springrestapi.model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private static List<Product> products;

    public ProductService(){
        if(products == null) {
            products = initProducts();
        }
    }

    private List<Product> initProducts() {
        var list = new ArrayList<Product>();
        list.add(addProduct("746e4287-4982-4a96-a3ee-841a6dd84a9e","Fjällräven - Foldsack No. 1 Backpack, Fits 15 Laptops","Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday", 109.95,14, LocalDateTime.of(2022,6,13,0,0)));
        list.add(addProduct("b7d3e91-f031-4e18-8f44-edd995778350","WD 2TB Elements Portable External Hard Drive - USB 3.0","USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance High Capacity; Compatibility Formatted NTFS for Windows 10, Windows 8.1, Windows 7", 640,223, LocalDateTime.of(2023,1,1,0,0)));
        list.add(addProduct("eee82b6e-71f7-447b-b7be-fddb9c42e9c3","SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s","Easy upgrade for faster boot up, shutdown, application load and response (As compared to 5400 RPM SATA 2.5” hard drive; Based on published specifications and internal benchmarking tests using PCMark vantage scores) Boosts burst write performance, making it ideal for typical PC workloads The perfect balance of performance and reliability Read/write speeds of up to 535MB/s/450MB/s", 1090,470, LocalDateTime.of(2023,2,2,0,0)));
        list.add(addProduct("7d399c3e-09fe-4a69-a115-b4b5e3227010", "Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thi","21. 5 inches Full HD (1920 x 1080) widescreen IPS display And Radeon free Sync technology", 5990,122, LocalDateTime.of(2023,5,5,0,0)));
        list.add(addProduct("2a394e8c-f51c-4157-aba2-aed17370aab8","Rain Jacket Women Windbreaker Striped Climbing Raincoats","Long sleeve with hooded, adjustable drawstring waist design. Button and zipper front closure raincoat, fully stripes Lined and The Raincoat has 2 side pockets are a good size to hold all kinds of things", 399,679, LocalDateTime.of(2023,6,6,0,0)));
        return list;
    }

    private Product addProduct(String uuidString, String title, String description, double price, int stockLevel, LocalDateTime created) {
        var product = new Product();
        product.setId(UUID.fromString(uuidString));
        product.setCreated(created);
        product.setDescription(description);
        product.setPrice((float) price);
        product.setName(title);
        return product;
    }

    public List<Product> GetAll(){
        return products;
    }

    public Optional<Product> getById(UUID id) {
        return products.stream().filter(c->c.getId().equals(id)).findFirst();
    }

    public boolean update(Product productWithNewValues) {
        var product = getById(productWithNewValues.getId());
        if(!product.isPresent()) return false;
        product.get().setName(productWithNewValues.getName());
        product.get().setDescription(productWithNewValues.getDescription());
        product.get().setPrice(productWithNewValues.getPrice());
        product.get().setCreated(productWithNewValues.getCreated());
        product.get().setDescription(productWithNewValues.getDescription());
        product.get().setStockLevel(productWithNewValues.getStockLevel());
        return true;
    }

    public boolean deleteById(UUID id) {
        var product = getById(id);
        if(!product.isPresent()) return false;
        products.remove(product);
        return true;
    }

    public Product add(Product product) {
        product.setId(UUID.randomUUID());
        products.add(product);
        return product;
    }
}
