package product.com.Product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    //All product
    @GetMapping("/all")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    //product by id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }
    //Insert product
    @PostMapping("/save")
    public void addProduct(@RequestBody Product product){
         productService.addProduct(product);
    }
    //Update product
    @PatchMapping("/{id}")
    public void UpdateProductById(@PathVariable int id, @RequestBody Product product){
        productService.UpdateProductById(product,id);
    }
    @DeleteMapping("/{id}")
    //Delete Product
    public void  deleteProductById(@PathVariable int id){
        productService.DeleteProductById(id);
    }
}
