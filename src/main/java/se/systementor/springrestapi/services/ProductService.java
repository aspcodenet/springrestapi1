package se.systementor.springrestapi.services;

import se.systementor.springrestapi.model.Product;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductService {
    private static List<Product> products;

    public ProductService(){
        if(products == null) {
            products = initProducts();
        }
    }

    private List<Product> initProducts() {
        var list = new ArrayList<Product>();
        list.add(addProduct("Fjällräven - Foldsack No. 1 Backpack, Fits 15 Laptops","Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday", 109.95,14, LocalDateTime.of(2022,6,13,0,0)));
        list.add(addProduct("WD 2TB Elements Portable External Hard Drive - USB 3.0","USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance High Capacity; Compatibility Formatted NTFS for Windows 10, Windows 8.1, Windows 7", 640,223, LocalDateTime.of(2023,1,1,0,0)));
        list.add(addProduct("SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s","Easy upgrade for faster boot up, shutdown, application load and response (As compared to 5400 RPM SATA 2.5” hard drive; Based on published specifications and internal benchmarking tests using PCMark vantage scores) Boosts burst write performance, making it ideal for typical PC workloads The perfect balance of performance and reliability Read/write speeds of up to 535MB/s/450MB/s", 1090,470, LocalDateTime.of(2023,2,2,0,0)));
        list.add(addProduct("Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thi","21. 5 inches Full HD (1920 x 1080) widescreen IPS display And Radeon free Sync technology", 5990,122, LocalDateTime.of(2023,5,5,0,0)));
        list.add(addProduct("Rain Jacket Women Windbreaker Striped Climbing Raincoats","Long sleeve with hooded, adjustable drawstring waist design. Button and zipper front closure raincoat, fully stripes Lined and The Raincoat has 2 side pockets are a good size to hold all kinds of things", 399,679, LocalDateTime.of(2023,6,6,0,0)));
        return list;
    }

    private Product addProduct(String title, String description, double price, int stockLevel, LocalDateTime created) {
        var product = new Product();
        product.setId(UUID.randomUUID());
        product.setCreated(created);
        product.setDescription(description);
        product.setPrice((float) price);
        product.setName(title);
        return product;
    }

    public List<Product> GetAll(){
        return products;
    }

}
