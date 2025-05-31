package employe.com.Employe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeService employeService;
    public EmployeeController(EmployeService employeService){
        this.employeService = employeService;
    }

    @GetMapping("/all")
    public List<Employe> getAllEmployee(){
        return employeService.getAllEmploye();
    }

    @GetMapping("/{id}")
    public Employe getEmployeById(@PathVariable int id){
        return employeService.getEmployeById(id);
    }
}
