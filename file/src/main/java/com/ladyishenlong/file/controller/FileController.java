package com.ladyishenlong.file.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2020/4/26 4:11 下午
 * 文件上传和下载
 */
@Slf4j
@RestController
public class FileController {


    //todo 记得关闭输入输出流
    @Value("${filePath}")
    private String filePath;

    /**
     * 文件上传
     *
     * @return
     */
    @PostMapping
    public Object upload(@RequestBody List<MultipartFile> files) {

        File targetFile = new File(filePath);

        //如果不存在，就创建文件夹
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        for (MultipartFile file : files) {
            try (FileOutputStream out = new FileOutputStream(
                    filePath + file.getOriginalFilename())) {
                out.write(file.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
                log.error("文件上传失败!");
                return "上传失败";
            }
        }


        log.info("文件上传成功!");
        return "上传成功";
    }


    /**
     * 文件下载
     *
     * @return
     */
    @GetMapping
    public Object download(HttpServletResponse response) throws Exception {

        File file = new File("/Users/ruanchenhao/WorkSpace/FileLoad/测试数据.docx");

        String fileName = file.getName();

        if (file.exists()) {
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + fileName + ";filename*=utf-8''"
                            + URLEncoder.encode(fileName, "utf-8"));

            byte[] buffer = new byte[1024];
            OutputStream os = null;
            try (FileInputStream fis = new FileInputStream(file);
                 BufferedInputStream bis = new BufferedInputStream(fis)) {
                os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }


}
