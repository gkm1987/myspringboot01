package it.cast;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * 密码进行加密
 */
public class BCryptPasswordEncodeTest {
    @Test
    public void testBCrypt(){
        //对密码加密
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw);

        //校验密码
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$WYlhnTlPTm/2253yILni8Oflyasq4anp5hi45wNM5gcSbPUIIutnW");
        System.out.println(checkpw);
    }
}
