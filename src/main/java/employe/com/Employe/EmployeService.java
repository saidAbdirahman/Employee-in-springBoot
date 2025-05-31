package employe.com.Employe;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeService {
    private final JdbcTemplate jdbc;
    String query = " ";
    public EmployeService(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    //Crud operation
    //get all employee
    public List<Employe> getAllEmploye(){
        query = "select * from employee";
      return jdbc.query(query,new BeanPropertyRowMapper<>(Employe.class));
    };

    public Employe getEmployeById(int id){
        query = "select * fro employee where id = ?";
        return jdbc.queryForObject(
                query,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Employe.class)
        );
    }


}
