package org.maxwell.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.maxwell.mp.mapper.UserMapper;
import org.maxwell.mp.entity.User;
import org.maxwell.mp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootMpItcastApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void testMp() {
        User user = userService.getById(1);
        System.out.println(user);
    }

    @Test
    void insert() {

        User user = User.builder().userName("张三2").password("8848taihejin").name("张三3").age(29).
                email("dhaugd@diw1.com").build();
        userMapper.insert(user);
        System.out.println(user.getId());
    }


    @Test
    void delete() {

        boolean b = userService.removeById(19);
        System.out.println(b);

    }

    @Test
    void testDelUesrByIds() {

        List<Long> ids = Arrays.asList(14L, 15L);
        int result = userMapper.deleteBatchIds(ids);
        System.out.println("result:" + result);

    }

    @Test
    void testDelUserByCondition() {

        Map<String, Object> map = new HashMap<String, Object>(){
            {
                put("user_name","王八衰");
                put("age",22);
            }
        };

        boolean b = userService.removeByMap(map);
        System.out.println("b = " + b);
    }


    @Test
    void select() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "伤");
        queryWrapper.eq("password", "123456");
        queryWrapper.in("age", 19, 25, 22);
        queryWrapper.orderByDesc("age");

        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testSelectAll(){
        List<User> users = userMapper.selectList(null);
        System.out.println("users = " + users);
    }

    @Test
    void selectLambda() {
        //jdk8
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(User::getUserName, "伤");
        queryWrapper.eq(User::getPassword, "123456");
        queryWrapper.in(User::getAge, 19, 25, 22);
        queryWrapper.orderByDesc(User::getAge);

        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void selectPage() {
        //构建分页对象
        Page<User> page = new Page<>(2, 3);
        Page<User> result = userMapper.selectPage(page, null);
        List<User> records = result.getRecords();
        long total = result.getTotal();
        System.out.println("records = " + records);
        System.out.println("total = " + total);

    }

    @Test
    void selectPageByCondition() {
        Page<User> page = new Page<>(2, 3);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //分页条件
        queryWrapper.like(User::getUserName, "伤");
        queryWrapper.orderByDesc(User::getAge);
        Page<User> result = userMapper.selectPage(page, queryWrapper);
        List<User> records = result.getRecords();
        System.out.println("records = " + records);

    }

    @Test
    void testConditionsOrQuery() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, "赵七伤").or().eq(User::getAge, 25);
        List<User> users = userService.list(queryWrapper);
        System.out.println("users = " + users);
    }


    @Test
    void testAgeQuery() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(User::getAge, 20);
        queryWrapper.select(User::getUserName,User::getAge);
        List<User> users = userService.list(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testGroupBy(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.apply("select count(age),user_name");
        queryWrapper.groupBy(User::getAge);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);

    }



}
