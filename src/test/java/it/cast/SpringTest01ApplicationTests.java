package it.cast;

import ch.qos.logback.core.net.SyslogOutputStream;
import it.cast.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * springboot 单元测试
 * 可以
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringTest01ApplicationTests {

    @Autowired
    DataSource dataSource;


    @Autowired
    Person person;

    @Test
    void testates() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
