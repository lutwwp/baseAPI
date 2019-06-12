package com.wwp.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Controller
public class VlogController {

    //文件服务器
    @RequestMapping(value = "/video/{filename}.{suffix}")
    public OutputStream bf(@PathVariable String filename, HttpServletResponse response, @PathVariable String suffix) throws IOException {
        URL resource = this.getClass().getClassLoader().getResource("video");
        File file = new File(resource.getFile());
        String path = file.getAbsolutePath() + "/" + filename+"."+suffix;
        File vlogFile = new File(path);
        InputStream inputStream = new FileInputStream(vlogFile);
        //缓冲区优化
        byte[] bytes = IOUtils.toByteArray(inputStream);
        response.getOutputStream().write(bytes);
        return null;
    }
    @RequestMapping("/getVlogList")
    @ResponseBody
    public String getVlogList(HttpServletRequest request){
        //获取Vlog存储文件夹下的所有
        URL resource = this.getClass().getClassLoader().getResource("video");
        File file = new File(resource.getFile());
        //获取所有路径
        List<File> list = new ArrayList<>();
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File vlogFile:files
            ) {
                System.out.println(vlogFile);
                list.add(vlogFile);
            }
        }
        System.out.println(list.toString());
        return list.toString();
    }
}
