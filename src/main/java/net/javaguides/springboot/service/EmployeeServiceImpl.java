package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		 
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}
	
	

	/*
	@Override
	public List<Employee> Query(String prefix, int years) {
		List<Employee> employees =
				  employeeRepository.findByNICStartingWithAndYearsGreaterThan(prefix,years);
				  employees.forEach(System.out::println);
		//return employeeRepository.findByNICStartingWithAndYearsGreaterThan(prefix,years);
				return null;
	}*/
/*
	@Override
	public List<Employee> viewEmployeeByName(String firstName) {
		/*Optional<Employee> optional1 = employeeRepository.findByfirstName(firstName);
		Employee employee = null;
		if (optional1.isPresent()) {
			employee = optional1.get();
		} else {
			throw new RuntimeException(" Employee not found for name :: " + firstName);
		}
		return this.employeeRepository.findByfirstName(firstName);
	}*/

	/*@Override
	public List<Employee> listAll(String keyword) {
        if (keyword != null) {
            return employeeRepository.search(keyword);
        }
        return employeeRepository.findAll();
    }*/
	
	
	
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}
}
