package org.maxwell.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.maxwell.freemarker.entity.Student;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/6/27 12:42
 */
public class FreeMarkerTest {

    @Test
    public void generateHtml() throws IOException, TemplateException {

        //1.构建freemarker配置类信息
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_20);

        //2.1freemarker配置类设置内容
        String filePath = Objects.requireNonNull(this.getClass().getResource("/templates/")).getPath();
        configuration.setDirectoryForTemplateLoading(new File(filePath));

        //2.2设置模板字符集
        configuration.setDefaultEncoding("utf-8");

        //3.获得模板对象（模板文件内容）
        Template template = configuration.getTemplate("01-basic.ftl");

        //4.获得数据模型
        Map<String, Object> dataMap = generateDataMap();

        //5.生成html页面
        String htmlString = FreeMarkerTemplateUtils.processTemplateIntoString(template, dataMap);
        //输出
        InputStream inputStream = IOUtils.toInputStream(htmlString, StandardCharsets.UTF_8);
        FileOutputStream outputStream = new FileOutputStream(new File("e:/01-basic.html"));
        IOUtils.copy(inputStream,outputStream);
    }

    /**
     *  生成model
     * @return
     */
    private Map<String, Object> generateDataMap() {
        Map<String, Object> result = new HashMap<>();
        //1.纯文本形式的参数
        result.put("name", "freemarker");
        //2.实体类相关的参数
        Student student = new Student();
        student.setName("小明");
        student.setAge(18);
        result.put("stu", student);
        return result;
    }

}
