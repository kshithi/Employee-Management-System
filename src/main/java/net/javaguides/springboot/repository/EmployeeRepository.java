package net.javaguides.springboot.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	//List<Employee> findByNICStartingWithAndYearsGreaterThan(String prefix, int yrs) ;
		// TODO Auto-generated method stub
	/*

	
	
	/*List<Employee> findByDepartmentId(String deptid);
	
	List<Employee> findByfirstName(String name);*/
	
	//Employee findById(long id);

	//void deleteById(String id);
}
