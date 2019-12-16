package it.cast.service;

import it.cast.bean.Employee;
import it.cast.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存 以后再要相同的数据 直接返回
     *
     *  CacheManager 管理多个Cache组件 对缓存的CRUD 操作在Cache中,每一个缓存组件有自己唯一的名字
     *  几个属性:
     *      cacheNames/value : 指定缓存组件的名字 数组的形式可以指定多个
     *      key:缓存数据使用的key 默认使用方法参数的值 1-方法返回值
     *          编写spEL 表达式
     *              如:#id ;参数id #a0 #p0 #root.args[0]
     *      keyGenerator: key的生成 可以自己指定key 的生成器组件的id
     *          key/keyGenerator 二选一
     *      cacheManager cacheResolver 指定解析器 得到cache 二选一
     *      condition: 指定符合条件的情况下才缓存
     *      unless: 否定缓存 为true 不缓存
     *      sync :是否使用异步
     *
     *      condition = "#id>0",unless ="#result==null"
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "cemp")
    public Employee getEmp(Integer id){
        System.out.println("查询" + id + "号");
        Employee emp = employeeMapper.getEmpById(id);
        return  emp;
    }

    /**
     * 修改数据库的某个数据 同时更新缓存 运行之后可以得到key
     * 1. 先调用目标方法
     * 2. #employee.id 和 #result.id(使用返回后的id) 相同
     * @param employee
     * @return
     */
    @CachePut(value = "cemp",key = "#employee.id")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp:"+employee);
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    /**
     * 删除@CacheEvict
     * ,allEntries = true 清楚所有
     * ,beforeInvocation = false  默认 在方法之后出现异常不会清除掉
     */

    @CacheEvict(value = "cemp", key = "#id")
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp:"+id);
//        employeeMapper.deleteEmpById(id);
    }
}
