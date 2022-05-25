package org.maxwell.cache.service.impl;

import org.maxwell.cache.common.CommonResult;
import org.maxwell.cache.mapper.RoleMapper;
import org.maxwell.cache.model.Role;
import org.maxwell.cache.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author itheima
 * code
 * .@CacheConfig抽取缓存的公共配置，在这里配置了cacheNames就不需要再每个方法上面指定value属性了
 */
@Service
@CacheConfig(cacheNames = "role")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * .@Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存，
     * 如果没有就运行方法并将结果放入缓存；以后再来调用就可以直接使用缓存中的数据；
     *
     * .@Cacheable 将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存中获取，不用调用方法;
     * <p>
     * CacheManager管理多个Cache组件的，对缓存的真正CRUD操作在Cache组件中，每一-个缓存组件有自己唯- --一个名字;
     * <p>
     * <p>
     * 原理：
     * 1、自动配置类 CacheAutoConfiguration
     * 2、缓存的配置类
     * org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.GuavaCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration【默认】
     * org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
     * <p>
     * 3、哪个配置类默认生效：SimpleCacheConfiguration；
     * <p>
     * 4、给容器中注册了一个CacheManager：ConcurrentMapCacheManager
     * 5、可以获取和创建ConcurrentMapCache类型的缓存组件；他的作用将数据保存在ConcurrentMap中；
     * <p>
     * 运行流程：
     * <p>
     * .@Cacheable：
     * 1、方法运行之前，先去查询Cache（缓存组件），按照cacheNames指定的名字获取；
     *  （CacheManager先获取相应的缓存），第一次获取缓存如果没有Cache组件会自动创建。
     * 2、去Cache中查找缓存的内容，使用一个key，默认就是方法的参数；
     *      key是按照某种策略生成的；默认是使用keyGenerator生成的，默认使用SimpleKeyGenerator生成key；
     *      SimpleKeyGenerator生成key的默认策略；
     *          如果没有参数；key=new SimpleKey()；
     *          如果有一个参数：key=参数的值
     *          如果有多个参数：key=new SimpleKey(params)；
     * 3、没有查到缓存就调用目标方法；
     * 4、将目标方法返回的结果，放进缓存中
     * <p>
     * <p>
     * 核心：
     * 1）、使用CacheManager【ConcurrentMapCacheManager】按照名字得到Cache【ConcurrentMapCache】组件
     * 2）、key使用keyGenerator生成的，默认是SimpleKeyGenerator
     * <p>
     * 几个属性：
     * a)cacheNames/value：指定缓存组件的名字
     *      cacheNames = {"role"}可以使用多个参数,是数组的形式，可以指定多个缓存
     * b)key：缓存数据使用的key，可以用他来指定。默认是使用方法参数的值
     *      编写SpEl:   #id  #a0,#po,#argrs[0]  "0"代表参数的索引
     *      #result  方法执行后的返回值
     *      #root.methodName   方法名
     *      key = "#root.methodName+'['+#id+']'"
     * c)keyGenerator: key的生成器、可以自己指定key的生成器的组件Id
     *      key/keyGenerator 二选一
     *      keyGenerator = "myKeyGenerator"
     * d)cacheManager：指定缓存管理器或者cacheResolver:获取解析器
     *      cacheManager/cacheResolver 二选一
     * e)condition：指定符合缓存的条件
     *      condition = "#id>0 and #root.methodName eq 'aaa'" 可以多条件判断
     * f)unless: 否定缓存，当unless的条件为true，方法结果不会被缓存,可以获取结果进行判断
     *      unless = "#result==null"，结果为null，就不缓存
     * g)sync:是否使用异步模式
     *      默认false   同步
     *      为true时，unless不支持
     */

    @Override
    @Cacheable(key = "#id",condition = "#id>0",unless = "#result==null")
    public Role findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    //@Cacheable(keyGenerator = "myKeyGenerator",key = "findAllRole")
    @Cacheable(key = "#root.method.getName()")
    @Override
    public CommonResult findAllRole() {
        List<Role> roleList = roleMapper.findAll();
        return CommonResult.success(roleList);
    }

    /**
     * .@CacheEvict 缓存清除
     *  key：指定要清除的数据
     *  allEntries：指定清除这个缓存库的所有数据，默认为false
     *  beforeInvocation：在执行方法之前清除，默认为false，在方法之后执行
     */
    @Override
    @CacheEvict(key = "#id")
    public Integer delete(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    /**
     * .@CachePut既调用方法、又更新数据，达到同步更新缓存
     * <p>
     * 运行时机：
     * 1、先调用目标方法
     * 2、将目标方法的结果缓存起来
     *
     * 条件：存取Id的key要保持一致
     *     key = "#role.id"     传入员工的Id
     *     key = "#result.id"   使用返回员工的Id
     * 注意： @Cacheable不能使用#result
     *      因为 @Cacheable在目标方法执行之前需要得到这个key，所以不能用#result
     */
    @Override
    @CachePut(key = "#result.id")
    public Role update(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
        return role;
    }

    /**
     * .@Caching 定义复杂缓存规则
     */
    @Override
    @Caching(
            cacheable = {
                    @Cacheable(key = "#role.roleName")
            },
            put = {
                    @CachePut(key = "#role.id"),
                    @CachePut(key = "#role.roleCode")
            }
    )
    public CommonResult add(Role role) {
        role.setId(null);
        try {
            roleMapper.insert(role);
        } catch (Exception e) {
            return CommonResult.failed();
        }
        return CommonResult.success(role.getId());
    }
}
