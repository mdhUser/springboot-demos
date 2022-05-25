package org.maxwell.shardingjdbc;

import org.junit.jupiter.api.Test;
import org.maxwell.shardingjdbc.entity.TDict;
import org.maxwell.shardingjdbc.entity.TOrder;
import org.maxwell.shardingjdbc.entity.TUser;
import org.maxwell.shardingjdbc.entity.TbLog;
import org.maxwell.shardingjdbc.mapper.TDictMapper;
import org.maxwell.shardingjdbc.mapper.TOrderMapper;
import org.maxwell.shardingjdbc.mapper.TUserMapper;
import org.maxwell.shardingjdbc.mapper.TbLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class SharingjdbcDemoApplicationTests {

    @Autowired
    private TOrderMapper orderMapper;

    @Autowired
    private TDictMapper dictMapper;

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TbLogMapper logMapper;


    @Test
    void test1() {

        int orderId = 0, userId = 0;
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            userId = random.nextInt(60) + 1;
            orderId = random.nextInt(500) + 500;
            TOrder order = TOrder.builder().orderId((long) orderId).userId((long) userId).price(new BigDecimal(random.nextInt(10000))).status("1").build();
            orderMapper.insert(order);
        }

    }

    @Test
    public void commonTable() {
        TDict build = TDict.builder().dictId(5l).code("6666").type("11").value("888").build();
        dictMapper.insert(build);
    }

    @Test
    public void testVertical() {
        TUser user = TUser.builder().userId(43l).userType("1").fullname("Maxwell").build();
        userMapper.insert(user);
    }


    /**
     * 测试默认数据源
     * 对于没有做分片处理的操作，则会直接访问默认数据源处理
     */
    @Test
    public void test5() {
        TbLog log = TbLog.builder().id(1l).info("这是一个测试").build();
        logMapper.insert(log);
    }


    /**
     * @Description 测试标准查询
     */
    @Test
    public void testFind() {
        List<TOrder> tOrder = orderMapper.findByUserId(18l);
        tOrder.forEach(System.out::println);
    }


}
