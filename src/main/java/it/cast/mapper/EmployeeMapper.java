package it.cast.mapper;

import it.cast.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper 或者 @MapperScan 将接口装配到容器中
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
    public List<Employee> getEmpList();
    public  void insertEmp(Employee employee);

}
