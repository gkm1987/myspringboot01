package it.cast.mapper;

import com.github.pagehelper.Page;
import it.cast.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper 或者 @MapperScan 将接口装配到容器中
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
    public List<Employee> getEmpList();
    public  void insertEmp(Employee employee);

//    @Select("select * from employee")
    public Page<Employee> getAllEmployee();
}
