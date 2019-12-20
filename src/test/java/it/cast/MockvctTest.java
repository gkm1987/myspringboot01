package it.cast;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockvctTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        // 构造MockMvc
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testHello() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/test/hello")
                        .param("name", "zhh"))// 参数
                .andExpect(status().isOk())// 判断接收到的状态是否是200（静态导入）
                .andDo(print());// 打印请求和响应的详情
    }


}
