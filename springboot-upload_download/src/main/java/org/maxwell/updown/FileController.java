package org.maxwell.updown;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/10 14:12
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.upload.path}")
    private String downloadPath;

    @GetMapping("/download")
    public Object download(HttpServletResponse response, @RequestParam("filename") String filename) throws UnsupportedEncodingException {
        File file = new File(downloadPath + "/" + filename);
        if (!file.exists()) {
            return "下载文件不存在";
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("content-disposition", "attachment;filename=" + filename);

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            byte[] buff = new byte[1024];
            OutputStream os = response.getOutputStream();
            int i;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            return "下载失败";
        }
        return "下载成功";
    }

    @PostMapping("/upload")
    public Object upload(@RequestParam MultipartFile file) throws IOException {

        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //表单输入框中的名称
        String name = "==" + file.getName() + "==";
        System.out.println(name);
        //获取后缀名
        assert originalFilename != null;
        String sufixType = originalFilename.substring(originalFilename.lastIndexOf("."));

        //保存
        File f = new File("D:/down/");
        if (!f.exists()) {
            f.mkdir();
        }
        String localFile = "D:/down/" + System.currentTimeMillis() + sufixType;
        file.transferTo(new File(localFile));

        return "success";
    }


}
