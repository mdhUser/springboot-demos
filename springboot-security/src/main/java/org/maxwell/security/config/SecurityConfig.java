package org.maxwell.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/22 16:42
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 构建认证服务，并将对象注入spring IOC容器，用户登录时，会调用该服务进行用户合法信息认证
     *
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails u1 = User.withUsername("Maxwell")
                .password("{noop}123456") //表示对密码不做任何操作（实际开发不用）
                .authorities("P5", "ROLE_ADMIN")//用户的权限信息
                .build();

        UserDetails u2 = User
                .withUsername("itheima")
                .password("{noop}123456")
                .authorities("P7", "ROLE_SELLER", "ROLE_ADMIN")//如果角色也作为一种权限资源，则角色名称的前缀必须加ROLE_
                .build();
        inMemoryUserDetailsManager.createUser(u1);
        inMemoryUserDetailsManager.createUser(u2);
        return inMemoryUserDetailsManager;
    }

    /**
     * 定义对web访问的资源做授权处理
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()//定义认证时使用form表单的方式提交数据
                .and()
                .logout()//登出用默认的路径登出 /logout
                .permitAll()//允许所有的用户访问登录或者登出的路径
                .and()
                .csrf().disable()
                .authorizeRequests();//对任何请求都过滤处理
//                .antMatchers("/register").permitAll()//任何用户可以访问
//                .antMatchers("/hello").hasAnyAuthority("P5") //只有P5可以访问
//                .antMatchers("/say").hasRole("SELLER") //具有ROLE_ADMIN 角色才可以访问
//                .anyRequest().authenticated();//其他的资源登录之后就可以访问
        //允许所有账户都可访问（不登录即可访问）,同时可指定多个路径
//                .antMatchers("/register").permitAll()
        //开发方式1：基于配置
//                .antMatchers("/a1","/a2").hasRole("seller")//拥有seller角色的用户可访问a1和a2资源
        //拥有指定的任意角色都可以访问对应资源
//                .antMatchers("/b1").hasAnyRole("manager1","manager2")
        //用户任意指定的aa bb都可以访问c1资源
//                .antMatchers("/c1").hasAnyAuthority("aa","bb")
//                .antMatchers("/d").denyAll()//拒绝任意用户访问
//                .antMatchers("/e").anonymous()//允许匿名访问
        //指定IP可以访问
//                .antMatchers("/f").hasIpAddress("localhost")
//                .antMatchers("/hello").hasAuthority("P5") //具有P5权限才可以访问
//                .antMatchers("/say").hasRole("ADMIN") //具有ROLE_ADMIN 角色才可以访问
//                .anyRequest().authenticated(); //其他的资源登录之后就可以访问

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
