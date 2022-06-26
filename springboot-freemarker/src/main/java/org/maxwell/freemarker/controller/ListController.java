package org.maxwell.freemarker.controller;

import org.maxwell.freemarker.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/6/26 21:00
 */
@Controller
public class ListController {

    /**
     * 向Freemarker模型数据对象Map存放数据
     * 1.存放普通字符串 String
     * 2.存放对象数据 Student对象
     * 3.存放List集合 List<Student>
     * 4.存放Map集合  Map<String,Student>
     *
     * @param map Map<String, Object> FreeMarker需要的Map模型对象
     * @return
     */
    @GetMapping("/list")
    public String test(Model model) {
        Student student = new Student();
        student.setName("小明");
        student.setAge(18);
        //1.纯文本形式的参数
        model.addAttribute("name", "freemarker");
        //2.实体类相关的参数
        model.addAttribute("stu1", student);

        //2.1 小强对象模型数据
        Student stu1 = new Student();
        stu1.setName("小强");
        stu1.setAge(18);
        stu1.setMoney(1000.86f);
        stu1.setBirthday(new Date());
        //2.2 小红对象模型数据
        Student stu2 = new Student();
        stu2.setName("小红");
        stu2.setMoney(200.1f);
        stu2.setAge(19);
        //2.3 将两个对象模型数据存放到List集合中
        List<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);
        //2.4 向model中存放List集合数据
        model.addAttribute("stus", stus);

        //3. 创建Map数据
        HashMap<String, Student> stuMap = new HashMap<>();
        stuMap.put("stu1", stu1);
        stuMap.put("stu2", stu2);
        stuMap.put("stu3", student);
        // 3.1 向model中存放Map数据
        model.addAttribute("stuMap", stuMap);

        //返回模板文件名称
        return "02-list";
    }
}
