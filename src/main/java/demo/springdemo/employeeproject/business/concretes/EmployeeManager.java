package demo.springdemo.employeeproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springdemo.employeeproject.business.abstracts.EmployeeService;
import demo.springdemo.employeeproject.core.results.DataResult;
import demo.springdemo.employeeproject.core.results.Result;
import demo.springdemo.employeeproject.core.results.SuccessDataResult;
import demo.springdemo.employeeproject.core.results.SuccessResult;
import demo.springdemo.employeeproject.dataAccess.abstracts.EmployeeDao;
import demo.springdemo.employeeproject.entities.concretes.Employee;
import net.bytebuddy.asm.Advice.This;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Data Listelendi");
		
	}

	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult(true, "Calisan Eklendi");
	}
	
	
	
	
	

}