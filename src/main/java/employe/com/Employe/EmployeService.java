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

    //get employee by id
    public Employe getEmployeById(int id){
        query = "select * fro employee where id = ?";
        return jdbc.queryForObject(
                query,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Employe.class)
        );
    }
    //add employee
    public void addEmpliyee(Employe employe){
        query = "insert into employee values (?,?,?)";
        jdbc.update(query, employe.getId(), employe.getName(), employe.getAddress());
    }

    //Update employe
    public void UpdateEmployeeById(Employe UpdateEmp , int id){
        query = "update employee set id=?, name =?, address=? where id = ?";
        jdbc.update(query,UpdateEmp.getId(),UpdateEmp.getName(),UpdateEmp.getAddress(),id);
    }

    //Delete Employee
    public void DeleteEmployeeById(int id){
        query = "delete from employee where id =?";
        jdbc.update(query,id);
    }

}
