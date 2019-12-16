package it.cast;

import com.alibaba.fastjson.JSONObject;
import it.cast.bean.Employee;
import it.cast.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyredisTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作字符串的

    @Autowired
    RedisTemplate redisTemplate; //k-v  都是对象的

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    /**
     * 常见的五大数据类型
     * string list set hash zset(有序集合)
     * stringRedisTemplate.opsForValue()
     * stringRedisTemplate.opsForHash()
     *  stringRedisTemplate.opsForList()
     *  stringRedisTemplate.opsForSet()
     */
    @Test
    public void test01(){
        //给redis 中保存数据
//        stringRedisTemplate.opsForValue().append("mes", "hello");
        String mes = stringRedisTemplate.opsForValue().get("mes");
        System.out.println(mes);

        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");

    }

    //测试保存对象
    @Test
    public void test02(){
//        默认如果保存对象,使用jdk 序列化机制,序列化后的数据保存到redis 中
        Employee emp = employeeMapper.getEmpById(1);
//        redisTemplate.opsForValue().set("emp-01",emp);

        //1 将数据以json 的方式保存
        //1) 自己将数据转为json
        //2) empRedisTemplate 自己写
//        empRedisTemplate.opsForValue().set("emp-01",emp);
        redisTemplate.opsForValue().set("emp-01",emp);

        String s = JSONObject.toJSONString(emp);
        stringRedisTemplate.opsForValue().set("emp-js02",s);
    }

}
