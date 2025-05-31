package employe.com.Employe;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeService employeService;
    public EmployeeController(EmployeService employeService){
        this.employeService = employeService;
    }
    //All employee
    @GetMapping("/all")
    public List<Employe> getAllEmployee(){
        return employeService.getAllEmploye();
    }
    //employee by id
    @GetMapping("/{id}")
    public Employe getEmployeById(@PathVariable int id){
        return employeService.getEmployeById(id);
    }
    //Insert employee
    @PostMapping
    public void addEmployee(@RequestBody Employe emp){
         employeService.addEmpliyee(emp);
    }
}
