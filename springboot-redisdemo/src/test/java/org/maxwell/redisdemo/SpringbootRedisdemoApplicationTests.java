package org.maxwell.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class SpringbootRedisdemoApplicationTests {

    /**
     * 模板模板
     */
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @Test
    void TestRedisString() {

        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
//        operations.set("name", "zhangsan");
//        String name = (String) operations.get("name");
//        System.out.println(name);
//        //设置过期时间
//        operations.set("person", "lisi", 20, TimeUnit.SECONDS);
//        redisTemplate.delete("name");
        Boolean bool = operations.setIfAbsent("name", "wangwu"); //如果存在返回false
        System.out.println(bool);
    }


    @Test
    void TestRedisList() {
        ListOperations<Object, Object> operations = redisTemplate.opsForList();
        //lpush
//        Long nums = operations.leftPushAll("list", Arrays.asList("11", "22", "33", "44", "55", "33", "66"));
//        System.out.println("nums = " + nums);
        //查询
        List<Object> list = operations.range("list", 0, -1);
        System.out.println("list = " + list);

        //弹出
        Object pop = operations.rightPop("list",2l);
        System.out.println("pop = " + pop);

        //移除指定value从l->r
        Long nums1 = operations.remove("list", 1L, "33");
        System.out.println("nums1 = " + nums1);


    }


    @Test
    void TestRedisHash() {

        HashOperations<Object, Object, Object> operations = redisTemplate.opsForHash();
        Map map = new HashMap();
        map.put("name", "zhouyu");
        map.put("age", 23234);
        map.put("high", "189");
        operations.putAll("map", map);

        //all keys
        Set<Object> keys = operations.keys("map");
        System.out.println("keys = " + keys);
        //all values
        List<Object> values = operations.values("map");
        System.out.println("values = " + values);
        //get hash
        Map<Object, Object> map1 = operations.entries("map");
        System.out.println("map1 = " + map1);
        // delete
        Long num = operations.delete("map", "age");
        System.out.println("num = " + num);
    }

    /**
     * 测试set集合
     */
    @Test
    void TestRedisSet() {
        SetOperations<Object, Object> operations = redisTemplate.opsForSet();

        //add
        Long mySet = operations.add("mySet", "11", "22", "33", "44", "33", "33");
        System.out.println("mySet = " + mySet);
        //获取成员
        Set<Object> set = operations.members("mySet");
        System.out.println(set);
        //删除
        Long num = operations.remove("mySet", "11");
        System.out.println("num = " + num);
        //总数
        Long mySet1 = operations.size("mySet");
        System.out.println("mySet1 = " + mySet1);

    }

    @Test
    void TestRedisZSet() {
        ZSetOperations<Object, Object> operations = redisTemplate.opsForZSet();

        operations.add("zset", "zhangsan", 30d);
        operations.add("zset", "zhangsan1", 40d);
        operations.add("zset", "zhangsan2", 20d);
        operations.add("zset", "zhangsan3", 55d);

        //select all
        Set<Object> zset = operations.range("zset", 0L, -1L);
        System.out.println(zset);

        //查找分数区间
        Set<Object> set = operations.rangeByScore("zset", 40d, 70d);
        System.out.println("set = " + set);

        //查找分数区间返回score
        Set<ZSetOperations.TypedTuple<Object>> zset1 = operations.rangeByScoreWithScores("zset", 20d, 40d);
        System.out.println("zset1 = " + zset1);

    }

}
