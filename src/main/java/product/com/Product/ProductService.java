package product.com.Product;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final JdbcTemplate jdbc;
    String query = " ";
    public ProductService(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    //Crud operation
    //get all product
    public List<Product> getAllProduct(){
        query = "select * from product";
      return jdbc.query(query,new BeanPropertyRowMapper<>(Product.class));
    };

    //get employee by id
    public Product getProductById(int id){
        query = "select * fro product where id = ?";
        return jdbc.queryForObject(
                query,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Product.class)
        );
    }
    //add product
    public void addProduct(Product product){
        query = "insert into product values (?,?,?)";
        jdbc.update(query, product.getId(), product.getName(), product.getPQuantity());
    }

    //Update product
    public void UpdateProductById(Product UpdateProduct , int id){
        query = "update product set id=?, name =?, pQuantity=? where id = ?";
        jdbc.update(query,UpdateProduct.getId(),UpdateProduct.getName(),UpdateProduct.getPQuantity(),id);
    }

    //Delete product
    public void DeleteProductById(int id){
        query = "delete from product where id =?";
        jdbc.update(query,id);
    }

}
