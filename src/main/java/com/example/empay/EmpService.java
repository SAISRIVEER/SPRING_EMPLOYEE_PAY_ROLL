package com.example.empay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository repository; 

    public List<EmpData> empinfo() {
        return repository.findAll();  
    }

    public String empid(int id) {
        Optional<EmpData> data = repository.findById(id); 
        if (data.isPresent()) {
            EmpData emp = data.get();
            return emp.getId() + " " + emp.getName() + " " + emp.getSal();
        }
        return "Employee not found!";
    }

    public void addid(EmpData newid) {
        repository.save(newid);  
    }

    public void updatid(int id, EmpData upid) {
        Optional<EmpData> existingEmp = repository.findById(id);  
        if (existingEmp.isPresent()) {
            EmpData emp = existingEmp.get();
            emp.setName(upid.getName());
            emp.setSal(upid.getSal());
            repository.save(emp);  
        }
    }

    public void deleteid(int id) {
        repository.deleteById(id); 
    }
}
