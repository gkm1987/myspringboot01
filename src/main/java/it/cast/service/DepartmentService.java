package it.cast.service;

import it.cast.bean.Department;
import it.cast.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "cdept")
    public Department getDep(Integer id){
        System.out.println("查询:"+id+"部门");
        Department dept = departmentMapper.getDeptById(id);
        return  dept;
    }
}
